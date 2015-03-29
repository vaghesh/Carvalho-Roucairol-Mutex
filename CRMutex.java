/*
 *This algorithm is written according to Technical Correspondence in 
 *Communications of the ACM submitted by O.S.F. Carvalho and G. Roucairol.
 *This algorithm is for solving Mutual Exclusion in Computer Networks which is 
 *Optimized version of Ricart Agrawal algorithm.
*/

/*
 * Program by: Vaghesh Patel
 * Class: Advanced Operating System
 * Spring 2015
 * Email: vaghesh@gmail.com
 */

/*
 * Class: Carvalho and Roucairol Mutual Excusion (CRMutex)
 * This class is implemented to treat request and reply meassage, to request resource and reply to deffered message. 
 * This class also contains methods to send REQUEST, REPLY, COMPLETE and SYSTEMDOWN messages to other nodes.
 */

package aos1;

import java.io.PrintWriter;

public class CRMutex {

	// Shared Databases
	
	public int me;
	public int N = 10;
	
	public int ourSeqNum;
	public int highSeqNum;
	
	public boolean[] replyDef;
	public boolean[] A;
	public boolean waiting;
	public boolean using;
	public boolean[] complete;

	// Other Variables
	public PrintWriter[] writer;
	
	public int totalMsgSent;
	public int totalMsgReceived;
	public int msgSent;
	public int msgReceived;
	
	
	//Initializing CRMutex Algorithm
	public CRMutex(int me, int ourSeqNum){
		this.me = me;
		this.ourSeqNum = ourSeqNum;
		
		replyDef = new boolean[N];
		A = new boolean[N];
		complete = new boolean[N];
		
		using = false;
		waiting = false;
		
		
		writer = new PrintWriter[N];
	
	}
	
	// Method to Request Resources by sending Request Message to each node
	public boolean requestResource(){
		waiting = true;
		ourSeqNum = highSeqNum + 1;
		//for (int i=0; i < N ; i++){
			//System.out.println("A[" +i+ "]: " + A[i]);
		//}
		
		for (int i=0; i<N; i++){
			if (i != me & (!A[i])){
				sendRequest (ourSeqNum,me,i); 
			}
		}
		
		A[me] = true;
		for (int i=0; i <N; i++){
			while (!A[i])
			{
				try {
					Thread.sleep(500);
					
					//for (int j=0; j < N ; j++){
				//		System.out.println("A[" +j+ "]: " + A[j]);
				//	}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		waiting = false;
		using = true;
		return true;
	}
	
	// Method to Release Resources after using it and replying back to each method whose reply is deferred
	public void releaseResource(){
		using = false;
		
		for (int i=0; i < N; i++){
			if (replyDef[i]){
				A[i] = false;
				replyDef[i] = false;
				sendReply(i);
			}
		}
	}

	// Method to treat when mode get Reply message from other nodes
	public void treatReplyResource(int i){
		//System.out.println("Treating Reply message for node " +i+ " and making it true");
		A[i] = true;
		//System.out.println("A" +i+ "is "+A[i]);
	}
	
	// Method to treat when node get Request message
	public void treatRequestResource(int theirSeqNum, int i){
		
		boolean ourPriority = false;
		highSeqNum = Math.max(highSeqNum, theirSeqNum);
		ourPriority = (theirSeqNum > ourSeqNum) || ((theirSeqNum == ourSeqNum) && (i>me));
		
		if (using || (waiting && ourPriority)){
			replyDef[i] = true;
		}
		
		if (!(using || waiting) || (waiting && (!A[i]) && (!ourPriority))){
			A[i] = false;
			sendReply(i);
		}
		
		if (waiting && A[i] && (!ourPriority)){
			A[i] = false;
			sendReply(i);
			sendRequest(ourSeqNum, me, i);
		}
		
	}
	
	// Method to send Reply message 
	private void sendReply(int i) {
		//System.out.println("Sending reply to node " + i);
		writer[i].println("Reply," + me + ","+ i);
		totalMsgSent++;
	}

	// Method to send Request message
	private void sendRequest(int ourSeqNum, int me, int i) {
		//System.out.println("Sending Request to node" + i + "," +ourSeqNum);
		writer[i].println("Request," +ourSeqNum+ "," + me + "," + i);
		totalMsgSent++;
		msgSent++;
	}
	
	// Method to send Complete message to Node 0
	public void sendComplete(){
		writer[0].println("Complete," +me);
	}
	
	// Method to treat received complete message
	public void treatCompleteMsg(int i){
		complete[i] = true; 
	}
	
	// Method to bring whole system down after receiving complete message from every nodes.
	public void systemDown(){
		for (int i=0; i<N; i++){
				while (!complete[i])
				{
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		}
		
		for (int i=0; i<N; i++){
			if (i != me){
				sendSystemDown(i); 
			}
		}
		
		System.exit(0);
	}
	
	// Method to send System Down Message to stop all threads.
	public void sendSystemDown(int i){
		writer[i].println("SystemDown");
	}
}
