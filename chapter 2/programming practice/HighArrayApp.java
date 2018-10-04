//1.To the HighArray class in the highArray.java program (Listing 2.3), add a
// method called getMax() that returns the value of the highest key in the array,
// or –1 if the array is empty. Add some code in main() to exercise this method.
// You can assume all the keys are positive numbers.

//2.Modify the method in Programming Project 2.1 so that the item with the
// highest key is not only returned by the method, but also removed from the
// array. Call the method removeMax()

//3.The removeMax() method in Programming Project 2.2 suggests a way to sort
// the contents of an array by key value. Implement a sorting scheme that does
// not require modifying the HighArray class, but only the code in main(). You’ll
// need a second array, which will end up inversely sorted. (This scheme is a
// rather crude variant of the selection sort in Chapter 3, “Simple Sorting.”)

//6.Write a noDups() method for the HighArray class of the highArray.java
// program (Listing 2.3). This method should remove all duplicates from the
// array. That is, if three items with the key 17 appear in the array, noDups()
// should remove two of them. Don’t worry about maintaining the order of the
// items. One approach is to first compare every item with all the other items and
// overwrite any duplicates with a null (or a distinctive value that isn’t used for
// real keys). Then remove all the nulls. Of course, the array size will be reduced.
class HighArray
   {
   private long[] a;                 
   private int nElems;               

   public HighArray(int max)         
   {
      a = new long[max];                 
      nElems = 0;                        
      }

   public long getMax() {
   	int j;
   	long max=-1;
   	if(nElems == 0) return max;
   	for(j=0; j<nElems; j++)
   		if(a[j] > max)
   			max = a[j];
   	return max;
   }
   
   public long removeMax() {
   	int j;
   	long max=-1;
   	if(nElems == 0) return max;
   	for(j=0; j<nElems; j++)
   		if(a[j] > max)
   			max = a[j];
   	delete(max);
   	return max;
   }
   
   public void noDups() {
   	int i, j;
   	for (i=0; i<nElems; i++) {
   		j=i+1;
   		while (j<nElems) {
   			if (a[j] == a[i]) {
   	         for(int k=j; k<nElems; k++) 
   	            if (k == a.length -1) a[k]=0; 
   	            else a[k] = a[k+1];
   	         nElems--;
   			}
   			else j++;
   		}
   	}
   }
   
   public boolean find(long searchKey)
      {                              
      int j;
      for(j=0; j<nElems; j++)           
         if(a[j] == searchKey)           
            break;                       
      if(j == nElems)                    
         return false;                   
      else
         return true;                    
      }  
  
     public void insert(long value)    
      {
      a[nElems] = value;             
      nElems++;                     
      }

   public boolean delete(long value)
      {
      int j;
      for(j=0; j<nElems; j++)        
         if( value == a[j] )
            break;
      if(j==nElems)                  
         return false;
      else                           
         {
         for(int k=j; k<nElems; k++) 
            a[k] = a[k+1];
         nElems--;                   
         return true;
         }
      }  

   public void display()             
      {
      for(int j=0; j<nElems; j++)       
         System.out.print(a[j] + " ");  
      System.out.println("");
      }
   }  

class HighArrayApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            
      HighArray arr;                
      arr = new HighArray(maxSize); 

      arr.insert(77);               
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();                
      int searchKey = 35;           
      if( arr.find(searchKey) )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.delete(00);               
      arr.delete(55);
      arr.delete(99);

      arr.display();                
      

      //2.1, 2.2
      System.out.println("Max: " + arr.getMax());
      System.out.println("Max to delete: " + arr.removeMax());
      arr.display();
      
      // 2.3 
      HighArray arr2 = new HighArray(maxSize);
      while (arr.getMax() != -1)
      	arr2.insert(arr.removeMax());
      arr2.display();
      
      //2.6
      HighArray arr3 = new HighArray(maxSize);
      arr3.insert(1); arr3.insert(1); arr3.insert(2); arr3.insert(3); arr3.insert(2);
      arr3.display();
      arr3.noDups();
      arr3.display();
      
      
      }
   }  
