package com.Java;

public class PrintStringRev {
static String S="Karnataka";
/*
 * for String INDIA, S.length() will return 5 i.e character count, but Index is 0 to 4
 * Similarly Karnataka S.length() will return 9, but index starts from 0 to 8
 * for all strings we start reversing the string from 1 number less than the length of the string 
 * Therefore we give int i=S.length-1
 * and we reverse the string from say 9th index to 0th index, so i>=0 if we dont include "=" zero in the condition
 * we will not be able to read the 0th index, ie, first letter of the string,
 * Hence this is a decrement so we give i-- in the updation, (we are starting our iteration from a max number till zero)
 */
	public static void main(String[] args) {
		for (int i=S.length()-1; i>=0; i--) {
			System.out.print(S.charAt(i));
			
		}
}
}
