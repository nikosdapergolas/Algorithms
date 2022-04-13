package general.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class BinarySearch {
	
	// Here we set the size of the array list that we will use
	public static int array_size = 1000000000;

	public static void main(String[] args) {
		
//		Random rand = new Random();
		int[] numbers = new int[array_size];
		
		// Initializing a very large array with random numbers 
		for(int i = 0; i < numbers.length; i++)
		{
//			numbers[i] = rand.nextInt(1000000);
			numbers[i] = i;
		}
		
		System.out.println("Please enter bellow the number you are looking for");
		// Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try 
		{
			// Reading data using readLine
	        String string_number = reader.readLine();
	        int number = Integer.parseInt(string_number);
	        
	        System.out.println("Starting the searching in " + numbers.length + " elements:");
			System.out.println("...");
			
			long start = System.currentTimeMillis(); // Initializing a timestamp
	        
	        boolean found_it = binarySearch(numbers,0,numbers.length-1,number);
	        
	        long finish = System.currentTimeMillis(); // Ending a timestamp
			long timeElapsed = finish - start;
			
			System.out.println("Searching has ended");
			System.out.println("Time elapsed:");
			System.out.println(timeElapsed + " milliseconds");
	        
	        if(found_it)
	        {
	        	System.out.println("I found your number");
	        }
	        else
	        {
	        	System.out.println("There is no such number");
	        }
	        
			// Printing the read line
//	        System.out.println("Your age is: " + number);
		} 
		catch (IOException e) 
		{
			System.out.println("Sorry!! There was an error.");
			e.printStackTrace();
		}
	}
	
	private static boolean binarySearch(int[] numbers, int starting_position, int ending_position, int x)
	{
		int mid = (ending_position + starting_position) / 2;
		
		if(ending_position == starting_position && numbers[mid] != x)
		{
			// The case where it is not in the list
			return false;
		}
		
		if(x == numbers[mid])
		{
			// The case where we found it
			return true;
		}
		else if(x < numbers[mid])
		{
			// Search in the left half
			return binarySearch(numbers,0,mid - 1,x);
		}
		else if(x > numbers[mid])
		{
			// Search in the right half
			return binarySearch(numbers,mid + 1,ending_position,x);
		}
		
		return true;
	}

}
