/**
 * 
 */
package chapter23;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;



/**
 * @author jslapnicka
 * @Date & @Time 20. 1. 2015 2015 8:56:38 
 */
public class PE2305_SyntaxHighlighting {


	static PrintWriter output;

	public static void createHTMLheader(File outputFile) {
		output.printf(String.format("%s\r\n", "<html>"));
		output.printf(String.format("%s\r\n", "<head>"));
		output.printf(String.format("%s\r\n", "<title>Intro to Java Programming, 6E - " + outputFile + "</title>"));
		output.printf(String.format("%s\r\n", "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252/\">"));
		output.format("%s\r\n", new Object[] {
		"<style type = \"text/css\">"});
		output.format("%s\r\n", new Object[] {
				"body {font-family: \"Courier New\", sans-serif; font-size: 100%; color: black}"
		});
		output.format("%s\r\n", new Object[] {
				".keyword {color: #000080; font-weight: bold}"
		});
		output.format("%s\r\n", new Object[] {
				".comment {color: #008000}"
		});
		output.format("%s\r\n", new Object[] {
				".literal {color: #0000ff}"
		});
		output.format("%s\r\n", new Object[] {
		"</style>"});
		output.printf(String.format("%s\r\n", "</head>"));
		output.printf(String.format("%s\r\n", "<body>"));
		output.printf(String.format("%s\r\n", "<pre>"));
	}

	public static void javaToHTML(File inputFile, File outputFile) {
		String[] keys = {"abstract", "assert", "boolean",
				"break", "byte", "case", "catch", "char", "class", "const",
				"continue", "default", "do", "double", "else", "enum",
				"extends", "for", "final", "finally", "float", "goto",
				"if", "implements", "import", "instanceof", "int",
				"interface", "long", "native", "new", "package", "private",
				"protected", "public", "return", "short", "static",
				"strictfp", "super", "switch", "synchronized", "this",
				"throw", "throws", "transient", "try", "void", "volatile",
				"while", "true", "false", "null"};		

		HashSet<String> keyWordsSet = new HashSet<String>(Arrays.asList(keys));
		String tempLine;
		String[] tempWords;
		int startIndex;
		int endIndex;

		try {
			Scanner fileScan = new Scanner(inputFile);
			while (fileScan.hasNextLine()) {
				tempLine = fileScan.nextLine() + "\n";
				// "(?<=,)|(?=,)"
				// "[ \n\t\r,:!?(){}]"
				tempWords = tempLine.split("(?!^)\\b");
				// line comments
				if (tempLine.indexOf("//") > -1) {
					startIndex = tempLine.indexOf("//");
					endIndex = tempLine.indexOf("\n");
					tempLine = "<span class = \"comment\">" + tempLine.substring(startIndex, endIndex) + "</span>" 
							+ (tempLine.substring(endIndex).equals("\n") ? "\n" : "");				
					startIndex = -1;
				}

				// multiple-line comments
				else if (tempLine.indexOf("/**") > -1) {
					while (tempLine.indexOf("*/") == -1)
						tempLine += fileScan.nextLine() + "\n";				
					tempLine = "<span class = \"comment\">\n"
							+ tempLine + "</span>";
				}

				// String expressions
				else if (tempLine.indexOf("\"") > -1) {
					startIndex = tempLine.indexOf("\"");
					endIndex = tempLine.lastIndexOf("\"");
					tempLine = tempLine.substring(0, startIndex) + "<span class = \"literal\">" 
							+ tempLine.substring(startIndex, endIndex + 1) + "</span>" + tempLine.substring(endIndex + 1);
				}

				// Keywords
				else {
					String convertedKeywords = "";
					for (int i = 0; i < tempWords.length; i++) {
						if (keyWordsSet.contains(tempWords[i])) {
							convertedKeywords += "<span class = \"keyword\">" + tempWords[i] + "</span>";
						} else
							convertedKeywords += tempWords[i];
					}
					if (!convertedKeywords.isEmpty())
						tempLine = convertedKeywords;
				}
				output.printf(tempLine);
			}
			fileScan.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not found !");
		}
	}

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Usage: java PE2305_SyntaxHighlighting.java inputFile outputFile");
			System.exit(0);
		}

		// C:\Java\Test\Test.java
		File inputFile = new File(args[0]);
		File outputFile = new File(args[1]);
		try {
			output = new PrintWriter(outputFile);
		} catch (FileNotFoundException ex) {
			System.out.println("Problem with the output file !");
			ex.printStackTrace();
		}
		createHTMLheader(outputFile);
		javaToHTML(inputFile, outputFile);
		output.close();

	}
}
