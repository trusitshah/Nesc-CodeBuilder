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
 * 
 * Class used for writing C files.
 * 
 * @author trusit
 * @since- 04-07-2014
 * 
 */

public class WriteCFile extends WriteFile
{
	private String ProjectName;
	private ArrayList<Object> Objects;
	
	/**
	 * 
	 * @param ProjectName
	 * @param path
	 */
	public WriteCFile(String ProjectName,String path)
	{
		super(ProjectName+"C.nc", path);
		this.ProjectName = ProjectName;
	}
	
	@Override
	public int CreateFile()
	{
		return super.CreateFile();
	}
	
	/**
	 * Writes the C file. 
	 * @param Objects list of object to be added in the file.
	 * 
	 */
	public void WriteFile(ArrayList<Object>Objects)
	{
		SetObjectList(Objects);
		WriteModule();
		WriteImplementation();
	}
	
	/**
	 * sets the object list.
	 * @param Objects
	 */
	private void SetObjectList(ArrayList<Object>Objects)
	{
		this.Objects = Objects;
	}
	
	/**
	 * write module part of the part.
	 * 
	 */
	private void WriteModule()
	{
		String ModuleLine = "module "+ProjectName+"C";
		WriteLine(ModuleLine);
		WriteOpeningBrace();
		
		for (Object object : Objects) 
		{
			ArrayList<Interface> Interfaces = object.GetInterfaceList();
			
			for (Interface Interface : Interfaces) 
			{
				WriteUses(Interface);
			}
		}
		
		WriteClosingBrace();
	}
	
	/**
	 * Write Implementation part.
	 */
	private void WriteImplementation()
	{
		WriteLine("implementation");
		WriteOpeningBrace();
		
		for (Object object : Objects) 
		{
			ArrayList<Function> Functions = object.GetFunctionList();
			
			for (Function function : Functions) 
			{
				WriteFunction(function);
			}
		}
		
		WriteClosingBrace();
	}
	
	/**
	 * adds interface in the file.
	 * @param I Interface to be added in the file.
	 */
	private void WriteUses(Interface I)
	{
		WriteTab();
		Write("uses interface "+I.GetType());
		
		if(I.HasPrecisionTag())
			WritePrecisionTag(I.GetPrecisionTag());
		
		if(I.HasName())
			Write(" as " + I.GetName());
		WriteSemicolon();
	}
		
	/**
	 * Writes precision Tag in the adding interface part.
	 * 
	 * @param PrecisionTag
	 */
	private void WritePrecisionTag(String PrecisionTag)
	{
		WriteOpeningAngleBracket();
		Write(PrecisionTag);
		WriteClosingAngleBracket();
	}
	
	/**
	 * Add the function in the implemetation part.
	 * 
	 * @param F Function to be added.
	 * 
	 */
	private void WriteFunction(Function F)
	{
		WriteTab();
		WriteLine(F.GetPrototype());
		WriteTab();
		WriteOpeningBrace();
		WriteTab();
		WriteClosingBrace();
	}
}
