class DLink
{
	public long lData;
	public DLink next;
	public DLink previous;
	
	public DLink(long value)
	{ 
lData = value; 
}
	
	public void displayLink()
	{ 
System.out.print(lData + " "); 
}
}



class DoublyLinkedList
{
	private DLink first;
	private DLink last;
	
	public DoublyLinkedList()
	{
first = null;
		last = null;
	}
	
	public boolean isEmpty()
	{ 
return (first==null); 
}

	
	public DLink peekFirst()
	{ 
return first;
 }
	
	public DLink peekLast()
	{ 
return last; 
}
	
	public void insertFirst(long value)
	{
		DLink newLink = new DLink(value);
		
		if(isEmpty()) 
			last = newLink;
		else
			first.previous = newLink;
		newLink.next = first;
		first = newLink;
	}
	
	public void insertLast(long value)
	{
		DLink newLink = new DLink(value);
		
		if(isEmpty())
			first = newLink;
		else
		{
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}
public DLink deleteFirst()
	{
		DLink temp = first;
		if(first.next == null)
			last = null;
		else
			first.next.previous = null;
		first = first.next;
		return temp;
	}
	
	public DLink deleteLast()
	{
		DLink temp = last;
		if(last.previous == null)
			first = null;
		else
			last.previous.next = null;
		last = last.previous;
		return temp;
	}
	
	public boolean insertAfter(long key, long value)
	{
		DLink current = first;
		while(current.lData != key)
		{
			current = current.next;
			if(current == null)
				return false;
		}
		DLink newLink = new DLink(value);
		
		if(current==back)
		{
			newLink.next = null;
			last = newLink;
		}
		else
		{
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		current.next = newLink;
		newLink.previous = current;
		return true;
}
	
	public DLink deleteKey(long value)
	{
		DLink current = first;
		while(current.lData != value)
		{
			current = current.next;
			if(current == null)
			{
				System.out.println("Couldn't find " + value + ".");
				return null;
			}
			
		}
		if(current==first)
			first = current.next;
		else
			current.previous.next = current.next;
		if(current==back)
			last = current.previous;
		else
			current.next.previous = current.previous;
		return current;
	}
	
	public void displayForward()
	{
		DLink current = first;
		System.out.print("List (first-->last): ");
		while(current != null)
		{
			System.out.print(current.lData + " ");
			current = current.next;
		}
		System.out.println("");
	}
	
	public void displayBackward()
	{
		DLink current = last;
		System.out.print("List (last-->first): ");
		while(current != null)
		{
			System.out.print(current.lData + " ");
			current = current.previous;
		}
		System.out.println("");
	}
}

class DequeLL	//Double-Ended Queue implemented with Doubly Linked List
{
	private DoublyLinkedList theList;
	
	public DequeLL()
	{ 
theList = new DoublyLinkedList(); 
}
	
	public long peekLeft()
	{ 
return theList.peekFirst().lData; 
}
	
	public long peekRight()
	current = current.previous;
		}
		System.out.println("");
	}
}

class DequeLL	//Double-Ended Queue implemented with Doubly Linked List
{
	private DoublyLinkedList theList;
	
	public DequeLL()
	{ 
theList = new DoublyLinkedList(); 
}
	
	public long peekLeft()
	{ 
return theList.peekFirst().lData; 
}
	
	public long peekRight()
	{ 
return theList.peekLast().lData; 
}
	


	public void insertLeft(long value)
	{ 
theList.insertFirst(value);
}
	
	
	public long removeLeft()
	{ 
return theList.deleteFirst().lData;
}
	
	public void insertRight(long value)
	{
 theList.insertLast(value); 
}
	
	public long removeRight()
	{
 return theList.deleteLast().lData;
 }
	
	public boolean isEmpty()
	{
 return theList.isEmpty(); 
}
	
	public void display()
	{ 
theList.displayForward(); 
}
}
class DLLApp
{
	public static void main(String[] args)
	{
		DequeLL deque = new DequeLL();
		deque.insertLeft(10);
		deque.insertLeft(20);
		deque.insertLeft(30);
		deque.insertRight(40);
		deque.insertRight(50);
		deque.insertRight(60);
		deque.display();
		
		System.out.println("Peek left: " + deque.peekLeft());
		
		deque.removeLeft();
		System.out.println("Peek left: " + deque.peekLeft());
		
		deque.removeRight();
		deque.removeRight();
		deque.insertRight(125);
		deque.display();
	}
}

