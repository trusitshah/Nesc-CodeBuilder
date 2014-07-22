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
 * This is the interface class for the Object.
 * 
 * It contains the information about interface
 * used in the files.
 * 
 * @author trusit
 *
 */
public class Interface 
{
	/**
	 * Type of interface.
	 */
	private String Type;
	
	/**
	 * Name of interface. 
	 */
	private String Name;
	
	/**
	 * Precision Tag of interface.
	 */
	private String PrecisionTag;
	
	/**
	 * Defines whether interface has precision tag or not.
	 */
	private Boolean HasPrecision;
	
	/**
	 * Defines whether interface has different name than its type.
	 */
	private Boolean HasName;
	
	/**
	 * 
	 * @param InterfaceType
	 */
	public Interface(String InterfaceType)
	{
		Type = InterfaceType;
		Name = Type;
		HasName = false;
		HasPrecision = false;
	}
	
	/**
	 * 
	 * @param InterfaceType Interface Type 
	 * @param InterfaceName Interface Name
	 * 
	 * for e.g.
	 * interface Timer<TMilli> as Timer0; 
	 * has Type = Timer
	 * Name = Timer0
	 */
	public Interface(String InterfaceType,String InterfaceName)
	{
		Type = InterfaceType;
		Name = InterfaceName;
		HasName = true;
		HasPrecision = false;
	}
		
	/**
	 * 
	 * @param InterfaceType
	 * @param InterfaceName
	 * @param PrecisionTag Precision Tag of interface
	 *
	 * for e.g.
	 * interface Timer<TMilli> as Timer0; 
	 * has Type = Timer
	 * Name = Timer0

	 */
	public Interface(String InterfaceType,String InterfaceName,String PrecisionTag)
	{
		Type = InterfaceType;
		Name = InterfaceName;
		this.HasName = true;
		this.HasPrecision = true;
		this.PrecisionTag = PrecisionTag;
	}

	/**
	 * 
	 * @return Type of interface.
	 */
	public String GetType()
	{
		return Type;
	}
	
	/**
	 * 
	 * @return Name of interface.
	 * 
	 */
	public String GetName()
	{
		return Name;
	}
	
	/**
	 * 
	 * @return Precision Tag of interface.
	 */
	public String GetPrecisionTag()
	{
		return PrecisionTag;
	}
	
	/**
	 * 
	 * @return Whether interface has precision or not.
	 */
	public Boolean HasPrecisionTag()
	{
		return HasPrecision;
	}
	
	/**
	 * 
	 * @return Whether Interface has different name than type or not.
	 */
	public Boolean HasName()
	{
		return HasName;
	}
	
	/**
	 * Set the precision Tag.
	 * @param PrecisionTag
	 */
	public void SetPrecision(String PrecisionTag)
	{
		this.PrecisionTag = PrecisionTag;
		HasPrecision = true;
	}
}

