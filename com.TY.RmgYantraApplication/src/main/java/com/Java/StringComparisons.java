package com.Java;

public class StringComparisons {

	public static void main(String[] args) {
		String S="abc";
		String S1="abc";
		String S2="abdefgh";
		String S4="";
		String S5="Welcome";
		String S6="TYSS";
		//To get the length of the string Without length function\
		System.out.println(S5.compareTo(S4));
		//Difference in ASCII Values will print if the difference is not zero
		System.out.println(S5.compareTo(S6));
		System.out.println(S==S1);
		System.out.println(S.equals(S1));
		System.out.println(S.compareTo(S1));
		System.out.println(S2.compareTo(S));
	}
}
