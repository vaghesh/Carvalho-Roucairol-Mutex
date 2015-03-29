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
 *Class: Main Class
 *This is main class which creates socket connection and create threads to listen to each port.
 *This class interacts with all other classes.  
 */

package aos1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;





public class main {

	// Variable Declaration
	
	int N = 9;
	int me;
	
	PrintWriter writer0;
	PrintWriter writer1;
	PrintWriter writer2;
	PrintWriter writer3;
	PrintWriter writer4;
	PrintWriter writer5;
	PrintWriter writer6;
	PrintWriter writer7;
	PrintWriter writer8;
	PrintWriter writer9;
	
	BufferedReader reader0;
	BufferedReader reader1;
	BufferedReader reader2;
	BufferedReader reader3;
	BufferedReader reader4;
	BufferedReader reader5;
	BufferedReader reader6;
	BufferedReader reader7;
	BufferedReader reader8;
	BufferedReader reader9;

	CRMutex crmutex;
	
	ArrayList<PrintWriter> outputStreams = new ArrayList<PrintWriter>();
	

	
	public main() throws NumberFormatException, IOException {
		File file = new File("output.txt");
		FileOutputStream fis = new FileOutputStream(file);
		PrintStream out = new PrintStream(fis);
		System.setOut(out);
		
		me = myNodeNum();
		//System.out.println("I am Node "+ me );
	try
	{	
		ServerSocket server0;
		ServerSocket server1;
		ServerSocket server2;
		ServerSocket server3;
		ServerSocket server4;
		ServerSocket server5;
		ServerSocket server6;
		ServerSocket server7;
		ServerSocket server8;
		ServerSocket server9;
		
		Socket client0 = null;
		Socket client1 = null;
		Socket client2 = null;
		Socket client3 = null;
		Socket client4 = null;
		Socket client5 = null;
		Socket client6 = null;
		Socket client7 = null;
		Socket client8 = null;
		Socket client9 = null;
		Socket client10 = null;
		
		if (me == 0){
			System.out.println("This is Node 0");
			
			server0 = new ServerSocket(8880);
			server1 = new ServerSocket(8881);
			server2 = new ServerSocket(8882);
			server3 = new ServerSocket(8883);
			server4 = new ServerSocket(8884);
			server5 = new ServerSocket(8885);
			server6 = new ServerSocket(8886);
			server7 = new ServerSocket(8887);
			server8 = new ServerSocket(8888);
			server9 = new ServerSocket(8889);
			client0 = new Socket("dc20.utdallas.edu",8880);
			client10 = server0.accept();
			client1 = server1.accept();
			client2 = server2.accept();
			client3 = server3.accept();
			client4 = server4.accept();
			client5 = server5.accept();
			client6 = server6.accept();
			client7 = server7.accept();
			client8 = server8.accept();
			client9 = server9.accept();
		}
		else if(me == 1){
			System.out.println("This is Node 1");
			
			client0 = new Socket("dc20.utdallas.edu",8881); 
			server1 = new ServerSocket(8881);
			server2 = new ServerSocket(8882);
			server3 = new ServerSocket(8883);
			server4 = new ServerSocket(8884);
			server5 = new ServerSocket(8885);
			server6 = new ServerSocket(8886);
			server7 = new ServerSocket(8887);
			server8 = new ServerSocket(8888);
			server9 = new ServerSocket(8889);
			client1 = new Socket("dc21.utdallas.edu",8881);
			client10 = server1.accept();
			client2 = server2.accept();
			client3 = server3.accept();
			client4 = server4.accept();
			client5 = server5.accept();
			client6 = server6.accept();
			client7 = server7.accept();
			client8 = server8.accept();
			client9 = server9.accept();
		}
		else if(me == 2){
			System.out.println("This is Node 2");
			
			client0 = new Socket("dc20.utdallas.edu",8882);
			client1 = new Socket("dc21.utdallas.edu",8882);
			server2 = new ServerSocket(8882);
			server3 = new ServerSocket(8883);
			server4 = new ServerSocket(8884);
			server5 = new ServerSocket(8885);
			server6 = new ServerSocket(8886);
			server7 = new ServerSocket(8887);
			server8 = new ServerSocket(8888);
			server9 = new ServerSocket(8889);
			client2 = new Socket("dc22.utdallas.edu",8882);
			client10 = server2.accept();
			client3 = server3.accept();
			client4 = server4.accept();
			client5 = server5.accept();
			client6 = server6.accept();
			client7 = server7.accept();
			client8 = server8.accept();
			client9 = server9.accept();
			
		}
		else if(me == 3){
			System.out.println("This is Node 3");
			client0 = new Socket("dc20.utdallas.edu",8883);
			client1 = new Socket("dc21.utdallas.edu",8883);
			client2 = new Socket("dc22.utdallas.edu",8883);
			server3 = new ServerSocket(8883);
			server4 = new ServerSocket(8884);
			server5 = new ServerSocket(8885);
			server6 = new ServerSocket(8886);
			server7 = new ServerSocket(8887);
			server8 = new ServerSocket(8888);
			server9 = new ServerSocket(8889);
			client3 = new Socket("dc23.utdallas.edu",8883);
			client10 = server3.accept();
			client4 = server4.accept();
			client5 = server5.accept();
			client6 = server6.accept();
			client7 = server7.accept();
			client8 = server8.accept();
			client9 = server9.accept();
			
		}
		else if(me == 4){
			System.out.println("This is Node 4");
			client0 = new Socket("dc20.utdallas.edu",8884);
			client1 = new Socket("dc21.utdallas.edu",8884);
			client2 = new Socket("dc22.utdallas.edu",8884);
			client3 = new Socket("dc23.utdallas.edu",8884);
			server4 = new ServerSocket(8884);
			server5 = new ServerSocket(8885);
			server6 = new ServerSocket(8886);
			server7 = new ServerSocket(8887);
			server8 = new ServerSocket(8888);
			server9 = new ServerSocket(8889);
			client4 = new Socket("dc24.utdallas.edu",8884);
			client10 = server4.accept();
			client5 = server5.accept();
			client6 = server6.accept();
			client7 = server7.accept();
			client8 = server8.accept();
			client9 = server9.accept();
	
		}
		else if(me == 5){
			System.out.println("This is Node 5");
			client0 = new Socket("dc20.utdallas.edu",8885);
			client1 = new Socket("dc21.utdallas.edu",8885);
			client2 = new Socket("dc22.utdallas.edu",8885);
			client3 = new Socket("dc23.utdallas.edu",8885);
			client4 = new Socket("dc24.utdallas.edu",8885);
			server5 = new ServerSocket(8885);
			server6 = new ServerSocket(8886);
			server7 = new ServerSocket(8887);
			server8 = new ServerSocket(8888);
			server9 = new ServerSocket(8889);
			client5 = new Socket("dc25.utdallas.edu",8885);
			client10 = server5.accept();
			client6 = server6.accept();
			client7 = server7.accept();
			client8 = server8.accept();
			client9 = server9.accept();
	
		}
		else if(me == 6){
			System.out.println("This is Node 6");
			client0 = new Socket("dc20.utdallas.edu",8886);
			client1 = new Socket("dc21.utdallas.edu",8886);
			client2 = new Socket("dc22.utdallas.edu",8886);
			client3 = new Socket("dc23.utdallas.edu",8886);
			client4 = new Socket("dc24.utdallas.edu",8886);
			client5 = new Socket("dc25.utdallas.edu",8886);
			server6 = new ServerSocket(8886);
			server7 = new ServerSocket(8887);
			server8 = new ServerSocket(8888);
			server9 = new ServerSocket(8889);
			client6 = new Socket("dc26.utdallas.edu",8886);
			client10 = server6.accept();
			client7 = server7.accept();
			client8 = server8.accept();
			client9 = server9.accept();
	
		}
		else if(me == 7){
			System.out.println("This is Node 7");
			client0 = new Socket("dc20.utdallas.edu",8887);
			client1 = new Socket("dc21.utdallas.edu",8887);
			client2 = new Socket("dc22.utdallas.edu",8887);
			client3 = new Socket("dc23.utdallas.edu",8887);
			client4 = new Socket("dc24.utdallas.edu",8887);
			client5 = new Socket("dc25.utdallas.edu",8887);
			client6 = new Socket("dc26.utdallas.edu",8887);
			server7 = new ServerSocket(8887);
			server8 = new ServerSocket(8888);
			server9 = new ServerSocket(8889);
			client7 = new Socket("dc27.utdallas.edu",8887);
			client10 = server7.accept();
			client8 = server8.accept();
			client9 = server9.accept();
	
		}
		else if(me == 8){
			System.out.println("This is Node 8");
			client0 = new Socket("dc20.utdallas.edu",8888);
			client1 = new Socket("dc21.utdallas.edu",8888);
			client2 = new Socket("dc22.utdallas.edu",8888);
			client3 = new Socket("dc23.utdallas.edu",8888);
			client4 = new Socket("dc24.utdallas.edu",8888);
			client5 = new Socket("dc25.utdallas.edu",8888);
			client6 = new Socket("dc26.utdallas.edu",8888);
			client7 = new Socket("dc27.utdallas.edu",8888);
			server8 = new ServerSocket(8888);
			server9 = new ServerSocket(8889);
			client8 = new Socket("dc28.utdallas.edu",8888);
			client10 = server8.accept();
			client9 = server9.accept();
		}
		else if(me == 9){
			System.out.println("This is Node 9");
			client0 = new Socket("dc20.utdallas.edu",8889);
			client1 = new Socket("dc21.utdallas.edu",8889);
			client2 = new Socket("dc22.utdallas.edu",8889);
			client3 = new Socket("dc23.utdallas.edu",8889);
			client4 = new Socket("dc24.utdallas.edu",8889);
			client5 = new Socket("dc25.utdallas.edu",8889);
			client6 = new Socket("dc26.utdallas.edu",8889);
			client7 = new Socket("dc27.utdallas.edu",8889);
			client8 = new Socket("dc28.utdallas.edu",8889);
			server9 = new ServerSocket(8889);
			client9 = new Socket("dc29.utdallas.edu",8889);	
			client10 = server9.accept();
		}
		
		System.out.println("All Socket are Created. Start Communication");
		
		writer0 = new PrintWriter(client0.getOutputStream(),true);
		writer1 = new PrintWriter(client1.getOutputStream(),true);
		writer2 = new PrintWriter(client2.getOutputStream(),true);
		writer3 = new PrintWriter(client3.getOutputStream(),true);
		writer4 = new PrintWriter(client4.getOutputStream(),true);
		writer5 = new PrintWriter(client5.getOutputStream(),true);
		writer6 = new PrintWriter(client6.getOutputStream(),true);
		writer7 = new PrintWriter(client7.getOutputStream(),true);
		writer8 = new PrintWriter(client8.getOutputStream(),true);
		writer9 = new PrintWriter(client9.getOutputStream(),true);
		
		reader0 = new BufferedReader(new InputStreamReader(client0.getInputStream())); 
		reader1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
		reader2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
		reader3 = new BufferedReader(new InputStreamReader(client3.getInputStream()));
		reader4 = new BufferedReader(new InputStreamReader(client4.getInputStream()));
		reader5 = new BufferedReader(new InputStreamReader(client5.getInputStream()));
		reader6 = new BufferedReader(new InputStreamReader(client6.getInputStream()));
		reader7 = new BufferedReader(new InputStreamReader(client7.getInputStream()));
		reader8 = new BufferedReader(new InputStreamReader(client8.getInputStream()));
		reader9 = new BufferedReader(new InputStreamReader(client9.getInputStream()));

		outputStreams.add(writer0);
		outputStreams.add(writer1);
		outputStreams.add(writer2);
		outputStreams.add(writer3);
		outputStreams.add(writer4);
		outputStreams.add(writer5);
		outputStreams.add(writer6);
		outputStreams.add(writer7);
		outputStreams.add(writer8);
		outputStreams.add(writer9);
		
		//System.out.println(outputStreams);
		
			
		crmutex = new CRMutex(me, 0);
		crmutex.writer[0] = writer0;
		crmutex.writer[1] = writer1;
		crmutex.writer[2] = writer2;
		crmutex.writer[3] = writer3;
		crmutex.writer[4] = writer4;
		crmutex.writer[5] = writer5;
		crmutex.writer[6] = writer6;
		crmutex.writer[7] = writer7;
		crmutex.writer[8] = writer8;
		crmutex.writer[9] = writer9;
		
		System.out.println("Going to start thread");
		
		Thread t0 = new Thread(new NodeHandler(client0,crmutex));
		t0.start();
		Thread t1 = new Thread(new NodeHandler(client1,crmutex));
		t1.start();
		Thread t2 = new Thread(new NodeHandler(client2,crmutex));
		t2.start();
		Thread t3 = new Thread(new NodeHandler(client3,crmutex));
		t3.start();
		Thread t4 = new Thread(new NodeHandler(client4,crmutex));
		t4.start();
		Thread t5 = new Thread(new NodeHandler(client5,crmutex));
		t5.start();
		Thread t6 = new Thread(new NodeHandler(client6,crmutex));
		t6.start();
		Thread t7 = new Thread(new NodeHandler(client7,crmutex));
		t7.start();
		Thread t8 = new Thread(new NodeHandler(client8,crmutex));
		t8.start();
		Thread t9 = new Thread(new NodeHandler(client9,crmutex));
		t9.start();
		System.out.println("All thread started");

		Thread.sleep(1000);
		
		
		CriticalSection cs = new CriticalSection();
		cs.cs(me,crmutex);
		
		return;
	}
	catch(Exception e){
		e.printStackTrace();
	}
}


 // Method to read Node Number from the file
	private int myNodeNum() throws NumberFormatException, IOException {
		File file = new File("node.txt");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;
			  while ((text = reader.readLine()) != null) {
			      int x = Integer.parseInt(text);   
				  return x;
			    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 10;
	}
	
	
	
	public static void main (String args[]){
		try {
			new main();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}