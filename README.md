# Carvalho-Roucairol-Mutex
This algorithm is written according to Technical Correspondence in   Communications of the ACM submitted by O.S.F. Carvalho and G. Roucairol.  *This algorithm is for solving Mutual Exclusion in Computer Networks which is   Optimized version of Ricart Agrawal algorithm.




Technical Specification (while Programming)
	Operating System: Windows 8.1
	Language: Java
	IDE: Eclipse Kepler
How to run?
1.	Export Java Class as JAR file. And copy it to utdallas drive of each nodes.
2.	Open putty and make connection from dc20.utdallas.edu to dc29.utdallas.edu.
	Node0 – dc20.utdallas.edu
	Node1 – dc21.utdallas.edu
	Node2 – dc22.utdallas.edu
	Node3 – dc23.utdallas.edu
	Node4 – dc24.utdallas.edu
	Node5 – dc25.utdallas.edu
	Node6 – dc26.utdallas.edu
	Node7 – dc27.utdallas.edu
	Node8 – dc28.utdallas.edu
	Node9 – dc29.utdallas.edu
3.	Open the folder in utdallas drive which contains the file called node.txt which is having Node number
4.	Execute the JAR file with following command from each above specified node in order from dc20 to dc29
java –jar main.jar
5.	The program will start executing it will terminates after few minutes automatically. The output file containing below information is recorded.
	Physical time for entering critical section 
	Total number of messages exchanged before entering critical section
	Latency 
	Total number of messages sent and received for successfully completion of phase 1 and phase 2
Java Classes
1.	CRMutex.java
This class is implemented to treat request and reply message, to request resource and reply to differed message. This class also contains methods to send REQUEST, REPLY, COMPLETE and SYSTEMDOWN messages to other nodes.
2.	NodeHandler.java
This class handles messages received on each channel.
3.	CriticalSection.java
This class knows when to enter critical section and when to exit critical section based on information given in Programming Assignment.
4.	Main.java
 This is main class which creates socket connection and create threads to listen to each port.
Data Collection:
1.	Latency 
CS	Node 0	Node 1	Node 2	Node 3	Node 4 	Node 5	Node 6	Node 7	Node 8	Node 9
1	4003	1002	3506	2506	2003	501	5003	4502	1500	3002
2	4001	4002	4503	4002	4001	4502	4502	4501	4002	4001
3	4501	4501	4504	4502	4501	4502	4001	4502	4502	4501
4	4001	4001	4002	4001	4001	4001	3501	4002	4501	4502
5	3501	3501	3002	3501	3501	3501	4001	4002	3501	3001
6	4501	4501	4502	4001	4501	4502	4502	4001	4501	4501
7	4501	4502	4503	5001	4501	4501	4501	4501	4501	4501
8	4001	4002	4003	4001	4501	4001	4502	4002	4502	4001
9	5002	4502	5004	4001	4001	4501	4503	5003	4502	4501
10	4001	4001	4503	4502	4001	4502	4003	4003	4502	4001
11	3501	3501	4003	4001	3501	4002	4002	3502	4001	4002
12	5001	4502	4503	4501	5001	4502	4503	5003	4501	4501
13	5501	5001	5504	4501	4501	5002	5003	5003	4501	5001
14	4001	4502	4003	4501	4501	5001	4503	4502	4501	4001
15	5002	4501	4503	5001	4501	4501	4504	5003	5001	4501
16	5002	5502	5002	5501	5001	5001	5003	4503	5501	5501
17	5001	4502	5003	5001	4501	5002	5503	5503	4501	5001
18	4501	5002	4503	4501	5001	5002	4003	4002	5001	4502
19	5001	4501	5003	4502	4501	4502	5003	5003	5001	5002
20	4001	4502	4002	4502	4501	5002	3504	3503	4001	4001
21	501	4502	501	4001	1001	4001	501	3502	500	4501
22	1001	3002	502	3501	500	3001	502	2002	500	2501
23	500	3501	503	3501	500	3501	501	3502	501	4001
24	500	2501	502	3000	500	2501	502	3001	501	2501
25	1000	3002	502	2501	500	2500	1001	4002	1001	3501
26	500	4001	502	4001	500	4001	502	2501	501	3000
27	500	3001	503	3501	501	3501	1001	4002	501	3501
28	500	3002	502	2501	501	3000	502	2501	1001	2501
29	500	3001	502	2501	501	3001	501	4002	501	4001
30	500	4501	502	5001	501	4001	502	3501	501	3501
31	1000	3001	502	3001	501	4001	501	3002	501	3001
32	500	3001	502	4001	501	3001	501	3001	501	3001
33	500	3001	502	2501	501	2501	501	2501	501	2501
34	500	2001	502	2501	500	2001	502	3002	501	3001
35	500	4001	501	3001	500	2501	502	4002	501	4001
36	500	3002	501	2501	500	4002	501	2501	500	2500
37	501	3001	501	4001	501	2501	500	3501	500	3501
38	500	3001	501	1501	500	3501	501	2502	501	2501
39	500	2501	501	3501	500	3001	501	2501	501	3000
40	501	2501	501	2001	501	2500	500	2001	500	2000


2.	Messages Exchanged for each Critical Section
CS	Node 0	Node 1	Node 2	Node 3	Node 4 	Node 5	Node 6	Node 7	Node 8	Node 9
1	18	18	18	18	18	18	18	18	18	18
2	18	18	18	18	18	18	18	18	18	18
3	16	18	18	18	18	18	18	18	18	18
4	18	18	18	18	18	18	18	18	18	18
5	18	18	18	18	18	18	18	18	18	18
6	18	18	18	18	18	18	18	18	18	18
7	18	18	18	18	18	18	18	18	18	18
8	18	18	18	18	18	18	18	18	18	18
9	18	18	18	18	18	18	18	18	18	18
10	18	16	18	18	18	18	18	18	18	18
11	18	18	18	18	17	18	18	18	18	18
12	18	18	18	18	18	18	18	18	18	18
13	18	18	18	18	18	18	18	18	18	18
14	18	18	18	18	18	18	18	18	18	18
15	18	18	18	18	18	18	18	18	18	18
16	18	18	18	18	18	18	18	18	18	18
17	18	18	18	18	18	18	18	18	18	18
18	18	18	18	18	18	18	18	18	18	18
19	18	18	18	18	18	18	18	18	18	18
20	18	16	18	18	18	18	18	18	18	18
21	18	17	18	18	18	18	18	15	18	18
22	18	16	18	14	18	16	18	13	18	15
23	18	14	18	15	18	15	18	16	18	12
24	18	13	18	15	18	13	18	15	18	18
25	18	17	18	14	18	17	18	15	18	16
26	18	17	18	16	18	14	18	15	18	15
27	18	12	18	17	18	16	18	13	18	14
28	18	17	18	13	18	16	18	16	18	18
29	18	16	18	17	18	18	18	18	18	18
30	18	16	18	14	18	15	18	18	18	15
31	18	17	18	18	18	14	18	13	18	14
32	18	14	18	15	18	18	18	12	18	14
33	18	18	18	13	18	15	18	18	18	18
34	18	11	18	14	18	10	18	18	18	15
35	18	14	18	18	18	18	18	13	18	13
36	18	18	14	15	18	16	12	12	8	14
37	8	15	8	13	8	17	8	18	8	18
38	8	13	8	14	8	10	8	13	8	12
39	8	14	8	16	7	18	8	17	8	17
40	8	15	8	13	7	14	8	12	8	14



3.	Total Number of Messages Exchanged on each node
Node	Sent 	Received
0	673	673
1	669	669
2	673	673
3	668	667
4	673	672
5	670	670
6	672	672
7	669	668
8	670	670
9	670	670


	In Phase 1, all the nodes are accessing the critical section at almost same speed. So latency and Number of Messages Exchanged are very high. For a single node it has to send 9 messages for request and 9 messages it received as reply till Critical Section 20. 
	In Phase 2 we have decreased speed of even number nodes and odd number nodes are requesting critical section at same speed. So you can identify the difference in latency and number of messages exchanged to enter critical section.
	After Critical Section 20, the number of messages and latency has decreased. The reason behind that is the optimized version of Ricarta Agrawal Algorithm. After all odd nodes has entered critical section, even nodes only have to communicate between even nodes because even node already have authorization from odd node to enter critical section. So even nodes will not wait for a reply from odd nodes which decreases number of messages exchanged and latency. 
