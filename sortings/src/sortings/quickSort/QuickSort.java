package sortings.quickSort;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
	
	// So far it is the quickest sorting algoritm i have ever coded 
	
	// Here we set the size of the array list that we will use
	public static int array_size = 100000000;

	public static void main(String[] args) {
		
		Random rand = new Random();
		int[] numbers = new int[array_size];
		
		// Initializing a very large array with random numbers 
		for(int i = 0; i < numbers.length; i++)
		{
			numbers[i] = rand.nextInt(1000000);
		}
		
		// Printing the elements of the list
//		printArray(numbers);
		// Verifying if the array is sorted or not
		System.out.println("Is the array sorted?");
		System.out.println(isSorted(numbers));	
		
		System.out.println("Starting the sorting of " + numbers.length + " elements:");
		System.out.println("...");
		
		long start = System.currentTimeMillis(); // Initializing a timestamp
		
		// Calling the Merge Sort function
		quicksort(numbers,0,numbers.length-1);	
		
		long finish = System.currentTimeMillis(); // Ending a timestamp
		long timeElapsed = finish - start;
		
		System.out.println("Sorting has ended");
		System.out.println("Time elapsed:");
		System.out.println(timeElapsed + " milliseconds");
		// Printing the elements of the list
//		printArray(numbers);
		// Verifying if the array is sorted or not
		System.out.println("Is the array sorted?");
		System.out.println(isSorted(numbers));	

	}
	
	private static void quicksort(int[] numbers, int p, int r)
	{
		if(p < r)
		{
			int q = random_partition(numbers,p,r);
			quicksort(numbers,p,q-1);
			quicksort(numbers,q+1,r);
		}
	}
	
	private static int random_partition(int[] numbers, int p, int r)
	{
		//Random rand2 = new Random();		
		//int i = rand2.nextInt((r-p) + 1) + p;
		
		int i = ThreadLocalRandom.current().nextInt(p, r + 1);
		swap(numbers,p,i);
		
		return partition(numbers,p,r);
	}
	
	private static int partition(int[] numbers, int p, int q)
	{
		int x = numbers[p];	
		int i = p;
		
		for(int j = p+1; j <= q; j++)
		{
			if(numbers[j] <= x)
			{
				i = i+1;
				swap(numbers,i,j);
			}			
		}
		swap(numbers,p,i);
		return i;
	}
	
	private static void swap(int[] numbers, int i, int j)
	{
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	private static void printArray(int[] numbers)
	{
		for(int i = 0; i < numbers.length; i++)
		{
			System.out.println(numbers[i]);
		}
	}
	
	// A method that tests if an array is sorted or not
	private static boolean isSorted(int[] numbers)
	{
		int arrayLength = numbers.length;
		boolean isSorted = true;
		
		for(int i = 0; i < arrayLength; i++)
		{
			if(i < arrayLength-1)
			{
				if(numbers[i] > numbers[i+1])
				{
					isSorted = false;
				}
			}
		}
		return isSorted;
	}

}
