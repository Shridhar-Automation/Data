package JavaPrograms;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		int n;

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the value");
		n= scan.nextInt();

		if(n==0)
		{
			System.out.println("Invalid value");
		}else if(n==1){
			System.out.print("0,1");
		}else
		{
			System.out.print("0,1");
		}

		int a=0, b=1, c;

		for(int i=0;i<n;i++)
		{
			c=a+b;

			System.out.print("," +c);


			a=b;
			b=c;





		}

scan.close();



	}



}
