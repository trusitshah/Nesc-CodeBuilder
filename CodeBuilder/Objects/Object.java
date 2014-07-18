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

import java.util.ArrayList;

/**
 * This class is responsible for the Creating basic objects like
 * Timer, AMSender , AMReceiver , LED and so on. 
 * 
 * An Object basically contains Components , Interfaces , Connections
 * and Function definition.
 * 
 * @author trusit
 *
 */
public abstract class Object
{
	/**
	 * This contains the type of the Object.
	 */
	protected String Type;
	
	/**
	 * List of Components inside the Object.
	 */
	private ArrayList<Component> Components;

	/**
	 * List of Interfaces inside the Object.
	 */
	private ArrayList<Interface> Interfaces;
	
	/**
	 * List of Connections inside the Object.
	 */
	private ArrayList<Connection> Connections;
	
	/**
	 * List of Functions inside the Object.
	 */
	private ArrayList<Function>functions;
	
	/**
	 * Create an object of given type.
	 * @param Type
	 */
	public Object(String Type)
	{
		this.Type = Type;
		Components = new ArrayList<Component>();
		Interfaces = new ArrayList<Interface>();
		Connections = new ArrayList<Connection>();
		functions = new ArrayList<Function>();
	}
	
	/**
	 * Adds Component to the list.
	 * 
	 * @param c
	 */
	protected void AddComponent(Component c)
	{
		Components.add(c);
	}
	
	/**
	 * Adds interface to the list.
	 * 
	 * @param e
	 */
	protected void AddInterface(Interface e)
	{
		Interfaces.add(e);
	}
	
	/**
	 * Adds Connection to the list.
	 * @param c
	 */
	protected void AddConnection(Connection c)
	{
		Connections.add(c);
	}
	
	/**
	 * Add function to the list.
	 * @param f
	 */
	protected void AddFunction(Function f)
	{
		functions.add(f);
	}
	
	/**
	 * 
	 * @return Component list inside an object.
	 */
	public ArrayList<Component> GetComponentList()
	{
		return Components;
	}
	
	/**
	 * 
	 * @return Interface list inside an object.
	 */	
	public ArrayList<Interface> GetInterfaceList()
	{
		return Interfaces;
	}
	
	/**
	 * 
	 * @return Connection list inside an object.
	 */
	public ArrayList<Connection> GetConnectionList()
	{
		return Connections;
	}
	
	/**
	 * 
	 * @return Function list inside an object.
	 */
	public ArrayList<Function> GetFunctionList()
	{
		return functions;
	}
	
	/**
	 * 
	 * @return Type of an object.
	 */
	public String GetType()
	{
		return Type;
	}
}
