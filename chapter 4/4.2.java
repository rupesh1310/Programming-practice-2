class Deque					
{
	private int maxSize;
	private long[] arr;
	private int nItems;
	
	private int left;
	private int right;
	
	public Deque(int s)
	{
		maxSize = s;
		arr = new long[maxSize];
		nItems = 0;
		
		left = 1;
		right = 0;
	}

//------------------------------------------------------

	public long peekLeft()
	{
		return arr[left];
	}
	
//------------------------------------------------------

	public long peekRight()
	{
		return arr[right];
	}	

//------------------------------------------------------
//------------------------------------------------------

public void insertLeft(long value)
	{
		if(!isFull())
		{
			left--;
			if(left < 0) 
left = maxSize-1;
			arr[left] = value;
			nItems++;
		}
		else System.out.println("The Queue is full!");	
	}

//------------------------------------------------------

	public long removeLeft()
	{
		if(!isEmpty())
		{
			long temp = arr[left];
			left++;
			if(left >= maxSize) 
left = 0;
			nItems--;
			return temp;
		}
		else
		{
			System.out.println("The Queue is empty!");
			return -1;
		}
	}
	
//------------------------------------------------------
//------------------------------------------------------

	public void insertRight(long value)
	{
		if(!isFull())
		{
			right++;
			if(right >= maxSize) 
right = 0;
			arr[right] = value;
			nItems++;
		}
		else System.out.println("The Queue is full!");
	}
	

//------------------------------------------------------

	public long removeRight()
	{
		if(!isEmpty())
		{
			long temp = arr[right];
			right--;
			if(right < 0) 
right = maxSize-1;
			nItems--;
			return temp;
		}
		else
		{
			System.out.println("The Queue is empty!");
			return -1;
		}
	}
	

//------------------------------------------------------

//------------------------------------------------------

	public Boolean isEmpty()
	{
		if(nItems == 0) return true;
		else return false;	
	}	

//------------------------------------------------------
	
	public Boolean isFull()
	{
		if(nItems == maxSize) return true;
		else return false;
	}
	

//------------------------------------------------------

	public void display()
	{
	System.out.println("Left: " + left + ", Right: " + right);
		int index = left;
		for(int i = 0; i < nItems; i++)
		{
			if(index >= maxSize) 
				index = 0;
			System.out.print(arr[index] + " ");
			index++;
		}	
		System.out.println("");
	}
}

//------------------------------------------------------
//------------------------------------------------------

public class DeQueueApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deque DQ = new Deque(6);

		DQ.insertRight(70);
		DQ.insertLeft(30);
		DQ.insertLeft(50);
		DQ.insertLeft(10);
		DQ.insertRight(40);
		DQ.insertRight(20);
		
		
		DQ.display();
		
		while( !DQ.isEmpty() )
		{
		//long item = DQ.removeLeft(); //10,50,30,70,40,20
		long item = DQ.removeRight();  //20,40,70,30,50,10
		System.out.print(item + " ");  
		} // end while
		System.out.println(" ");
	}

}
