# Carvalho-Roucairol-Mutex
This algorithm is written according to Technical Correspondence in   Communications of the ACM submitted by O.S.F. Carvalho and G. Roucairol.  *This algorithm is for solving Mutual Exclusion in Computer Networks which is   Optimized version of Ricart Agrawal algorithm.

Technical Specification (while Programming)
- Operating System: Windows 8.1
- Language: Java
- IDE: Eclipse Kepler

How to run?

1.	Export Java Class as JAR file. And copy it to utdallas drive of each nodes.

2.	Open putty and make connection from dc20.utdallas.edu to dc29.utdallas.edu.
	Node0 – dc20.utdallas.edu
	Node1 – dc21.utdallas.edu
	Node2 – dc22.utdallas.edu
	Node3 – dc23.utdallas.edu
	Node4 – dc24.utdallas.edu
	Node5 – dc25.utdallas.edu
	Node6 – dc26.utdallas.edu
	Node7 – dc27.utdallas.edu
	Node8 – dc28.utdallas.edu
	Node9 – dc29.utdallas.edu
	
3.	Open the folder in utdallas drive which contains the file called node.txt which is having Node number

4.	Execute the JAR file with following command from each above specified node in order from dc20 to dc29
java –jar main.jar

5.	The program will start executing it will terminates after few minutes automatically. The output file containing below information is recorded.
- Physical time for entering critical section 
- Total number of messages exchanged before entering critical section
- Latency 
- Total number of messages sent and received for successfully completion of phase 1 and phase 2

Java Classes

1.	CRMutex.java
This class is implemented to treat request and reply message, to request resource and reply to differed message. This class also contains methods to send REQUEST, REPLY, COMPLETE and SYSTEMDOWN messages to other nodes.

2.	NodeHandler.java
This class handles messages received on each channel.

3.	CriticalSection.java
This class knows when to enter critical section and when to exit critical section based on information given in Programming Assignment.

4.	Main.java
 This is main class which creates socket connection and create threads to listen to each port.
