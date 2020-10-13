package JavaPrograms;

import java.util.HashMap;

public class CountNumberArray {

	//use hashmap to store data = key, value to make things easier
	//define array value
	// use for loop for array traverse and convert array value to char
	//add inner for loop for char length and then, use if statement for passing data to hashmap & repeatation check
	//else, if new assign value to hashmap

	public static void main(String[] args) {

		int a[]= {355,655,677};

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();


		for(int i=0;i<a.length;i++)
		{

			char[] c= String.valueOf(a[i]).toCharArray();

			for(int j=0;j<c.length;j++)
			{
				if(map.containsKey(c[j]))
				{
map.put(c[j], map.get(c[j])+1);
				}
				
				else {

					map.put(c[j], 1);

				}

				}
			}

		System.out.println(map);

		}



}