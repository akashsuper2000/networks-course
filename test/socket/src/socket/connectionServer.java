package socket;

import java.util.*;
import java.net.*;
import java.io.*;
class connectionServer{
 public static void main(String[ ] args){
	 Scanner in = new Scanner(System.in);
 try{
 String message = java.time.LocalDateTime.now().toString();
 int serverPortNumber = 5000;
 ServerSocket connectionSocket = new ServerSocket(serverPortNumber);
 Socket dataSocket = connectionSocket.accept();
 PrintStream socketOutput = new PrintStream(dataSocket.getOutputStream());
 socketOutput.println(message);
 System.out.println("sent response to client...");
 socketOutput.flush( );
 dataSocket.close( );
 connectionSocket.close( );
 }
 catch(Exception e){
 e.printStackTrace( );
 }
 }
 }