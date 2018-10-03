class ArrayIns
	{
		private long[] a;
		private int nElems;

public ArrayIns(int max)
	{
		a = new long[max];
		nElems = 0;
	}

public long median() {
	insertSort();
	int mid = nElems/2;
	if (nElems % 2 == 1) //odd
		return a[mid];
	else return (a[mid] + a[mid - 1]) / 2;
}

	public void insertSortModified() {
		int in, out;
		int nCopies = 0;
		int nComps = 0;

	for(out = 1; out < nElems; out++) {
		long temp = a[out];
		nCopies++;
		in = out;
		while(in > 0 && a[in - 1] >= temp) {
			a[in] = a[in - 1];
			--in;
			nCopies++;
			nComps++;
		}
	      if (in != 0) nComps++; // captures last unsuccessful comparison
	      a[in] = temp;
	      nCopies++;
	   }
	   System.out.println("Copies: " + nCopies + ". Comparisons: " + nComps);
   }

   public void insertionSortRemoveDups() {
  	 
	   int in, out;
	   int nDups = 0;
	
	   for(out=1; out<nElems; out++) {
	   	long temp = a[out];
	      in = out;
	      while(in > 0 && a[in-1] >= temp) {
	      	if (a[in-1] == temp) {
					temp = -1;
	 				nDups++;
				}
				a[in] = a[in-1];
				--in;
	      }
	      a[in] = temp;
	   }
	   display();
	   // Remove -1's
	   if (nDups != 0) {
		   for (int i = nDups; i < nElems; i++) {
				a[i - nDups] = a [i];
			}
		}
	   nElems = nElems - nDups;
   }
   
   public void noDups() {
   	insertionSort();
   	int nDel=0;
   	//loop through changing duplicates to -1
   	long comp=a[0];
   	for (int i=1;i<nElems;i++) {
   		if (a[i]==comp) {
   			a[i]=-1;
   			nDel++;
   		}
   		else comp = a[i];
   	}
   	// remove -1's
   	int i, j;
   	for (i=0;i<nElems;i++) {
   		if (a[i] == -1) {
   			j=i+1;
   			while(a[j] == -1) j++;
   			a[i]=a[j];
   			a[j]=-1;
   		}
   	}
   	nElems=nElems-nDel;
   }
   
   
   
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
   public void insertionSort()
      {
      int in, out;

      for(out=1; out<nElems; out++)     // out is dividing line
         {
         long temp = a[out];            // remove marked item
         in = out;                      // start shifts at out
         while(in>0 && a[in-1] >= temp) // until one is smaller,
            {
            a[in] = a[in-1];            // shift item to right
            --in;                       // go left one position
            }
         a[in] = temp;                  // insert marked item
         }  // end for
      }  // end insertionSort()
//--------------------------------------------------------------
   }  // end class jf248.lafore.ArrayIns
////////////////////////////////////////////////////////////////
class InsertSortApp
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
      arr.insert(11);
   

      arr.display();                // display items

      arr.insertionSortRemoveDups();          // insertion-sort them

      arr.display();                // display them again
      System.out.println(arr.median());
      
      //3.2
      arr = new ArrayIns(maxSize);
      arr.insert(1); arr.insert(1); arr.insert(1); arr.insert(3); arr.insert(3); arr.insert(2);
      arr.display();
      arr.noDups();
      arr.display();
      
      }  // end main()
   }  