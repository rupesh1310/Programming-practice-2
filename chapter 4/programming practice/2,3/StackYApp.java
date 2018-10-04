//4.2 Create a Deque class based on the discussion of deques (double-ended queues) in
// this chapter. It should include insertLeft(), insertRight(), removeLeft(),
// removeRight(), isEmpty(), and isFull() methods. It will need to support wraparound
// at the end of the array, as queues do.

//4.3 Write a program that implements a stack class that is based on the Deque class
// in Programming Project 4.2. This stack class should have the same methods
// and capabilities as the StackX class in the stack.java program (Listing 4.1)

class Deque {
   private int maxSize;
   private long[] queArray;
   private int left;
   private int right;
   private int nItems;

   public Deque(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      left = maxSize;
      right = -1;
      nItems = 0;
      }

   public void insertLeft(long j) {
   	if(left == 0)         		// deal with wraparound
         left = maxSize;
      queArray[--left] = j;		// increment rear and insert
      if (right == -1) {			// initializes right	
			right = maxSize-1;
		}
      nItems++;  
   }
   
   public void insertRight(long j) {
   	if(right == maxSize -1)		// deal with wraparound
         right = -1;
      queArray[++right] = j;     // increment rear and insert
      if (left == maxSize) {		// initializes left
			left = 0;
		}
      nItems++;  
   }
   
   public long removeLeft() {
   	long temp = queArray[left++];
   	if (left == maxSize) {
   		left = 0;
   	}
   	nItems--;
   	return temp;
   }
   
   public long removeRight() {
   	long temp = queArray[right--];
   	if (right == -1) {
   		right = maxSize-1;
   	}
   	nItems--;
   	return temp;
   }

   public boolean isEmpty()    // true if queue is empty
      {
      return (nItems==0);
      }

   public boolean isFull()     // true if queue is full
      {
      return (nItems==maxSize);
      }
   public int size()           // number of items in queue
      {
      return nItems;
      }

   public void display() {
   	String s = "programming.projects.chap4 contents (left --> right): ";
   	if (nItems == 0) {
   		s = "programming.projects.chap4 is empty.";
		} else {
	   	int j = left;
	   	for (int i = 0; i < nItems; i++) {
            s += queArray[j++] + " ";
				if (j == maxSize) {			// catch wraparound
					j = 0;
				}
			}
		}
   	System.out.println(s);
   }
   
   public long peekRight() {
   	return queArray[right];
   }
}  

class StackY {
	private Deque dequeStack;
	
	public StackY(int maxSize) {		// constructor
		dequeStack = new Deque(maxSize);
	}
	
	public void push(long j) {
		dequeStack.insertRight(j);
	}
	
	public long pop() {
		return dequeStack.removeRight();
	}
	
	public long peek() {
		return dequeStack.peekRight();
	}
	
	public boolean isEmpty() {
		return dequeStack.isEmpty();
	}
	
	public boolean isFull() {
		return dequeStack.isFull();
	}
	
}
	
class DequeApp
   {
   public static void main(String[] args)
      {
      Deque theQueue = new Deque(5);  // queue holds 5 items

      theQueue.insertRight(10);            // insert 4 items
      theQueue.insertRight(20);
      theQueue.insertRight(30);
      theQueue.insertRight(40);
      
      theQueue.removeLeft();              // remove 3 items
      theQueue.removeRight();              //    (10, 20, 30)
      theQueue.removeRight();

      theQueue.insertRight(50);            // insert 4 more items
      theQueue.insertRight(60);            //    (wraps around)
      theQueue.insertRight(70);
      theQueue.insertRight(80);   
      
      theQueue.display();

      }  // end main()
   }  // end class 

class StackYApp {
	public static void main(String[] args) {
		StackY theStackY = new StackY(5);
		theStackY.push(10);
		theStackY.push(20);
		theStackY.push(30);
		while (!theStackY.isEmpty()) {
			System.out.print(theStackY.pop() + " ");
		}
	}
}
