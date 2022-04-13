package sortings.quickSort;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
	
	// So far it is the quickest and more efficient (storage-wise) sorting algorithm i have ever coded 
	// It took 10 minutes to sort 1000000000 elements
	
	// Here we set the size of the array list that we will use
	public static int array_size = 1000000000;

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
		
		// Calling the Quick Sort function
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
	
	/**
	 * The quicksort sorting algorithm.
	 * Complexity: O(n*log(n))
	 */
	private static void quicksort(int[] numbers, int p, int r)
	{
		// Testing if the array called has more than 1 element in it
		if(p < r)
		{
			// Selecting a random element from the list to make a partition based on its value
			int q = random_partition(numbers,p,r);
			
			// Recursively call the quicksort function
			quicksort(numbers,p,q-1);
			quicksort(numbers,q+1,r);
		}
	}
	
	/**
	 * Randomly selecting an element from the list to make a partition based on its value.
	 * Then, calling the partition() to actually make the partition.  
	 * */
	private static int random_partition(int[] numbers, int p, int r)
	{
		// Selecting a random element from the list to make a partition based on its value
		int i = ThreadLocalRandom.current().nextInt(p, r + 1);
		// Swapping the random element, with the first element of the list
		swap(numbers,p,i);
		
		// Calling the partition function to actually make the partition
		return partition(numbers,p,r);
	}
	
	/**
	 * Partitioning all the elements of the list from the selected
	 * To the left, there will only be smaller numbers from it
	 * To the right, there will only be bigger numbers from it
	 * */
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
	
	/**
	 * Swapping 2 ellements from a given function
	 * */
	private static void swap(int[] numbers, int i, int j)
	{
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	/**
	 * A method that prints all the elements of an array
	 * (Very big arrays may take a while..)
	 * */
	private static void printArray(int[] numbers)
	{
		for(int i = 0; i < numbers.length; i++)
		{
			System.out.println(numbers[i]);
		}
	}
	
	/**
	 * A method that tests if an array is sorted or not
	 * */
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
