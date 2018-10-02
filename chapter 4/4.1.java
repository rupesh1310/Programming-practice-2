public void display()
	{
		if (rear >= front)
			for(int i=front; i<maxSize; i++)
			{
				System.out.print(queArray[i] + " ");
			}
		else 
			for(int i=front; i<maxSize; i++)
			{
				System.out.print(queArray[i] + " ");
			}
		
			for(int i=0; i<=rear; i++)
			{
				System.out.print(queArray[i] + " ");
			}
	}
