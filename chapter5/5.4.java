import java.util.EmptyStackException;

class CStack
{
	private CLinkedList theList;
	
	public CStack()
	{
		theList = new CLinkedList();
		theList.insert(-1);	//the first element is an anchor
					//not used in stack operations
	}
	
	public void push(long value)
	{
		theList.insert(value);
	}
	
	public long pop()
	{
		if(theList.getItems() == 1)
		{
			System.out.println("Stack is empty.");
			throw new EmptyStackException();
		}
		else
		{
			return theList.delete().lData;
		}
	}
	
	public long peek()
	{
		return theList.peek().lData;
	}
}

class CStackApp
{
	public static void main(String[] args)
{
		CStack theStack = new CStack();
		theStack.push(2);
		theStack.push(5);
		theStack.push(8);
		theStack.push(2);
		
		System.out.println(theStack.pop());
		System.out.println(theStack.pop());
		System.out.println(theStack.pop());
		System.out.println(theStack.pop());
		
	}
}


