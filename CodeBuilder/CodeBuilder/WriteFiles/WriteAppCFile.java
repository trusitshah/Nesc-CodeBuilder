/* 
 * This file is the part of project CodeBuilder which is 
 * created for the creating NesC files (C and AppC) using 
 * graphics interface.
 *
 * Author : Trusit Shah
 * Date : 16-07-2014
 * 
 */

package CodeBuilder.WriteFiles;

import java.util.ArrayList;
import CodeBuilder.Objects.*;
import CodeBuilder.Objects.Object;

/**
 * This class generates the AppC file. It is the extends the WriteFile class.
 * The basic methods of this class are WriteConfiguration() and WriteImplementation().
 * 
 * @author trusit
 *
 */
public class WriteAppCFile extends WriteFile
{
	/**
	 * Name of the Project.
	 */
	private String ProjectName;
	
	/**
	 * Object list of the Object added in the files.
	 */
	private ArrayList<Object> Objects;
	
	public WriteAppCFile(String ProjectName)
	{
		super();
		this.ProjectName = ProjectName;
	}
	/**
	 * 
	 * @param ProjectName
	 * @param path
	 *  
	 */
	public WriteAppCFile(String ProjectName, String path) 
	{
		super(ProjectName+"AppC.nc", path);
		this.ProjectName = ProjectName;
	}
	
	@Override
	public int CreateFile()
	{
		return super.CreateFile();
	}
	
	/**
	 * This function will write the final appc file.
	 * 
	 * @param Objects object list which is to be added in the project.
	 * 
	 */
	public void WriteFile(ArrayList<Object>Objects)
	{
		SetObjectList(Objects);
		WriteConfiguration();
		WriteImplementation();
	}
	
	/**
	 * sets the object list.
	 * 
	 * @param Objects
	 */
	private void SetObjectList(ArrayList<Object>Objects)
	{
		this.Objects = Objects;
	}
	
	/**
	 * writes the configuration part.
	 */
	private void WriteConfiguration()
	{
		WriteLine("configuration "+ProjectName+"AppC");
		WriteOpeningBrace();
		WriteClosingBrace();
	}
	
	/**
	 * writes implementation part.
	 */
	private void WriteImplementation()
	{
		WriteLine("implementation");
		WriteOpeningBrace();
		
		WriteComponent(new Component(ProjectName + "C", "AppC", false));
		
		for (Object object : Objects) 
		{
			ArrayList<Component> Components = object.GetComponentList();
			
			for (Component component : Components)
			{
				WriteComponent(component);
			}
		}
		
		WriteLine("");
		
		for (Object object : Objects) 
		{
			ArrayList<Connection> Connection = object.GetConnectionList();
			
			for (Connection connection : Connection)
			{
				WriteConnections(connection);
			}
		}
				
		WriteClosingBrace();
	}
	
	/**
	 * write connection in the implementation part.
	 * Here Connection must have both side interface part whereas in nesc file sometimes single side interface is also acceptable. 
	 * 
	 * @param C
	 */
	private void WriteConnections(Connection C)
	{
		WriteTab();
		Write(C.getLeftComponent().GetName());
		Write(".");
		Write(C.GetLeftInterface().GetName());
		Write("->");
		Write(C.getRightComponent().GetName());
		Write(".");
		Write(C.GetRightInterface().GetName());
		WriteSemicolon();
	}
	
	/**
	 * adds new component in the file.
	 * Both generic and non generic component are supported. 
	 * 
	 * @param C
	 */
	private void WriteComponent(Component C)
	{
		WriteTab();
		if(!C.GetGeneric())
		{
			Write("components ");
			Write(C.GetType());
			
			if(C.HasName())
			{
				Write(" as ");
				Write(C.GetName());
			}
			WriteSemicolon();
		}
		else
		{
			Write("components new ");
			Write(C.GetType());
			WriteOpeningBracket();
			Write(C.GetArgument());
			WriteClosingBracket();
			if(C.HasName())
			{
				Write(" as ");
				Write(C.GetName());
			}
			WriteSemicolon();
		}
	}
}
