class Strong
{
	public static void main(String[] args) 
	{
		int n=1;
		while (n<=1000)
		{
	
		int sum=0;
		int temp=n;
		while (n>0)
		{
			int digit=n%10;
			int fact=1;
			while (digit>0)
			{
				fact=fact*digit;
				digit--;
			}
			sum=sum+fact;
			n=n/10;
		}
		if (sum==temp)
		{
			System.out.println("The Entered Number"+temp+ "is Strong");
		}
		n=temp;
		n++;
	}
}
}