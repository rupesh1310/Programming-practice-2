class Queue
	{
		private int maxSize;
		private long[] queArray;
		private int front;
		private int rear;
		private int nItems;

public Queue(int s)
	{
		maxSize = s;
		queArray =  new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
public void insert(long j)
	{
		if(rear == maxSize-1)
			rear = -1;
		queArray[++rear] = j;
		nItems++;
	}
public long remove()
	{
		long temp = queArray[front++];
		if(front == maxSize)
			front = 0;
		nItems--;
		return temp;
	}
public long peekFront()
	{
		return queArray[front];
	}

public boolean isEmpty()
	{
		return (nItems == 0);
	}
public boolean isFull()
	{
		return (nItems == maxSize);
	}
public int size()
	{
		return nItems;
	}
}
class QueueApp
   {
   public static void main(String[] args)
      {
      Queue theQueue = new Queue(5);  // queue holds 5 items

      theQueue.insert(10);            // insert 4 items
      theQueue.insert(20);
      theQueue.insert(30);
      theQueue.insert(40);

      theQueue.remove();              // remove 3 items
      theQueue.remove();              //    (10, 20, 30)
      theQueue.remove();

      theQueue.insert(50);            // insert 4 more items
      theQueue.insert(60);            //    (wraps around)
      theQueue.insert(70);
      theQueue.insert(80);

      while( !theQueue.isEmpty() )    // remove and display
         {                            //    all items
         long n = theQueue.remove();  // (40, 50, 60, 70, 80)
         System.out.print(n);
         System.out.print(" ");
         }
      System.out.println("");
      }  // end main()
   }