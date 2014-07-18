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
 * This class creates object for sending data over radio.
 * @author trusit
 *
 */
public class Sender extends Object
{
	/**
	 * 
	 * @param AMId AMID of the radio.
	 */
	public Sender(int AMId) 
	{
		super("Sender");
		
		Component AppComponent = new Component("AppC");
		Interface PacketInternalInterface = new Interface("Packet");
		Interface AMPacketInternalInterface = new Interface("AMPacket");
		Interface AMSendInternalInterface = new Interface("AMSend");
		
		Component AMSenderComponent = new Component("AMSenderC", true);
		AMSenderComponent.SetArgument(String.valueOf(AMId));
		
		AddComponent(AMSenderComponent);

		Interface PacketInterface = new Interface("Packet");
		Interface AMPacketInterface = new Interface("AMPacket");
		Interface AMSendInterface = new Interface("AMSend");

		AddInterface(AMSendInterface);
		AddInterface(AMPacketInterface);
		AddInterface(PacketInterface);
		
		Connection PacketConnection = new Connection(PacketInterface, AppComponent,PacketInternalInterface, AMSenderComponent);
		Connection AMPacketConnection = new Connection(AMPacketInterface, AppComponent, AMPacketInternalInterface, AMSenderComponent);
		Connection AMSenderConnection = new Connection(AMSendInterface, AppComponent, AMSendInternalInterface, AMSenderComponent);
		
		AddConnection(AMSenderConnection);
		AddConnection(AMPacketConnection);
		AddConnection(PacketConnection);
		
		Function AMSendDoneFunction = new Function("event void "+ AMSendInterface.GetName()+".sendDone(message_t* msg, error_t err)");
		AddFunction(AMSendDoneFunction);
	}
}
