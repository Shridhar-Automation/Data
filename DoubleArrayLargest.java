package JavaPrograms;

public class DoubleArrayLargest {

	public static void main(String[] args) {

		int a[][]= {{2,3,5},{1,4,8},{6,9,7}};
		int max = a[0][0];

		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{

				if(a[i][j]>max)
				{
						max = a[i][j];
				}

			}



		}
		System.out.println(max);

	}













}
