// The priority queue shown in Listing 4.6 features fast removal of the high-priority
// item but slow insertion of new items. Write a program with a revised
// PriorityQ class that has fast O(1) insertion time but slower removal of the highpriority
// item. Include a method that displays the contents of the priority
// queue, as suggested in Programming Project 4.1.

class PriorityQ
   {
   // array in sorted order, from max at 0 to min at size-1
   private int maxSize;
   private long[] queArray;
   private int nItems;


   public PriorityQ(int s)          // constructor
   	{
      maxSize = s;
      queArray = new long[maxSize];
      nItems = 0;
   	}



   public void insert(long item) {
   	queArray[nItems++] = item;
   }
   
   public long remove() {  	
   	int j = 0;										// find min
   	for (int i = 1; i < nItems; i++) {
			if (queArray[i] < queArray[j]) {
				j = i;
			}
		}
   	long temp = queArray[j];
   	for (int i = j + 1; i < nItems; i++) {		// remove min and shuffle down
   		queArray[i - 1]= queArray[i];
   	}
   	nItems--;										// decrement nItems
   	return temp;
   }
   
  public void display() {											// no wrap-around
   	String s = "prog.practice.Queue contents (front --> rear): ";
   	if (nItems == 0) {
   		s = "prog.practice.Queue is empty.";
		} else {
	   	int j = 0;
	   	for (int i = 0; i < nItems; i++) {
            s += queArray[j++] + " ";
			}
		}
   	System.out.println(s);
   }

   public boolean isEmpty()         // true if queue is empty
      { return (nItems==0); }

   public boolean isFull()          // true if queue is full
      { return (nItems == maxSize); }

   }  // end class

class PriorityQApp
   {
   public static void main(String[] args)
      {
      PriorityQ thePQ = new PriorityQ(5);
      thePQ.insert(30);
      thePQ.insert(50);
      thePQ.insert(10);
      thePQ.insert(40);
      thePQ.insert(20);
      
      thePQ.display();
      
      while( !thePQ.isEmpty() )
         {
         thePQ.remove();
         thePQ.display();
         }  // end while
      System.out.println("");
      }  // end main()

   }  // end class 
