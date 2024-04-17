package quicksort;
import java.util.Random;

public class QuickSort 
{
	public static void swap(int[] array, int index1,int index2)
	{
		int temp = array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
	}
	
	public static void quicksort(int array[], int low, int high)
	{
		if(low>=high)
		{
			return;
		}
		
		int pivotIndex = new Random().nextInt(high-low)+low;
		int pivot = array[pivotIndex];
		swap(array,pivotIndex,high);
		/*
		 * int pivot = array[high]; int leftPointer = low; int rightPointer =high;
		 * 
		 * while(leftPointer<rightPointer) { while(array[leftPointer]<=pivot &&
		 * leftPointer<rightPointer) { leftPointer++; }
		 * 
		 * while(array[rightPointer]>=pivot && leftPointer<rightPointer) {
		 * rightPointer--; } swap(array,leftPointer,rightPointer); }
		 * swap(array,leftPointer,high);
		 */
		
		int leftPointer = partition(array, low, high);
		
		//recursively partitioning at left and right of pivot
		quicksort(array,low,leftPointer-1);
		quicksort(array,leftPointer+1,high);
	}

	private static int partition(int[] array, int low, int high) 
	{
		int pivot = array[high];
		int leftPointer = low;
		int rightPointer =high;
		
		while(leftPointer<rightPointer)
		{
			while(array[leftPointer]<=pivot && leftPointer<rightPointer)
			{
				leftPointer++;
			}
			
			while(array[rightPointer]>=pivot && leftPointer<rightPointer)
			{
				rightPointer--;
			}
			swap(array,leftPointer,rightPointer);			
		}
		swap(array,leftPointer,high);
		return leftPointer;
	}
	
	public static void main(String[] args) 
	{
		Random random =new Random();
		int[] nums= new int[10];
		
		for(int i=0;i<nums.length;i++)
		{
			nums[i]=random.nextInt(100);
		}
		
		System.out.println("\n before:");
		for(int i=0;i<nums.length;i++)
		{
			System.out.println(nums[i]);
		}
		quicksort(nums,0,nums.length-1);
		System.out.println("\n after:");
		for(int i=0;i<nums.length;i++)
		{
			System.out.println(nums[i]);
		}
	}
}