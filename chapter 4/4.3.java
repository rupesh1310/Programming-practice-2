class StackQ				
{
	private Deque stackQueue;
	

	public StackQ(int size) 
	{
		stackQueue = new Deque[size];
	}

	
	public void push(long j) 
	{
		stackQueue.insertRight(j);	
	}

	
	public long pop()
	{
		return stackQueue.removeRight();
	}
	

	public long peek()
	{
		return stackQueue.peekRight();
	}

	
	public Boolean isEmpty()
	{
		return stackQueue.isEmpty();
	}
	

	public Boolean isFull()
	{
		return stackQueue.isFull();
	}
	
}
