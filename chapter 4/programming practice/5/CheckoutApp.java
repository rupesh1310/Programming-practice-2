// Queues are often used to simulate the flow of people, cars, airplanes, transactions,
// and so on. Write a program that models checkout lines at a supermarket,
// using the Queue class from the queue.java program (Listing 4.4). Several lines of
// customers should be displayed; you can use the display() method of
// Programming Project 4.1. You can add a new customer by pressing a key. You’ll
// need to determine how the customer will decide which line to join. The checkers
// will take random amounts of time to process each customer (presumably
// depending on how many groceries the customer has). Once checked out, the
// customer is removed from the line. For simplicity, you can simulate the passing
// of time by pressing a key. Perhaps every keypress indicates the passage of one
// minute. (Java, of course, has more sophisticated ways to handle time.)

import java.io.*;
import java.util.Random;

class QueueX
{
private int maxSize;
private long[] queArray;
private int front;
private int rear;
private int nItems;

public QueueX(int s)          // constructor
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

   public void decFront() {
      queArray[front]--;
      if (queArray[front] == 0) {
         remove();
      }
   }
   
   public void display() {
      String s = "";
      if (nItems != 0) {
         int j = front;
         while (j != rear) {           // loop from front to back of queue
            s += queArray[j++] + " ";
            if (j == maxSize) {        // catch wraparound
               j = 0;
            }
         }
         s += queArray[j] + " ";             // display rear
      }
      System.out.print(s);
   }

}  // end class jf248.lafore.Queue

class Checkout {
	
	private QueueX[] lines;
	private double time;	// current time in minutes 
	private double avgGrocPerMin;
	
	public Checkout(int nLines, int lineMax, double avgGrocPerMin) {		/* constructor */
		
		this.avgGrocPerMin = avgGrocPerMin;
		time = 0;
		
		lines = new QueueX[nLines];						// instantiate lines
		for (int i = 0; i < lines.length; i++) {
			lines[i] = new QueueX(lineMax);
		}
	}
	
	public void incrementTime(double incLength) {
		
	   /* During incLength, lambda grocery items will be processed
	    * in each queue. Where, lambda = avgGrocPerMin * incLength.
	    * Random probability is generated and, using Poisson distribution,
	    * number of groceries processed is calculated.
	    * E.g. when prob = 0.5, lamda groceries will be processed in the queue.c
	    * 
	    */

	   
		time += incLength; // increment time
		
		double lambda = avgGrocPerMin * incLength;
      Random rand = new Random();
		
		// loop through each queue
		for (int i = 0; i < lines.length; i++) {
			
		   if (lines[i].isEmpty()) {   // skip empty queues
			   continue;
			}
		   
			// loop to find number of groceries processed in interval
		   int k = 0;
		   double prob = rand.nextDouble();
		   while (true) {
		      // calc probability of exactly k groceries during interval (Poisson dist.) 
		      double probK = Math.pow(lambda, k) * Math.exp(-lambda) / factorial(k);
		      if (probK <= prob) { // increment k until cumulative probability, prob, reached
		         k++;
		         prob -= probK;
		      } else {
		         break;
		      }
		   }
		   
		   while (!lines[i].isEmpty() && k > 0) {
				lines[i].decFront(); // decrement grocery count
				k--;
		   }
		}
		this.display();
	}
	
	public void addCustomer(int maxItems) {
	   
	   // find shortest queue
	   int shortestQueue = 0;
	   long minSize = lines[0].size();
	   for (int i = 0; i < lines.length; i++) {
	      if (lines[i].size() < minSize) {
	         minSize = lines[i].size();
            shortestQueue = i;
         }
	   }
	   
	   // add customer to the queue
	   Random rand = new Random();
	   long items = rand.nextInt(maxItems) + 1;
	   lines[shortestQueue].insert(items);
	   
	   this.display();
	}
	
	public void display() {
	   System.out.println("Time (minutes): " + time);
	   for (int i = 0; i < lines.length; i++) {
         System.out.print("Line " + i + " (size: " + lines[i].size() + "): ");
         lines[i].display();
         System.out.println("");
      }
	   System.out.println("-----");
	}
	
	private static int factorial(int i) {
	   int fact = 1;
	   for (int j = 1; j <= i; j++) {
         fact *= j;
      }
	   return fact;
	}

}

class CheckOutApp {
	public static void main(String[] args) throws IOException {
	   
	   int nLines = 5;
	   int lineMax = 100;
	   double avgGrocPerMin = 2;
	   double incLength = 1;
	   int maxItems = 20;
	   
		Checkout theCheckout = new Checkout(nLines, lineMax, avgGrocPerMin);
		String s;
		while (true) {
		   System.out.print("Type 'c' to add customer, 'q' to quit and any other key to increment time by " + incLength + " minute(s).");
		   s = getString();
		   switch (s) {
		      case "c":
		         theCheckout.addCustomer(maxItems);
		         break;
		      case "q":
		         return;
		      default:
		         theCheckout.incrementTime(incLength);
		   }
		}
	}
	
	public static String getString() throws IOException {
	   InputStreamReader isr = new InputStreamReader(System.in);
	   BufferedReader br = new BufferedReader(isr);
	   String string = br.readLine();
	   return string;
	}
	
}
