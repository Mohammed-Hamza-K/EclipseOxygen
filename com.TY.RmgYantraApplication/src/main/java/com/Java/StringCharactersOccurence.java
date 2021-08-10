package com.Java;

import java.util.HashSet;

public class StringCharactersOccurence {


	public static void main(String[] args) {
		String S= "india";
		HashSet<Character> set = new HashSet();
		for(int i=0; i<S.length(); i++) {
			set.add(S.charAt(i));}
		//System.out.println(ch);
		//Step 2 
		for (Character ch : set) {
			int count=0;
			for(int i=0; i<S.length();i++) {

				if (ch==S.charAt(i)) {
					count++;
				}
				
			
			}
			System.out.println(ch+"=="+count);
		
		}
	}




}
