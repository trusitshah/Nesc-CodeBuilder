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
 * This class creates Receiver Object.
 * 
 * @author trusit
 *
 */
public class Receiver extends Object
{
	/**
	 * 
	 * @param AMId AMID of Radio.
	 */
	public Receiver(int AMId)
	{
		super("Receiver");
		
		Component AppCComponent = new Component("AppC");
		Interface ReceiveInternalInterface = new Interface("Receive");
		
		Component ReceiveComponent = new Component("AMReceiverC",true);
		ReceiveComponent.SetArgument(String.valueOf(AMId));
		
		AddComponent(ReceiveComponent);
		
		Interface ReceiveInterface = new Interface("Receive");
		AddInterface(ReceiveInterface);
		
		Connection ReceiveConnection = new Connection(ReceiveInterface, AppCComponent, ReceiveInternalInterface, ReceiveComponent);
		AddConnection(ReceiveConnection);
		
		Function ReceiveFunction = new Function("event message_t* "+ ReceiveInterface.GetName()+ ".receive(message_t* msg, void* payload, uint8_t len)");
		AddFunction(ReceiveFunction);
	}

}
