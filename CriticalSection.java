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
 * Class: Critical Section
 * This class knows when to enter critical section and when to exit critical section based on information given in Programming Assignment
 */




package aos1;

import java.util.Random;

public class CriticalSection {
	
	CRMutex crmutex;
	int me;
	
	public void cs(int me, CRMutex crmutex)
	{
	this.me = me;	
	int csTimes = 40;
	
	for (int i = 0; i < (csTimes-20); i++){
		
		//for (int j=0; j < N ; j++){
		//	System.out.println("A[" +j+ "]: " + crmutex.A[j]);
		//}
		
		int time = randInt(5, 10);
		try {
			Thread.sleep(time*100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		long startTime = System.currentTimeMillis();
		crmutex.msgSent = 0;
		crmutex.msgReceived = 0;
		
		crmutex.requestResource();
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Time Taken for entering Critical Section(Latency): " +totalTime);
		System.out.print("Entering Critical Section.Node " +me+ " and Physical time is ");
		System.out.println(System.currentTimeMillis());
		System.out.println("Total Msgs Exchanged are "+(crmutex.msgReceived+crmutex.msgSent));
		try {
			Thread.sleep(3*100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//System.out.println("Total Msgs Exchanged are "+(crmutex.msgReceived+crmutex.msgSent));
		
		crmutex.releaseResource();
	}
	
	if(me % 2 == 0){
		for (int i = 0; i < (csTimes-20); i++){
			int time = randInt(45, 50);
			
			try {
				Thread.sleep(time*100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long startTime = System.currentTimeMillis();
			crmutex.msgSent = 0;
			crmutex.msgReceived = 0;
			
			crmutex.requestResource();
			
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("Time Taken for entering Critical Section(Latency): " +totalTime);
			System.out.print("Entering Critical Section.Node " +me+ " and Physical time is ");
			System.out.println(System.currentTimeMillis());
			System.out.println("Total Msgs Exchanged are "+(crmutex.msgReceived+crmutex.msgSent));
			
			try {
				Thread.sleep(3*100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//System.out.println("Total Msgs Exchanged are "+(crmutex.msgReceived+crmutex.msgSent));
			crmutex.releaseResource();
	}
	}
	
	else{
		for (int i = 0; i < (csTimes-20); i++){
				int time = randInt(5, 10);
				
				try {
					Thread.sleep(time*100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				
				}
				
				long startTime = System.currentTimeMillis();
				crmutex.msgSent = 0;
				crmutex.msgReceived = 0;
				
				crmutex.requestResource();
				
				long endTime   = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				System.out.println("Time Taken for entering Critical Section(Latency): " +totalTime);
				System.out.print("Entering Critical Section.Node " +me+ " and Physical time is ");
				System.out.println(System.currentTimeMillis());
				System.out.println("Total Msgs Exchanged are "+(crmutex.msgReceived+crmutex.msgSent));
				
				try {
					Thread.sleep(3*100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				crmutex.releaseResource();
		}
	}
	
	
	System.out.println("-----------------------------------------------------------");
	System.out.println("Total Message Sent: " +crmutex.totalMsgSent );
	System.out.println("Total Message Received: " +crmutex.totalMsgReceived );
	if (me != 0){
		crmutex.sendComplete();
	}
	else{
		crmutex.complete[me] = true;
		crmutex.systemDown();
	}
	return;
	}
	
	// Method to Generate Random Variable
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
}

