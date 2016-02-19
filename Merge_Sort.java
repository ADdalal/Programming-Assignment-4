import java.util.Random;


public class Merge_Sort 
{
	public static void main(String[] args)
	{
	int[] ar = new int[4];	
	Merge_Sort.fillArray(ar);
	Print(ar);
	ar = Merge_Sort.Divide(ar);
	System.out.println("Array After sorting");
	Print(ar);
	}
	
//this method will print the array
	public static void Print(int [] Arr)
	  { 
		for(int i=0;i<Arr.length;i++)
		   {
			System.out.println(Arr[i]);
		   }
	  }
	
	//this function will fill the array randomly
	static void fillArray(int[] ar)
	{
	  Random r= new Random();
	  for(int i = 0; i< ar.length; i++)
	     {
		   ar[i]= r.nextInt(100);
	     }
	}
	
	//this function will divide the array many times until the last element
	public static int[] Divide (int[] ar)
	{
	   if(ar.length<= 1)//that means we're done dividing the array
	     {
		   return ar; 
	     }
	   int middle = ar.length/2;//dividing the array 
	   int [] left = new int [middle]; //this will be the left side of new array
	   int [] right; //this will be the right side of new array but we need to know if the array's length is even or odd number
	   if(ar.length %2 ==0)//if the length is even
	     {
		  right = new int [middle];  //if the length is even
	     }
	   else
	     {
		  right = new int [middle+1];//if the length is odd
	     }
	   int [] result = new int [ar.length];//this will be the new array after dividing
	   
	   for(int i=0;i<middle;i++)//fill the left side from 0 to the middle point
	     {
		   left[i]=ar[i];
	     }
	   for(int j=middle; j <ar.length;j++)//fill the right side from middle point which will have 0 to the end of array
	     {
		   int k =0; 
		   if(k < right.length)
		     {
		       right[k]=ar[j];
		       k++;
	         }
	       }
	   left = Divide(left);
	   right = Divide(right);
	   result = Merge(left,right);
	   return result;
	   
	   
	   
	}//end of divide method
	
public static int [] Merge (int[]left, int[]right)
   {
	  int resultLength= left.length+right.length;//to find the result legth of this array
	  int [] result =new int [resultLength];
	  int indexLeft = 0;
	  int indexRight =0;
	  int indexResult =0;
	  
	  while(indexLeft < left.length || indexRight < right.length)
	     {
		    if(indexLeft < left.length && indexRight < right.length)//if both side still have elements
		      {
			    if(left[indexLeft] <= right[indexRight])//check the smallest number and put it first
			      {
				   result[indexResult]= left[indexLeft];//if the left is smaller
				   indexLeft++;
				   indexResult++;
			      }
			    else//if the right is smaller
			      {
				   result[indexResult]= right[indexRight];//if the left is smaller
				   indexRight++;
				   indexResult++;
			      }
		      }
		    
		    else if(indexLeft < left.length)//if there is an extra element in the left side
		      {
		    	result[indexResult]= left[indexLeft];//if the left is smaller
				indexLeft++;
				indexResult++;
		      }
		    else if(indexRight < right.length)//if there is an extra element in the right side
		      {
		    	result[indexResult]= right[indexRight];//if the left is smaller
				indexRight++;
				indexResult++;
		      }  
	  }//end while
	  return result;
	  
	  
   }//end merge
	
}//end of class

