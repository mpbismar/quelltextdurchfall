
public class httpEnteRunner {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public void main(String[] args) {
		
		if(args.length != 1)
		{
			usage();
		}
		else
		{
			int port = 80;
			try
			{
				port = new Integer(args[0]);
				httpEnteServer serv1 = new httpEnteServer(port);
			}
			catch(NumberFormatException e)
			{
				usage();
			}		

		}
	}
	
	public static void usage()
	{
		System.out.println("HTTP Ente v1");
		System.out.println("Usage: <runner> port");
	}

		
		
}
