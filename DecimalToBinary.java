package JavaPrograms;

import java.util.ArrayList;

public class DecimalToBinary {

	//converting any decimal value to binary format (1010)
	//required decimal number
	//use formula number%2 and later divide number by 2 and 
	//later print the output in reverse format 
	//bcz output comes from last to first


	public void deciToBin(int number)
	{

		ArrayList<Integer> al = new ArrayList<Integer>();

		while(number>0)
		{
			al.add(number%2);
			number = number/2;
		}
		int length = al.size()-1;
		while(length>=0)
		{
			System.out.println(al.get(length));
			length--;
		}
	}


	public static void main(String[] args) {

		DecimalToBinary db = new DecimalToBinary();
		db.deciToBin(4);






	}





}
