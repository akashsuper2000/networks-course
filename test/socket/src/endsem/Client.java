package endsem;

import java.io.*; 
import java.net.*; 
import java.util.Scanner; 

public class Client 
{ 
	public static void main(String[] args) throws IOException 
	{ 
		try
		{ 
			Scanner scn = new Scanner(System.in); 
			
			InetAddress ip = InetAddress.getByName("localhost"); 
	
			Socket s = new Socket(ip, 5000); 
	
			DataInputStream dis = new DataInputStream(s.getInputStream()); 
			DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
	
			while (true) 
			{ 
				String tosend = scn.nextLine(); 
				dos.writeUTF(tosend); 
				
				System.out.println(dis.readUTF()); 
			} 
			
		}catch(Exception e){ 
			e.printStackTrace(); 
		} 
	} 
} 
