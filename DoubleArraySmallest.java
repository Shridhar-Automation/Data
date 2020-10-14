package JavaPrograms;

public class DoubleArraySmallest {

	public static void main(String[] args) {
		
		int xyz[][]= {{5,3,2},{9,4,1},{8,7,6}};
		
		
int min = xyz[0][0];		
		for(int i=0;i<xyz.length;i++)
		{
			for(int j=0;j<xyz.length;j++)
			{
				if(xyz[i][j]<min)
				{
					min = xyz[i][j];
				}
				
			}
			
			
		}
		
		System.out.println(min);
		
		
	}
	
	
	
}
