package com.Java;

public class ReverseStringUsingTempVariable {
static  String rev="";
static String S= "INDIA";
public static void main(String[] args) {
	
	
	for (int i=S.length()-1; i>=0 ;i--) {
		rev=rev+(S.charAt(i));	
	}
System.out.println(rev);	
}
}
