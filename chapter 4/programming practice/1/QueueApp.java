// Write a method for the Queue class in the queue.java program (Listing 4.4) that
// displays the contents of the queue. Note that this does not mean simply
// displaying the contents of the underlying array. You should show the queue
// contents from the first item inserted to the last, without indicating to the
// viewer whether the sequence is broken by wrapping around the end of the
// array. Be careful that one item and no items display properly, no matter where
// front and rear are.
class Queue
   {
   private int maxSize;
   private long[] queArray;
   private int front;
   private int rear;
   private int nItems;

   public Queue(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
      }

   public void insert(long j)   // put item at rear of queue
      {
      if(rear == maxSize-1)         // deal with wraparound
         rear = -1;
      queArray[++rear] = j;         // increment rear and insert
      nItems++;                     // one more item
      }

   public long remove()         // take item from front of queue
      {
      long temp = queArray[front++]; // get value and incr front
      if(front == maxSize)           // deal with wraparound
         front = 0;
      nItems--;                      // one less item
      return temp;
      }

   public long peekFront()      // peek at front of queue
      {
      return queArray[front];
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
   	String s = "programming.projects.chap4 contents (front --> back): ";
   	if (nItems == 0) {
   		s = "programming.projects.chap4 is empty.";
		} else {
	   	int j = front;
	   	while (j != rear) {				// loop from front to back of queue
				s += queArray[j++] + " ";
				if (j == maxSize) {			// catch wraparound
					j = 0;
				}
			}
	   	s += queArray[j];					// display rear
		}
   	System.out.println(s);
   }

   }  // end class

class QueueApp
   {
   public static void main(String[] args)
      {
      Queue theQueue = new Queue(5);  // queue holds 5 items

      
      theQueue.display();

      while( !theQueue.isEmpty() )    
         {                            
         long n = theQueue.remove();  
         System.out.print(n);
         System.out.print(" ");
         }
      System.out.println("");
      }  // end main()
   }  // end class 


