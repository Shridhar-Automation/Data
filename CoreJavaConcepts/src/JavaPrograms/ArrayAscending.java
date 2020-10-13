package JavaPrograms;

public class ArrayAscending {

	public static void main(String[] args) {

		int a[] = {50,60,20,30,40,90};

		int temp;


		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}


	}




}
