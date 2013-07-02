import java.io.*;
import java.net.*;


public class httpEnteServer {

	int port;
	
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
	
	
	protected void gulp(Socket s) throws IOException
	{
		//log("Verbindung von " + s.getRemoteSocketAddress());
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println("gulp.");
		log("Habe gulp gesendet. Beende nun Verbindung.");
		s.close();
		log("Verbindung beendet.");
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
			
			for(int i = 0; i < 10; i++)
			{
				log("Server lauscht.");
				Socket acceptor = serv.accept();
				gulp(acceptor);
			}
			
		}
		catch(Exception e)
		{
			
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
	
	
	public void log(String msg)
	{
		System.out.println("[" + this.serverName + " Port " + this.port + "] " + msg);
	}
}
