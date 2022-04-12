package sortings.insertionSort;

import java.util.Random;

public class InsertionSort {

	// Here we set the size of the array list that we will use
	public static int array_size = 1000000;
	
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
		insertionsort(numbers);	
		
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
	 * The insertionSort sorting algorithm.
	 * Complexity: O(n*n)
	 * */
	private static void insertionsort(int[] numbers)
	{
		int array_size = numbers.length;
		
		for(int j = 1; j < array_size; j++)
		{
			int key = numbers[j];
			int i = j - 1;
			
			while(i >= 0 && numbers[i] > key)
			{
				numbers[i+1] = numbers[i];
				i--;
			}
			numbers[i+1] = key;
		}
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
