package com.Java

public class PalindromeCheck
{
	public static void main(String[] args) 
	{
		int i=121;
		int num=i;
		while (i==num)
		{
			int n=i;
			int rev=0;
			while (n>0)
			{
				int digit=n%10;
				rev=rev*10+digit;
				n=n/10;
			}
			if (rev==i)
			{
				System.out.println("Yes,"+rev+" it is a Palindrome ");
			}
			i++;
		}
	}
}
