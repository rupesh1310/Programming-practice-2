class CLink
{
	public int lData;
	public CLink next;
	
	public CLink(int value)
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
	
	public CLinkedList()
	{
		current = null;
	}
	
	public boolean isEmpty() 
{ 
return current==null; 
}

	
	public void insert(int value)
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
			current=newLink;
		}
	}

	public void Josephus(int person,int start, int diff)
	{
		for(int i=1;i<=person;i++)
		{
			insert(i);
		}
		
		CLink temp=current;
		for(int i=1;i<start;i++)
			temp=temp.next;
	
		do
		{
			for(int j=0;j<diff;j++)	
				temp=temp.next;
			System.out.println("Eliminated Numer :"+temp.next.lData);
			temp.next=temp.next.next;
			person--;
		}while(person>1);
	
		System.out.println("Alive Number:"+temp.lData);
	}
}

class CircularApp
{
	public static void main(String[] args)
	{
		CLinkedList theList = new CLinkedList();
		
		theList.Josephus(7,1,3);
		
	}
}

