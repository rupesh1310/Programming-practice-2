//The selection sort algorithm sorts an array 
//by repeatedly finding the minimum 
//element (considering ascend
//ing order) from unsorted part and putting it at the beginning. 
//The algorithm maintains two subarrays in a given array.
//1) The subarray which is already sorted.
//2) Remaining subarray which is unsorted.

//In every iteration of selection sort, 
//the minimum element (considering ascending order) 
//from the unsorted subarray is picked and 
//moved to the sorted subarray. 

class ArraySel
	{
		private long[] a;
		private int nElems;

	public ArraySel(int max)
		{
			a = new long[max];
			nElems = 0;
		}
 public void insert(long value)
 	{
 		a[nElems] = value;
 		nElems++;
 	}

public void display()
	{
		for(int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println("");
	}

public void selectionSort()
	{
		int out, in, min;
	for(out = 0; out < nElems-1; out++)
	{
		min = out;
		for(in = out+1; in < nElems; in++)
			if(a[in] < a[min] )
				min = in;
			swap(out, min);
	}
}

private void swap(int one, int two)
	{
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}	
}

class selectionsort
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArraySel arr;                 // reference to array
      arr = new ArraySel(maxSize);  // create the array

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();                // display items

      arr.selectionSort();          // selection-sort them

      arr.display();                // display them again
      }  // end main()
   }  


