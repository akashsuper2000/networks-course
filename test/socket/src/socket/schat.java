package socket;

import java.io.*;
import java.net.*;
import java.util.*;

public class schat
{ 
	private Socket		 socket = null; 
	private ServerSocket server = null; 
	private DataInputStream in	 = null; 

	public schat(int port) 
	{ Scanner s = new Scanner(System.in);
		try
		{ 
			server = new ServerSocket(port); 
			System.out.println("Server started"); 

			System.out.println("Waiting for a client ..."); 

			socket = server.accept(); 
			System.out.println("Client accepted");
			System.out.println(socket.getInetAddress());
			
			socket = server.accept(); 
			System.out.println("Client accepted");
			System.out.println(socket.getInetAddress());
			
			socket = server.accept(); 
			System.out.println("Client accepted");
			System.out.println(socket.getInetAddress());

			in = new DataInputStream( 
				new BufferedInputStream(socket.getInputStream())); 
			ServerSocket connectionSocket = new ServerSocket(port+1);

			String line = ""; 

			while (true) 
			{ 
				try
				{ 
					Socket dataSocket = connectionSocket.accept();
					 PrintStream socketOutput = new PrintStream(dataSocket.getOutputStream());
					 socketOutput.println(s.nextLine());
				} 
				catch(IOException i) 
				{ 
					System.out.println(i); 
				} 
				
				try{
					line = in.readUTF(); 
					System.out.println(line); 
				}
				catch(Exception i){}
			} 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		schat server = new schat(5000); 
	} 
} 