package com.Java;
//Reverse the String without using Length() or length variable and use a third variable to Store the Rev String
public class ReverseStringWithoutLengthandUseThirdVariable {

	 static String S="Initially";
	static char[] ch;
	static int count;
	public static void main(String[] args) {
		ch = S.toCharArray();
		for (char c : ch) {
			count++;
		}
		 String rev="";
		for (int i=count-1; i>=0 ;i--) {
		rev = rev+(S.charAt(i));
		}
		System.out.println(rev);
	}
}
