//* File:                       StRec.java
// * Course:                    COMP3290
//  * Assignment:               Assignment3
//   * Name:                    Juyong Kim  
//    * Student Number:         c3244203
//     * Purpose:               Syntax Tree Requirements
//      * Note:                 Pretty simple class

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class StRec
{
	//variables
	private int column;
	private int line;
	private String name;
	//token int value
	private int type;
	private int tokenValue;

	private Map<String, StRec> struct;
	private Map<String, StRec> functionParam;
	private Map<String, StRec> functionLocals;

	private StRec arrayTypeId;
	private StRec typeArayId;


	//
	private int count;
	private SymbolTable scope;

	//constructor
	public StRec()
	{
		name = "";
		type = TreeNode.NUNDEF;
		tokenValue = Token.TUNDF;
		column = 0 ;
		line = 0;

	}

	//setters
	public StRec(String name)
	{
		this();
		this.name = name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setType(int type)
	{
		this.type = type;
	}

	//getters
	public String getName()
	{
		return name;
	}
	public String getType()
	{
		TreeNode node = new TreeNode(type);

		return node.getNodeValue(node);
	}
}