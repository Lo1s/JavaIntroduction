/**
 * 
 */
package chapter14;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 28. 8. 2014 2014 15:38:59 
 */
public class PE1427_ReplaceWords {

	/**
	 * @param args
	 */
	 public static void main(String args[])
	    {
	        for(int i = 0; i < args.length; i++)
	        {
	            if(!args[i].endsWith(".class"))
	            {
	                replaceWord(new File(args[i]));
	            }
	        }

	    }

	    public static void replaceWord(File file)
	    {
	        String lineSeparator = System.getProperty("line.separator");
	        String line = "";
	        try
	        {
	            Scanner input;
	            for(input = new Scanner(file); input.hasNext();)
	            {
	                line = (new StringBuilder(String.valueOf(line))).append(getNewLine(input.nextLine())).append(lineSeparator).toString();
	            }

	            input.close();
	            PrintWriter output = new PrintWriter(file);
	            output.print(line);
	            output.close();
	        }
	        catch(Exception ex)
	        {
	            ex.printStackTrace();
	        }
	    }

	    public static String getNewLine(String line)
	    {
	        int p;
	        for(int k = line.indexOf("Exercise"); k >= 0; k = line.indexOf("Exercise", p))
	        {
	            p = k + "Exercise".length();
	            if(line.length() >= p + 3 && Character.isDigit(line.charAt(p)) && line.charAt(p + 1) == '_' && Character.isDigit(line.charAt(p + 2)) && (line.length() == p + 3 || !Character.isDigit(line.charAt(p + 3))))
	            {
	                line = (new StringBuilder(String.valueOf(line.substring(0, p)))).append("0").append(line.charAt(p)).append(line.charAt(p + 1)).append("0").append(line.substring(p + 2)).toString();
	            } else
	            if(line.length() >= p + 4 && Character.isDigit(line.charAt(p)) && Character.isDigit(line.charAt(p + 1)) && line.charAt(p + 2) == '_' && Character.isDigit(line.charAt(p + 3)) && (line.length() == p + 4 || !Character.isDigit(line.charAt(p + 4))))
	            {
	                line = (new StringBuilder(String.valueOf(line.substring(0, p + 3)))).append("0").append(line.substring(p + 3)).toString();
	            } else
	            if(line.length() >= p + 4 && Character.isDigit(line.charAt(p)) && line.charAt(p + 1) == '_' && Character.isDigit(line.charAt(p + 2)) && Character.isDigit(line.charAt(p + 3)))
	            {
	                line = (new StringBuilder(String.valueOf(line.substring(0, p)))).append("0").append(line.substring(p)).toString();
	            }
	        }

	        return line;
	    }
	}
