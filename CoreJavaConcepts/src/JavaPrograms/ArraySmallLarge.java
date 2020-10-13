package JavaPrograms;

public class ArraySmallLarge {
	
	public static void main(String[] args) {
		
		int a[][]= {{5,4,6},{9,3,2},{8,7,8}};
		
		int min = a[0][0];
		int column = 0; 
		
		for(int i=0;i<a.length;i++)
		{
			
			for(int j=0;j<a.length;j++)
			{
				
				if(a[i][j]<min)
				{
					min = a[i][j];
					column = j;
				}
			}
		}
		
		System.out.println("The smallest number is : " + min);
		
		int max = a[0][column] ;
		
		int k =0;
		while(k<a.length)
		{
		if (a[k][column]>max)
		{
			max = a[k][column];
			
		}
		k++;
		
		}
		System.out.println("The Largest value is : " +max);
		
	}
	
	
	

}
