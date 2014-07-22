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
 * This class creates object AMControl which is 
 * used for the Radio start and stop.
 * 
 * @author trusit
 *
 */
public class AMControl extends Object
{
	/**
	 * 
	 */
	public AMControl()
	{
		super("AMControl");
		
		Component AppComponent = new Component("AppC");
		Interface AMControlInternalInterface = new Interface("SplitControl");
		
		Component ActiveMessageComponent = new Component("ActiveMessageC");
		AddComponent(ActiveMessageComponent);
		
		Interface SplitControlInterface = new Interface("SplitControl", "AMControl");
		AddInterface(SplitControlInterface);
		
		Connection SplitControlConnection = new Connection(SplitControlInterface, AppComponent, AMControlInternalInterface, ActiveMessageComponent);
		AddConnection(SplitControlConnection);
		
		Function SplitControlStartFunction = new Function("event void "+ SplitControlInterface.GetName()+".startDone(error_t err)");
		AddFunction(SplitControlStartFunction);

		Function SplitControlStopFunction = new Function("event void "+ SplitControlInterface.GetName()+".stopDone(error_t err)");
		AddFunction(SplitControlStopFunction);	
	}

}
