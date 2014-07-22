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
 * This class represent the Connection between two 
 * Components.
 * 
 * It takes two components and their respective
 * interfaces to connect.
 * 
 * @author trusit
 *
 */
public class Connection 
{
	/**
	 * Interface at left side of Connection.
	 */
	private Interface LeftInterface;
	
	/**
	 * Interface at right side of Connection. 
	 */
	private Interface RightInterface;
	
	/**
	 * Component at left side of Connection.
	 */
	private Component LeftComponent;
	
	/**
	 * Component at right side of Connection. 
	 */
	private Component RightComponent;
	
	/**
	 * 
	 * @param LeftInterface
	 * @param LeftComponent
	 * @param RightInterface
	 * @param RightComponent
	 */
	public Connection(Interface LeftInterface,Component LeftComponent,Interface RightInterface,Component RightComponent)
	{
		this.LeftComponent = LeftComponent;
		this.LeftInterface = LeftInterface;
		this.RightComponent = RightComponent;
		this.RightInterface = RightInterface;
	}
	
	/**
	 * 
	 * @return Left side Interface.
	 */
	public Interface GetLeftInterface()
	{
		return this.LeftInterface;
	}

	/**
	 * 
	 * @return Left side Component.
	 */
	public Component getLeftComponent()
	{
		return this.LeftComponent;
	}
	
	/**
	 * 
	 * @return Right side Interface.
	 */
	public Interface GetRightInterface()
	{
		return this.RightInterface;
	}

	/**
	 * 
	 * @return Right side Component.
	 */
	public Component getRightComponent()
	{
		return this.RightComponent;
	}

}
