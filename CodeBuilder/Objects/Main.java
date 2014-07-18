/* 
 * This file is the part of project CodeBuilder which is 
 * created for the creating NesC files (C and AppC) using 
 * graphics interface.
 *
 * Author : Trusit Shah
 * Date : 16-07-2014
 * 
 */

package CodeBuilder.Objects;
/**
 * This class is for the MainC Object of the file.
 * 
 * @author trusit
 *
 */
public class Main extends Object
{
	
	/**
	 * 
	 */
	public Main() 
	{
		super("Main");
		
		Component AppComponent = new Component("AppC");
		Interface MainInternalInterface = new Interface("Boot");
		
		Component MainComponent = new Component("MainC");
		AddComponent(MainComponent);
		
		Interface BootInterface = new Interface("Boot");
		AddInterface(BootInterface);
		
		Connection MainConnection = new Connection(BootInterface, AppComponent, MainInternalInterface, MainComponent);
		AddConnection(MainConnection);
		
		Function mainFunction = new Function("event void "+ BootInterface.GetName()+".booted()");
		AddFunction(mainFunction);

	}
}
