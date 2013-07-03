import java.io.*;
import java.net.*;


public class httpEnteServer {

	int port;
	String PagePath = "htDocs";
	String ErrorPath = "errorDocs";
	
	String serverName = "HTTP Ente v1";
	
	// Socket initialisieren
	ServerSocket serv = null;
	
	
	/**
	 * Konstruktor
	 * @param port
	 */
	httpEnteServer(int port)
	{
		this.port = port;
		connect();
	}
	
	

	
	/**
	 * erstellt den Socket und laesst ihn auf dem gewuenschten port lauschen
	 */
	protected void connect()
	{
		try
		{
			// Socket erstellen
			serv = new ServerSocket(port);
			log("Socket erstellt!");
			
			// jeder eingehenden Verbindung einen "Client"-Socket zuweisen
			listen();

			
		}
		catch(Exception e)
		{
			log("server konnte nicht erstellt werden: " + e);
		}
		finally
		{
			// Socket Schliessen
			try
			{
				serv.close();
				log("Verbindung ordnungsgemaess geschlossen.");
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	protected void listen() throws IOException
	{
		while(true)
		{
			log("Server lauscht.");
			Socket s = serv.accept();
			Thread t = new Thread(new httpEnteThread(s, this));
			t.run();
		}
	}
	
	
	public void log(String msg)
	{
		System.out.println("[" + this.serverName + " Port " + this.port + "] " + msg);
	}
}
