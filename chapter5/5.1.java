class Link
{
	public long dData;	// data item
	public Link next;   // next link in list
	
	public Link(long dd)
	{ 
dData = dd; 
}
	
	public void displayLink()
	{ 
System.out.print(dData + " "); 
}
}



class SortedList
{
	private Link first;
	
	public SortedList()
	{
		first = null;
	}
	
	public boolean isEmpty()
{ 
return (first==null);
 }
	
	public void insert(long key)
	{
		Link newLink = new QLink(key);
		Link previous = null;
		Link current = first;
		

		while(current != null && key > current.dData)
		{
			previous = current;
	current = current.next;
		}

		if(previous == null)
			first = newLink;
		else
			previous.next = newLink;
		newLink.next = current;
	}

		
	public Link remove()
	{
		Link temp = first;
		first = first.next;
		return temp;
	}
	

	public void displayList()
	{
		System.out.print("List (first-->last): ");
		Link current = first;

		while(current != null)
		{
			 current.displayLink();
			 current = current.next;
		}
		System.out.println("");
	}





	
	public long getFirst()
	{
		return first.dData;
	}
}



class PriorityQueue
{
	SortedList queList;
	
	public PriorityQueue()
	{
		queList = new SortedList();
	}
	
	public void insert(long value)
	{
		queList.insert(value);
	}
	
	public Link remove()	//removes link with the smallest key
	{
		if(queList.isEmpty())
		{
			System.out.println("Queue is empty.");
			return null;
		}
		return queList.remove();
	}
	
	public long peekMin()
	{
		return queList.getFirst();
	}

	
	public boolean isEmpty()
	{
		return queList.isEmpty();
	}
	
	public void display()
	{
		queList.displayList();
	}
}


class ListPriorityQueue App
{
	public static void main(String[] args)
	{
		PriorityQueue Q = new PriorityQueue();
Q.insert(5);
		Q.insert(10);
		Q.insert(1);
		long temp = Q.peekMin();
		System.out.println("MIN IS " + temp);
		
		Q.remove();
		Q.remove();
		Q.display();
		
		Q.insert(600);
		Q.insert(2250);
		Q.insert(1);
		Q.insert(15);
		Q.display();
		
		Link answer = Q.remove();
		System.out.println(temp.dData);
		
		temp = Q.remove();
		System.out.println(temp.dData);
		
		temp = Q.remove();
		System.out.println(temp.dData);
		
		temp = Q.remove();
		System.out.println(temp.dData);
		
		temp = Q.remove();
		System.out.println(temp.dData);
		
		temp = Q.remove();
	}
}
