package JavaPrograms;

public class CommonElementArray {

	//two arrays required
	//loop first array to compare with all the elements of second array
	//to check for common
	public static void main(String[] args) {
		int a[] = {4,2,3,5,6};
		int b[] = {9,4,2,3,5,8}; 

		for(int i =0;i<a.length;i++)
		{
			
			for(int j=0;j<b.length;j++)
			{
				
				if(a[i]==b[j])
				{
					System.out.print(a[i] + " ");
					
				}
				
				
			}
			
			
			
		}



	}








}
