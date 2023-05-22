package com.bkw.rulesengine.misc;
import java.io.*;

public class FilterFile {
	protected static int indent = 0;
	protected static boolean eol = false;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("args:"+args.length);
		try {
			FileInputStream input = new FileInputStream(args[0]);
			int value = input.read();
			int last = -1;
			//int comment = 0;
			int block = 0;
			//boolean inlineComment = false;
			boolean endline = false;
			while(value != -1) {
				//if(last == '/' && value == '*') ++comment;
				//if(last == '/' && value == '/') inlineComment = true;
				if(value == '{') ++block;
				if(value == '}') --block;
				if(value == ';') endline = true;
				processValue(value);
				
				endline = false;
				value = input.read();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	protected static void processValue(int value) {
		if(value == '{') {
			String indentString = getIndent();
			System.out.print("\n"+indentString+(char)value);
			++indent;
			eol = false;
		} else {
			if(value == '}') {
				--indent;
				String indentString = getIndent();
				System.out.print("\n"+indentString+(char)value);
				eol = false;
			} else {
				if(value == ';') {
					eol = true;
					System.out.print((char)value+"\n");
				} else {
					if(eol) {
						String indentString = getIndent();
						System.out.print(indentString);
					}
					System.out.print((char)value);
					eol = false;
				}
			}
		}
	}
	
	protected static String getIndent() {
		String indentString = "";
		for(int i=0; i<indent; ++i) indentString += "  ";
		return indentString;
	}

}
