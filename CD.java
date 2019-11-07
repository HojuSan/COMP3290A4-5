//* File:                       CD.java
// * Course:                    COMP2240
//  * Assignment:               Assignment3
//   * Name:                    Juyong Kim  
//    * Student Number:         c3244203
//     * Purpose:               Main file
//      * Note:                 -syntactic processing is not done in this assignment
//		 *						-spaces are delimiters, also /n and /r(carrigage return)
//		  *						-7. Other significant lexical items in CD19 are: semicolon (;) leftbracket ([)
//		   *					rightbracket (]) comma (,) leftparen ( ( ) rightparen ( ) ) equals (=) plus (+)
//		    *					minus (-) star (*) slash (/) percent (%) carat (^) less (<) greater (>) exclamation
//		     *					(!) quote (“) colon (:) dot (.).
//		      *
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class CD
{
	public static void main(String args[])  throws IOException
	{
		//input setup
		File file = new File(args[0]);	
		//File file = new File("testd2.txt");		
		//File outputFile = new File("outputListing.lst");							//adds file
		PrintWriter pw = new PrintWriter(System.out);					//Prints formatted representations of objects to a text-output stream
		StringBuffer sb = new StringBuffer("");							//a string that can be modified
		BufferedReader br = new BufferedReader(new FileReader(file));	//read char by char
		OutputController output = new OutputController(br, pw, sb);
		
		//A3 Output
		Parser parser  = new Parser(output);
		
		TreeNode.printTree(pw, parser.program());	

//		while(iterator.hasNext()) 
//		{
//		   Map.Entry mentry = (Map.Entry)iterator.next();
//		   System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
//		   System.out.println(mentry.getValue());
//		}
	
		
		try (PrintWriter ol = new PrintWriter("outputListing.lst")) {
			ol.println(output.getString()+TreeNode.getString());
		}
		//TreeNode.writeStringToFile(outputFile);

		System.out.println();
		pw.flush();
		System.out.println();

		parser.getSymbol().getEntries().forEach((k, v) -> {
			System.out.println("Key = " + k + " - Type = " + v.getType());
		});

		pw.close();
		
	}
}