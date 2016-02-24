import java.util.Random;


public class Merge_Sort2 
{
	public static void main(String[] args)
	{
	int[] ar = new int[4];	//declaring new integer array contains 4 elements
	
	Merge_Sort2.fillArray(ar);//fill the array by random elements
	
	System.out.println("Array Before sorting");
	Print(ar);//print the unsorted elements
	
    Merge_Sort2.Merge(ar,0, ar.length-1);//call this method to sort the array
	System.out.println("Array After sorting");
	Print(ar);//print the sorted elements
	}
	
//this method will print the array
	public static void Print(int [] Arr)
	  { 
		for(int i=0;i<Arr.length;i++)
		   {
			System.out.println(Arr[i]);
		   }
	  }
	
//this method will fill the array randomly
	static void fillArray(int[] ar)
	{
	  Random r= new Random();
	  for(int i = 0; i< ar.length; i++)
	     {
		   ar[i]= r.nextInt(100);
	     }
	}
	
//this method will sort the araay's elements	
public static void Merge (int[] ar,int smallNum, int bigNum)
{
  	int i;//I need it to do the math
  	if (smallNum >= bigNum) 
  	   {
  		return;
  	   }
     //divide the array
  	 i = (smallNum + bigNum) / 2;
  	 
  	//call the merge method again with the first half of new array which is the biggest number is changed
  	Merge(ar, smallNum, i); 
  	
  	//call the merge method again with the second half of new array which is the smallest number is changed
  	Merge(ar, i + 1, bigNum);
  	
  	int lastSmall = i;
  	int firstbig = i + 1;
  	//while loop used to check the smaller number and put it first
		while ((smallNum <= lastSmall) && (firstbig <= bigNum)) 
		    {
				if (ar[smallNum] < ar[firstbig]) 
				   {
					  smallNum++;
				   } 
				else 
				   {
					int ar2 = ar[firstbig];
						for (int j = firstbig- 1; j >= smallNum; j--) 
						    {
								ar[j+1] = ar[j];
						    }
						ar[smallNum] = ar2;
						smallNum++;
						lastSmall++;
						firstbig++;
				  }
		    }
	  
   }//end merge
	
}//end of class

