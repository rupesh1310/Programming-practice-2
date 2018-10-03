class ArrayBub
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items

   public ArrayBub(int max)          // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }

   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }

   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }

   public void bubbleSortBi() {
      int in;
      int outL = 0;
      int outR = nElems-1;
      int inc = 1;   // 1 or -1

      while (outL != outR) {
         if (inc == 1) {
            for (in=outL; in<outR; in++)
               if( a[in] > a[in+1] )
                  swap(in, in+1);
            inc = -1;
            outR--;
         }
         else {
            for (in=outR; in>outL; in--)
               if( a[in] < a[in-1] )
                  swap(in, in-1);
            inc = 1;
            outL++;
         }
      }

   }
   
   public void oddEvenSort() {
      int out, in;
      int i;
      int nInPasses = nElems / 2; // Number of odd/even passes per outer cycle.
                                  // Worst case of large number at a[0] requires
                                  // nInPasses to get it to 'bubble' to a[nElems-1]
      for (out=nElems-1; out>1; out --) {
         for (i=0; i<nInPasses; i++ ) {
            for(in=0; in<out; in+=2) // even loop
               if (a[in] > a[in+1] )
                  swap(in, in+1);
            for(in=1; in<out; in+=2) // odd loop
               if (a[in] > a[in+1] )
                  swap(in, in+1);
         }

      }
   }
   
   public void bubbleSort()
   {
   int out, in;
   for(out=nElems-1; out>1; out--)   // outer loop (backward)
      for(in=0; in<out; in++)        // inner loop (forward)
         if( a[in] > a[in+1] )       // out of order?
            swap(in, in+1);          // swap them
   }  // end bubbleSort()

   private void swap(int one, int two)
      {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
      }

   }  // end class jf248.lafore.ArrayBub



class bubblesortapp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArrayBub arr;                 // reference to array
      arr = new ArrayBub(maxSize);  // create the array

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
      arr.insert(5);

      arr.display();                // display items

      arr.oddEvenSort();             // bubble sort them

      arr.display();                // display them again
      }  // end main()
   }  
