package socket;

import java.net.*;
import java.io.*; 

public class cchat 
{ 
	private Socket socket		 = null;
	private DataInputStream input = null; 
	private DataOutputStream out	 = null; 

	public cchat(String address, int port) throws Exception 
	{ 
		try
		{ 
			socket = new Socket(address, port); 
			System.out.println("Connected"); 

			input = new DataInputStream(System.in); 

			out = new DataOutputStream(socket.getOutputStream()); 
		} 
		catch(UnknownHostException u) 
		{ 
			System.out.println(u); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 

		String line = ""; 
		
		while (true) 
		{ 
			try
			{ 
				line = input.readLine(); 
				out.writeUTF(line); 
				
			} 
			catch(IOException i) 
			{ 
				System.out.println(i); 
			} 
			
			try{
				InetAddress acceptorHost = InetAddress.getByName("127.0.0.1");
				 int serverPortNum = 5000;
				 Socket clientSocket = new Socket(acceptorHost, serverPortNum+1);
				 BufferedReader br = new BufferedReader(new
						  InputStreamReader(clientSocket.getInputStream( )));
				 System.out.println(br.readLine( ));
				 clientSocket.close();
			}
			catch(Exception i){}
		} 
	} 

	public static void main(String args[]) throws Exception 
	{ 
		cchat client = new cchat("127.0.0.1", 5000); 
	} 
} 