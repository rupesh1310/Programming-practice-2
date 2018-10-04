// Implement a priority queue based on a sorted linked list. The remove operation
// on the priority queue should remove the item with the smallest key.
public class pp1 {

  private class Link {
    public long dData;                  // data item
    public Link next;                   // next link in list

    public Link(long dd)                // constructor
    {
      dData = dd;
    }


    public void displayLink()           // display this link
    {
      System.out.print(dData + " ");
    }
  }  // end class Link


  private class SortedList {
    private Link first;                 // ref to first item


    public SortedList()                 // constructor
    {
      first = null;
    }


    public boolean isEmpty()            // true if no links
    {
      return (first == null);
    }


    public void insert(long key)        // insert, in order
    {
      Link newLink = new Link(key);    // make new link
      Link previous = null;            // start at first
      Link current = first;
      // until end of list,
      while (current != null && key > current.dData) {                             // or key > current,
        previous = current;
        current = current.next;       // go to next item
      }
      if (previous == null)               // at beginning of list
        first = newLink;              // first --> newLink
      else                             // not at beginning
        previous.next = newLink;      // old prev --> newLink
      newLink.next = current;          // newLink --> old currnt
    }  // end insert()


    public Link remove()           // return & delete first link
    {                           // (assumes non-empty list)
      Link temp = first;               // save first
      first = first.next;              // delete first
      return temp;                     // return value
    }


    public void displayList() {
      System.out.print("List (first-->last): ");
      Link current = first;       // start at beginning of list
      while (current != null)      // until end of list,
      {
        current.displayLink();   // print data
        current = current.next;  // move to next link
      }
      System.out.println("");
    }
  }  // end class SortedList

  private class PriorityQueue {
    private SortedList sortedList = new SortedList();

    public void insert(long item) {
      sortedList.insert(item);
    }

    public long remove() {
      return sortedList.remove().dData;
    }

  }


  public static void main (String[] args) {
    pp1 app  = new pp1();
    PriorityQueue pq = app.new PriorityQueue();
    pq.insert(22);
    pq.insert(11);
    System.out.println(pq.remove());
  }

}
