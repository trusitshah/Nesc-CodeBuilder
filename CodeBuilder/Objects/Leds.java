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
 * This class is to add the Leds in the code.
 * @author trusit
 *
 */
public class Leds extends Object
{
	/**
	 * 
	 */
	public Leds() 
	{
		super("Leds");
		
		Component AppComponent = new Component("AppC");
		Interface LedsInternalInterface = new Interface("Leds");

		Component LedsComponent = new Component("LedsC");
		AddComponent(LedsComponent);
		
		Interface LedsInterface = new Interface("Leds");
		AddInterface(LedsInterface);
		
		Connection LedsConnection = new Connection(LedsInterface, AppComponent, LedsInternalInterface, LedsComponent);
		AddConnection(LedsConnection);
	}

}
