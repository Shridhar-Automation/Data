package JavaPrograms;

import java.util.ArrayList;

public class UniqueNumberExample {

	public static void main(String[] args) {
		
		int a[] = {2,3,2,3,4,5,6,6,6,7,8,9,9,2,5,7,8};
		
		ArrayList<Integer> al = new ArrayList<Integer> ();
		
		for(int i=0;i<a.length;i++)
		{
			int k=0;
			
			if(!al.contains(a[i]))
			{
				al.add(a[i]);
				k++;
				
				for(int j=i+1;j<a.length;j++)
				{
				
					if(a[i]==a[j])
					{

						k++;	
					}
					
				}
				System.out.println("The number : " + a[i]);
			
				System.out.println("No. of times repeated is : " +k);
				
				
			if(k==1)
			
				System.out.println("The unique no. is : " +a[i]);
				
			
				
				
			}
			
		
		
		
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
