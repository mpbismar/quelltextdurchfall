
import java.io.*;
import java.net.*;

public class httpEnteThread
{

	httpEnteThread(httpEnteServer server)
	{
		
		
		Socket test = null;
		
		try {
			 test = new Socket("localhost", 31337);
			PrintWriter out = new PrintWriter(test.getOutputStream(), true);
			out.println("gulp.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			test.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
			
}
