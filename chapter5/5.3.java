class CLink
{
	public long lData;
	public CLink next;
public CLink(long value)
	{ 
lData = value; 
}
	
	public void displayLink()
	{ 
System.out.print(lData + " ");
 }
}

class CLinkedList
{
	private CLink current;
	private int nItems; 			//keeps track of length of the list
	
	public CLinkedList()
	{
		current = null;
		nItems = 0;
	}

	
	public boolean isEmpty() 
	{ 
return current==null; 
}
	
	public long getItems()
	{ 
return nItems;
 }
	
	public void step()
	{
		current = current.next;
	}
	
	public void insert(long value)	//inserts new link after current link
	{
		if(isEmpty())
		{
			current = new CLink(value);
			current.next = current;
	}
		else
		{
			CLink newLink = new CLink(value);
			newLink.next = current.next;
			current.next = newLink;
		}
		nItems++;
	}
	
	public CLink find(long value)
	{
		for(int i = 0; i < nItems; i++)
		{
			if(current.lData == value) 
			{
				System.out.println("Found " + value);
				return current;
			}
			else step();
		}
		System.out.println("Couldn't find " + value + ".");
		return null;
	}
	

	public CLink delete()
	{
		if(isEmpty())
		{
			System.out.println("List is empty.");
			return null;
		}
		else if(nItems == 1)
		{
			current = null;
			nItems = 0;
			return null;
		}
		else
		{
			CLink temp = current.next;
			current.next = current.next.next;
			nItems--;
			return temp;
		}
}
	
	public CLink peek()
	{
		return current;
	}
	


	public void display()
	{
		System.out.print("Circular List (from current): ");
		CLink index = current;
		for(int i = 0; i < nItems; i++)
		{
			System.out.print(index.lData + " ");
			index = index.next;
		}
		System.out.println("");
	}
}

class CircularApp
{
	public static void main(String[] args)
	{
		CLinkedList theList = new CLinkedList();
		
		theList.insert(1);
		theList.insert(2);
		theList.insert(3);
		theList.insert(4);
		theList.display();
		
		theList.delete();
		theList.display();
		theList.delete();
		theList.display();
		
	}
}
