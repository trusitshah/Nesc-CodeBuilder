package CodeBuilder.test;
import CodeBuilder.Objects.*;
import CodeBuilder.Objects.Object;
import CodeBuilder.WriteFiles.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * This is test file which is created to just test the classes during the 
 * development phase.
 * 
 * @author trusit
 * @since 29-06-2014
 * @version 1.0
 * 
 */
public class Test
{
	public static void main(String args[]) throws IOException
	{
		System.out.println("Hello World: This is test");
		WriteCFile wfc = new WriteCFile("test","/home/trusit/tiny_os/NESCGUI");
		
		int error = wfc.CreateFile();
		
		if(error == WriteFile.SUCCESS_FILE_CREATE)
		{
			System.out.println("C Successfully file created");
		}
		else if (error == WriteFile.ERROR_FILE_EXIST)
		{
			System.out.println("C File Already exists");
			return;
		}
		else
		{
			System.out.println("C File Creation error");
			return;
		}

		WriteAppCFile wfappc = new WriteAppCFile("test","/home/trusit/tiny_os/NESCGUI");
		
		int error1 = wfappc.CreateFile();
		
		if(error1 == WriteFile.SUCCESS_FILE_CREATE)
		{
			System.out.println("AppC file Successfully file created");
		}
		else if (error1 == WriteFile.ERROR_FILE_EXIST)
		{
			System.out.println("AppC File Already exists");
			return;
		}
		else
		{
			System.out.println("AppC File Creation error");
			return;
		}
		
		ArrayList<Object>Objects = new ArrayList<Object>();
		Timer t = new Timer();
		Timer t1 = new Timer("Timer1","Timer1");
		Main m = new Main();
		Leds l = new Leds();
		Sender s = new Sender(6);
		AMControl am = new AMControl();
		Receiver r = new Receiver(6);
		
		Objects.add(m);
		Objects.add(t);
		Objects.add(t1);
		Objects.add(l);
		Objects.add(am);
		Objects.add(s);
		Objects.add(r);
		
		wfc.WriteFile(Objects);

		wfappc.WriteFile(Objects);
		
	}
}
