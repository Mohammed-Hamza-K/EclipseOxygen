package com.Java;
//Reverse the String without using Length() or length variable
public class ReverseStringWithoutLength {

	 static String S="ReverseMe";
	static char[] ch;
	static int count;
	public static void main(String[] args) {
		ch = S.toCharArray();
		for (char c : ch) {
			count++;
		}
		for (int i=count-1; i>=0 ;i--) {
			System.out.print((S.charAt(i)));	
		}
	}
}
