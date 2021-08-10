package com.Java;

import java.util.LinkedHashSet;

public class NoOfOccurenceOfEachWordInString {
public static void main(String[] args) {
	
	String s ="Welcome to TYSS";
	String[] strarr =s.split(" ");
	LinkedHashSet<String> str = new LinkedHashSet<String>();
	for(int i=0; i<strarr.length; i++) {
		str.add(strarr[i]);
	}
	for(String word:strarr) {
		int count=0;
		for(int i=0; i<strarr.length;i++) {
			if (word.equals(strarr[i])){
count++;				
			}
		
		}
		if (count>=1)
			System.out.print(word+"  "+count);
	}
	
	
	
}
}
