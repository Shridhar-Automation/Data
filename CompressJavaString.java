package JavaPrograms;

public class CompressJavaString {

	public static void main(String[] args) {

		//input aaabbccd
		//output - a3b2c2d1

		//required variable to count
		// required char variable temp for storing each character and comparing
		//traverse all the elements, if same found by comparing temp and actual value, 
		//and then count it using if condition
		//later, to excecute last character, print output outside the for loop



		String s = "aaabbccd";
		int count = 0;
		char temp = s.charAt(0);

		for(int i=0;i<s.length();i++)
		{

			if(s.charAt(i)==temp)
			{
				count++;

			}else
			{
				System.out.print(temp+""+count);
				count=1;
				temp = s.charAt(i);
			}




		}
		System.out.print(temp+""+count);








	}





}
