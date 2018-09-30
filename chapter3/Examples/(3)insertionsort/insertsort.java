class ArrayIns
	{
		private long[] a;
		private int nElems;
	public ArrayIns(int max)
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

	public void insertionSort()
		{
			int in, out;
			for(out = 1; out < nElems; out++)
				{
					long temp = a[out];
					in = out;
					while(in > 0 && a[in-1] >= temp)
					{
						a[in] = a[in-1];
						--in;
					}
				a[in] = temp;
				} //end for insertionsort()
		}
	}
class insertsort
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArrayIns arr;                 // reference to array
      arr = new ArrayIns(maxSize);  // create the array

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

      arr.insertionSort();          // insertion-sort them

      arr.display();                // display them again
      }  // end main()
   }  // end class InsertSortApp
