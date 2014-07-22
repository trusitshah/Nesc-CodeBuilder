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
 * This class create a timer object.
 * @author trusit
 *
 */
public class Timer extends Object
{
	/**
	 * 
	 */
	public Timer()
	{
		super("Timer");
		
		Component AppComponent = new Component("AppC");
		Interface TimerInternalInterface = new Interface("Timer");
		
		Component TimerComponent = new Component("TimerMilliC",true);
		AddComponent(TimerComponent);
		
		Interface TimerInterface = new Interface("Timer");
		TimerInterface.SetPrecision("TMilli");
		AddInterface(TimerInterface);
		
		Connection TimerConnection = new Connection(TimerInterface,AppComponent, TimerInternalInterface, TimerComponent);
		AddConnection(TimerConnection);
		
		Function TimerFunction = new Function("event void "+TimerInterface.GetName()+".fired()");
		AddFunction(TimerFunction);
	}
	
	/**
	 * 
	 * @param InterfaceName Interface Name 
	 * @param ComponentName Component Name
	 */
	public Timer(String Name)
	{
		super("Timer",Name);
		
		Component AppComponent = new Component("AppC");
		Interface TimerInternalInterface = new Interface("Timer");
		
		Component TimerComponent = new Component("TimerMilliC",Name,true);
		AddComponent(TimerComponent);
		
		Interface TimerInterface = new Interface("Timer",Name);
		TimerInterface.SetPrecision("TMilli");
		AddInterface(TimerInterface);
		
		Connection TimerConnection = new Connection(TimerInterface,AppComponent, TimerInternalInterface, TimerComponent);
		AddConnection(TimerConnection);
		
		Function TimerFunction = new Function("event void "+TimerInterface.GetName()+".fired()");
		AddFunction(TimerFunction);
	}
}
