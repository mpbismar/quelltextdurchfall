
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class httpEnteThread implements Runnable
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
	
	
	
	
	protected void show_page(String reqpath)
	{
		server.log("Request verlangt nach " + reqpath);
		
		// ggf. Sonderfaelle abfangen (zB. index)
		reqpath = parseSpecial(reqpath);
		
		String path = server.PagePath + reqpath;
		server.log("Suche Datei: " + path);
		
		File f = new File(path);
		
		// existiert die Datei? sonst 404
		if (!f.exists())
		{
			show_404();
		}
		else
		{
			send_found_header();
			load_page(f);		    
		}
	}
	
	
	protected void load_page(File f)
	{
		// Datei existiert, zeilenweise einlesen und mit dem Socket verschicken		
		
		Scanner sc;
		try {
			
			sc = new Scanner(f);
			String line;
			
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				//server.log("Debug: " + line );
				out.println(line);
				
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			show_404();
		}
	}
	
	protected String parseSpecial(String path)
	{
		if(path.equals("/"))
		{
			return "/index.htm";
		}
		else
			return path;
	}
	
	protected void show_bad_request()
	{
		out.println("HTTP/1.1 400 Bad Request");
		out.println("Content-Type: text/html; charset=UTF-8");
		load_page(new File(server.ErrorPath + "/400.htm"));
	}
	
	protected void show_404()
	{
		server.log("404!");
		out.println("HTTP/1.1 404 Not Found");
		out.println("Content-Type: text/html; charset=UTF-8");
		load_page(new File(server.ErrorPath + "/404.htm"));
	}
	
	protected void send_found_header()
	{
		out.println("HTTP/1.1 200 OK");
		out.println("Content-Type: text/html; charset=UTF-8");
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
