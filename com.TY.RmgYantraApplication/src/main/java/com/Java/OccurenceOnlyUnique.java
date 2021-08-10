package com.Java;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class OccurenceOnlyUnique {

	public static void main(String[] args) {
		String S= "india";
		//Go for linked hashSet to prevail the insertion order INDIA,,, Output is NDA
		LinkedHashSet<Character> set = new LinkedHashSet();
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
			if (count==1) {//dont call println, call print method
				System.out.print(ch);	
			}
		}
	}

}
