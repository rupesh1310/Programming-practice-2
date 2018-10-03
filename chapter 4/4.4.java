public void insert(long item) // insert item
	{
		if(isFull())
		{
		System.out.println("The Priority Que is Full");
			return;
		}	
		else 
		{
			queArray[nItems++]=item;
			return;
		}
	}
	
	//------------------------------------------------------

	public long remove() // remove minimum item
	{ 
		int min = 0;
		for (int i=0; i<nItems; i++)
		{
			if(queArray[i] < queArray[min])
				min = i;
		}
		long temp = queArray[min];
		
		for(int j=min; j<nItems-1; j++)
		{
			queArray[j] = queArray[j+1];
		}
		nItems--;			
		return temp; 
	}	
