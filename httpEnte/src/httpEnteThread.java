
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class httpEnteThread
{
	
	httpEnteServer server;
	Socket s;
	
	// in / out streams
	PrintWriter out;
	Scanner in; 
	
	
	httpEnteThread(Socket newS, httpEnteServer newServer)
	{
		this.s = newS;
		this.server = newServer;
		
		 // in und out streams initialisieren
		try
		{
			 out = new PrintWriter(s.getOutputStream(), true);
			 in = new Scanner(s.getInputStream());
		}
		catch(IOException e)
		{
			server.log("Fehler beim Stream initialiseren im Thread!");
		}
		
		server.log("Thread laeuft.");
	}
	
	public void run()
	{
		try {
			processRequest(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void processRequest(Socket s) throws IOException
	{
		server.log("Verbindung von " + s.getRemoteSocketAddress());
		
		// Nehme Request entgegen:
		String req = in.nextLine();
		
		// Nach Leerzeichen zerlegen:
		String[] reqparts = req.split(" ");
		
		// Bad Requests ausfiltern, ggf. Fehlermeldung:
		if(reqparts.length != 3)
		{
			server.log("Request falscher Laenge: " + reqparts.length);
			show_bad_request();
		}
		else
		{
			if(!reqparts[0].equals("GET") || !reqparts[2].equals("HTTP/1.1"))
			{
				show_bad_request();
				server.log("Ungueltiger Request: (" + reqparts[0] + "//" + reqparts[2] + ")");
			}
			else
			{
				// request valide -> pfad auslesen und versuchen seite zu finden
				show_page(reqparts[1]);
			}
		}
		close();

	}
	
	protected void show_page(String path)
	{
		out.println("page: " + path);
	}
	
	protected void show_bad_request()
	{
		out.println("Bad Request!");
	}
	
	protected void close()
	{
		server.log("Ausgeliefert - beende Verbindung.");
		try {
			s.close();
		} catch (IOException e) {
			server.log("Fehler beim Schliessen eines Threads...");
		}
		server.log("Verbindung beendet.");
	}
	
	
			
}
