package com.Java;

import java.util.LinkedHashSet;

public class NoOfOccurenceOfUniqueRemoveDuplicateWordInString {
public static void main(String[] args) {
	
	String s ="Welcome to TYSS Welcome to India";
	String[] strarr =s.split(" ");
	LinkedHashSet<String> str = new LinkedHashSet<String>();
	for(int i=0; i<strarr.length; i++) {
		str.add(strarr[i]);
	}
	for(String word:strarr) {
		System.out.println(word);		}
	
		}
	
	
	
}
