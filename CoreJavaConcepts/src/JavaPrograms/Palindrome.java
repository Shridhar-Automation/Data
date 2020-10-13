package JavaPrograms;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {

		String ori;
		String rev="";
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the value");
		ori=	scan.next();

		for(int i=ori.length()-1;i>=0;i--)
		{

			char c = ori.charAt(i);
			rev = rev + c;
		
		}
if(ori.equalsIgnoreCase(rev))
{
	System.out.println("This is a Palindrome");
}
else {
	System.out.println("This is not a Palindrome");
}
	scan.close();
	}

	
}
