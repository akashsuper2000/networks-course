package endsem;

import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*; 

public class Server 
{ 
	public static void main(String[] args) throws IOException 
	{ 
		ServerSocket ss = new ServerSocket(5000); 
		
		while (true) 
		{ 
			Socket s = null; 
			
			try
			{ 
				s = ss.accept(); 
				
				System.out.println("Client connected: " + s); 
				
				DataInputStream dis = new DataInputStream(s.getInputStream()); 
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());  

				Thread t = new ClientHandler(s, dis, dos); 

				t.start(); 
				
			} 
			catch (Exception e){ 
				s.close(); 
				e.printStackTrace(); 
			} 
		} 
	} 
} 

class ClientHandler extends Thread 
{ 
	final DataInputStream dis; 
	final DataOutputStream dos; 
	final Socket s; 

	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) 
	{ 
		this.s = s; 
		this.dis = dis; 
		this.dos = dos; 
	} 

	@Override
	public void run() 
	{ 
		String received; 
		String toreturn; 
		while (true) 
		{ 
			try { 
				
				received = dis.readUTF(); 

				dos.writeUTF("Received message");
				System.out.println(received);
				
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
		} 
		
	} 
} 
