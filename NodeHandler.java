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
 *Class: NodeHandler
 *This class handles messages received on each channel.
 */


package aos1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NodeHandler implements Runnable {
	
	
	Socket socket;
	BufferedReader reader;
	PrintWriter writer;
	CRMutex crmutex;

	public NodeHandler(Socket s, CRMutex crmutex){
		try{
			this.crmutex = crmutex;
			socket = s;
			InputStreamReader iReader = new InputStreamReader(socket.getInputStream());
			reader = new BufferedReader(iReader);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
	
	public void run() {
		
		//System.out.println("Thread started at "+ me + "and for " +sock);
		String msg;
	
		try {
			while ((msg = reader.readLine()) != null){								// Read Message from Channel
			//System.out.println("I am Node . I got this: "+msg);
			String text[] = msg.split(",");
			//System.out.println(text[0]);
			
			if (text[0].equals("Request")){											// Request Message Received
			//	System.out.println("Treating Request Resources");
				crmutex.treatRequestResource(Integer.parseInt(text[1]),Integer.parseInt(text[2]) );
				crmutex.totalMsgReceived++;
			}
			else if (text[0].equals("Reply")){										// Reply Message Received
			//	System.out.println("Treating Reply Resources");
				crmutex.treatReplyResource(Integer.parseInt(text[1]));
				crmutex.totalMsgReceived++;
				crmutex.msgReceived++;
			}
			else if (text[0].equals("Complete")){									// Complete Message Received
				crmutex.treatCompleteMsg(Integer.parseInt(text[1]));
			}
			
			else if (text[0].equals("SystemDown")){									// System Down Message Received
				System.exit(0); 
			}
			
		}
	} 
	catch (IOException e) {
		e.printStackTrace();
	}
}
}
