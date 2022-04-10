package sortings.heapSort;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	// In my computer, it took 6 minutes and 9 seconds to sort an array of 1000000000 elements
	// and 30 seconds for 100000000 elements
	// This algorithm has a complexity of O(n*log(n)), which is the some as merge sort algorithm
	// but after some test, I observed that for 100000000 elements, it took almost double the time
	// that merge sort took to sort them. But!!
	// The benefit of this algorithm is that it uses half the space, because it does not need a second
	// array to put in the sorted elements as merge sort does
	
	// Here we set the size of the array list that we will use
	public static int heap_size = 100000000;

	public static void main(String[] args) {
		
		Random rand = new Random();
		int[] numbers = new int[heap_size];
		
		// Initializing a very large array with random numbers 
		for(int i = 0; i < numbers.length; i++)
		{
			numbers[i] = rand.nextInt(1000000);
		}
		
		System.out.println("Starting the sorting of " + heap_size + " elements:");
		System.out.println("...");
		// Printing the elements of the list
		//printArray(numbers);
		// Verifying if the array is sorted or not
		System.out.println("Is the array sorted?");
		System.out.println(isSorted(numbers));	
		System.out.println("Starting sorting");
		
		long start = System.currentTimeMillis(); // Initializing a timestamp
		
		// Calling the Heap Sort function
		heapsort(numbers);
		
		long finish = System.currentTimeMillis(); // Ending a timestamp
		long timeElapsed = finish - start;
		
		System.out.println("Sorting has ended");
		System.out.println("Time elapsed:");
		System.out.println(timeElapsed + " milliseconds");
		// Printing the elements of the list
		//printArray(numbers);
		// Verifying if the array is sorted or not
		System.out.println("Is the array sorted?");
		System.out.println(isSorted(numbers));

	}
	
	private static void heapsort(int[] numbers)
	{
		//int heap_size = numbers.length;
		buildHeap(numbers);
		for(int i = heap_size-1; i > 0; i--)
		{
			swap(numbers,0,i);
			heap_size--;
			heapify(numbers,0);
		}
	}
	
	private static void buildHeap(int[] numbers)
	{
		//int heap_size = numbers.length;
		for(int i = heap_size/2; i >= 0; i--)
		{
			heapify(numbers,i);
		}
	}
	
	private static void heapify(int[] numbers, int i)
	{
		int largest = -1;
		//int heap_size = numbers.length;
		int l = left(i), r = right(i);
		
		if (l < heap_size && numbers[l] > numbers[i])
		{
			largest = l;
		}
		else
		{
			largest = i;
		}
		if (r < heap_size )
		{
			if(numbers[r] > numbers[largest])
			{
				largest = r;
			}
		}
		if (largest != i) 
		{
			swap(numbers, i, largest);
			heapify(numbers, largest);
		}
	}
	
		
	private static int left(int i)
	{
		if(i == 0)
		{
			return 1;
		}
		else
		{
			return i*2 + 1;
		}
	}
	
	private static int right(int i)
	{
		if(i == 0)
		{
			return 2;
		}
		else
		{
			return 2*i +2; 
		}
	}
	
	private static void swap(int[] numbers, int i, int largest)
	{
		int temp = numbers[i];
		numbers[i] = numbers[largest];
		numbers[largest] = temp;
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
