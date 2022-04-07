package sortings.heapSort;

import java.util.ArrayList;

public class Heap {

	public static int parent(int i) 
	{ 
		if(i % 2 == 0)
		{
			return i/2 - 1; 
		}
		else
		{
			return (i-1)/2 - 1;
		}
	}
	
	public static int left(int i)
	{
		if(i == 0)
		{
			return 1;
		}
		else
		{
			return i*2 - 1;
		}
	}
	
	public static int right(int i)
	{
		if(i == 0)
		{
			return 2;
		}
		else
		{
			return 2*i; 
		}
		
	}
	
	public static int Heapify(ArrayList list, int i)
	{
		int largest;
		
		int l = Heap.left(i);
		int r = Heap.right(i);
		
		int x = (int) list.get(l);
		int y = (int) list.get(r);
		int z = (int) list.get(i);
		
		if (l <= list.size()-1 && x > z)
		{
			largest = l;
		}
		else
		{
			largest = i;
		}
		
		
		return i;		
	}
}
	

