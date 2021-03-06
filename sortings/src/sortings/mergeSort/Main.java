package sortings.mergeSort;

import java.util.Random;

public class Main {
	
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
		
		System.out.println("Starting the sorting of " + numbers.length + " elements:");
		System.out.println("...");
		// Printing the elements of the list
		//printArray(numbers);
		// Verifying if the array is sorted or not
		//System.out.println(isSorted(numbers));		
		
		long start = System.currentTimeMillis(); // Initializing a timestamp
		
		// Calling the Merge Sort function
		mergesort(numbers);	
		
		long finish = System.currentTimeMillis(); // Ending a timestamp
		long timeElapsed = finish - start;
		
		System.out.println("Sorting has ended");
		System.out.println("Time elapsed:");
		System.out.println(timeElapsed + " milliseconds");
		// Printing the elements of the list
		//printArray(numbers);
		// Verifying if the array is sorted or not
		//System.out.println(isSorted(numbers));	
		
	}
	
	private static void mergesort(int[] inputArray)
	{
		int inputLength = inputArray.length; // Length of the input array
		
		if(inputLength < 2)
		{
			//if the length of the current array is 1, then it is time for merge()
			return;
		}
		
		int midIndex = inputLength/2; // index of the middle element of the array
		int[] leftHalf = new int[midIndex]; // The left-half array
		int[] rightHalf = new int[inputLength - midIndex]; // The right-half array
		
		// Filling the left-half array
		for(int i = 0; i < midIndex; i++)
		{
			leftHalf[i] = inputArray[i];
		}
		
		// Filling the right-half array
		for(int i = midIndex; i < inputLength; i++)
		{
			rightHalf[i - midIndex] = inputArray[i];
		}
		
		// Recursively calling the left sub-array
		mergesort(leftHalf);
		
		// Recursively calling the right sub-array
		mergesort(rightHalf);
		
		// Merging all the one-element sub-arrays
		merge(inputArray, leftHalf, rightHalf);
		
	}
	
	private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf)
	{
		int leftSize = leftHalf.length; // Size of the left sub-array
		int rightSize = rightHalf.length; // Size of the right sub-array
		
		int i = 0, j = 0, k = 0;
		
		// Merging the elements of the left and right sub-arrays
		while(i < leftSize && j < rightSize)
		{
			if(leftHalf[i] <= rightHalf[j])
			{
				inputArray[k] = leftHalf[i];
				i++;
			}
			else
			{
				inputArray[k] = rightHalf[j];
				j++;
			}
			k++;
		}
		
		// If left sub-array still has some elements, 
		// fill the rest of the input array with the rest of the left sub-array elements 
		while(i < leftSize)
		{
			inputArray[k] = leftHalf[i];
			i++;
			k++;
		}
		
		// If right sub-array still has some elements, 
		// fill the rest of the input array with the rest of the right sub-array elements 
		while(j < rightSize)
		{
			inputArray[k] = rightHalf[j];
			j++;
			k++;
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
	
	private static void printArray(int[] numbers)
	{
		for(int i = 0; i < numbers.length; i++)
		{
			System.out.println(numbers[i]);
		}
	}

}
