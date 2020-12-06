package socket;

import java.util.*;
import java.net.*; 
import java.io.*;
class connectionClient{
 public static void main(String[ ] args){
	 Scanner in = new Scanner(System.in);
 try{
 InetAddress acceptorHost = InetAddress.getByName("127.0.0.1");
 int serverPortNum = 5000;
 Socket clientSocket = new Socket(acceptorHost, serverPortNum);
 BufferedReader br = new BufferedReader(new
		  InputStreamReader(clientSocket.getInputStream( )));
 System.out.println(br.readLine( ));
 clientSocket.close();
 }
 catch(Exception e){
 e.printStackTrace( );
 }
 }
 }