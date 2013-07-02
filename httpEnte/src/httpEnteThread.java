
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class httpEnteThread
{
	
	httpEnteServer server;
	Socket s;

	httpEnteThread(Socket newS, httpEnteServer newServer)
	{
		this.s = newS;
		this.server = newServer;
		
		server.log("Thread laeuft.");
	}
	
	public void run()
	{
		try {
			gulp(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void gulp(Socket s) throws IOException
	{
		//log("Verbindung von " + s.getRemoteSocketAddress());
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		
		Scanner scanny = new Scanner(s.getInputStream());
		String blub = scanny.nextLine();
		scanny.close();
		
		out.println("gulp. ausserdem: " + blub);
		server.log("Habe gulp gesendet. Beende nun Verbindung.");
		s.close();
		server.log("Verbindung beendet.");
	}
			
}
