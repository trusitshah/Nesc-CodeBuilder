/* 
 * This file is the part of project CodeBuilder which is 
 * created for the creating NesC files (C and AppC) using 
 * graphics interface.
 *
 * Author : Trusit Shah
 * Date : 16-07-2014
 * 
 */

package CodeBuilder.Objects;;

/**
 * 
 * This class repesents the Component Element of 
 * AppC file.
 * 
 * @author trusit
 *
 */
public class Component 
{
	/**
	 * Name of the Component.
	 * 
	 * If you write Component new TimerMilliC() as Timer0
	 * which implies Type = TimerMilliC and 
	 * Name = Timer0.
	 * 
	 */
	private String Name;
	/**
	 * Type of the Component.
	 * 
	 * If you write Component new TimerMilliC() as Timer0
	 * which implies Type = TimerMilliC and 
	 * Name = Timer0.
	 * 
	 */
	private String Type;
	
	/**
	 * Variable defines whether Component is generic or not.
	 */
	private Boolean IsGeneric;
	
	/**
	 * Variable defines whether Component has different 
	 * or its Name is same as its Type.
	 */
	private Boolean HasName;
	
	/**
	 * Stores the argument of generic component.
	 */
	private String Argument;
	
	/**
	 * 
	 * @param ComponentType Type of Component.
	 * e.g. Component new TimerMilliC();
	 * has Component Type TimerMilliC. 
	 *
	 */
	public Component(String ComponentType)
	{
		Type = ComponentType;
		Name = Type;
		Argument = "";
		IsGeneric = false;
		HasName = false;
	}
	
	/**
	 * 
	 * @param ComponentType Type of Component.
	 * e.g. Component new TimerMilliC();
	 * has Component Type TimerMilliC. 
	 * 
	 * @param ComponentGeneric defines whether component is generic or not.
	 * 
	 */
	public Component(String ComponentType,Boolean ComponentGeneric)
	{
		Type = ComponentType;
		Name = Type;
		Argument = "";
		IsGeneric = ComponentGeneric;
		HasName = false;
	}
	
	/**
	 * 
	 * @param ComponentType Type of Component
	 * @param ComponentName Name of Component
	 *  
	 * If you write Component new TimerMilliC() as Timer0
	 * which implies Type = TimerMilliC and 
	 * Name = Timer0.
	 * 
	 * @param ComponentGenric defines whether component is generic or not.
	 * 
	 */
	public Component(String ComponentType,String ComponentName,Boolean ComponentGenric)
	{
		Type = ComponentType;
		Name = ComponentName;
		Argument = "";
		IsGeneric = ComponentGenric;
		HasName = true;
	}
	
	/**
	 * 
	 * @return Type of the Component.
	 */
	public String GetType()
	{
		return Type;
	}
	
	/**
	 * 
	 * @return Whether Component has differnt name than type.
	 * 
	 */
	public Boolean HasName()
	{
		return HasName;
	}
	
	/**
	 * 
	 * @return Name of the Component. 
	 */
	public String GetName()
	{
		return Name;
	}
	
	/**
	 * 
	 * @return whether Component is generic or not.
	 */
	public Boolean GetGeneric()
	{
		return IsGeneric;
	}
	
	/**
	 * sets the argument.
	 * @param Argument
	 */
	public void SetArgument(String Argument)
	{
		this.Argument = Argument;
	}
	
	/**
	 * 
	 * @return Argument of the component.
	 */
	public String GetArgument()
	{
		return Argument;
	}
}