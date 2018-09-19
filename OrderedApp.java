class OrdArray
   {
   private long[] a;                 
   private int nElems;               

   public OrdArray(int max)          
      {
      a = new long[max];             // create array
      nElems = 0;
      }
   
   
    public OrdArray(OrdArray arr1, OrdArray arr2, int max) {
   	a = new long[max];
   	nElems = 0;
   	
   	int pos1=0, pos2=0;
   	while(pos1 < arr1.size() || pos2 < arr2.size()) {
   		if (pos1 >= arr1.size()) {
   			insert(arr2.getElem(pos2));
				pos2++;
   		}
   		else if (pos2 >= arr2.size()) {
   			insert(arr1.getElem(pos1));
				pos1++;
   		}
			else if (arr1.getElem(pos1) < arr2.getElem(pos2)) {
   			insert(arr1.getElem(pos1));
   			pos1++;
   		}
			else {
   			insert(arr2.getElem(pos2));
   			pos2++;
   		}
   	}
   }
   
   public long getElem(int pos) {
   	return a[pos]; 
   }
   
   public int size()
      { return nElems; }

   public int find(long searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

      while(true)
      {
      	curIn = (lowerBound + upperBound) / 2;
      	if(a[curIn]==searchKey)
      		return curIn;
      	else if(lowerBound > upperBound)
      		return nElems;
      	else
      	{
      		if(a[curIn] < searchKey)
      			lowerBound = curIn + 1;
      		else
      			upperBound = curIn - 1;
      	}
      }
}


public void insert(long value)
	{

			int j = 0;
	}
