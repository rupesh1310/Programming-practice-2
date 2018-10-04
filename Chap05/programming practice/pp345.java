//3.A circular list is a linked list in which the last link points back to the first link.
// There are many ways to design a circular list. Sometimes there is a pointer to
// the “start” of the list. However, this makes the list less like a real circle and
// more like an ordinary list that has its end attached to its beginning. Make a
// class for a singly linked circular list that has no end and no beginning. The
// only access to the list is a single reference, current, that can point to any link
// on the list. This reference can move around the list as needed. (See
// Programming Project 5.5 for a situation in which such a circular list is ideally
// suited.) Your list should handle insertion, searching, and deletion. You may
// find it convenient if these operations take place one link downstream of the
// link pointed to by current. (Because the upstream link is singly linked, you
// can’t get at it without going all the way around the circle.) You should also be
// able to display the list (although you’ll need to break the circle at some arbitrary
// point to print it on the screen). A step() method that moves current
// along to the next link might come in handy too.


//4.Implement a stack class based on the circular list of Programming Project 5.3.
// This exercise is not too difficult. (However, implementing a queue can be
// harder, unless you make the circular list doubly linked.)



//5.The Josephus Problem is a famous mathematical puzzle that goes back to
// ancient times. There are many stories to go with the puzzle. One is that
// Josephus was one of a group of Jews who were about to be captured by the
// Romans. Rather than be enslaved, they chose to commit suicide. They arranged
// themselves in a circle and, starting at a certain person, started counting off
// around the circle. Every nth person had to leave the circle and commit suicide.
// Josephus decided he didn’t want to die, so he arranged the rules so he would
// be the last person left. If there were (say) 20 people, and he was the seventh
// person from the start of the circle, what number should he tell them to use for
// counting off? The problem is made much more complicated because the circle
// shrinks as the counting continues.
// Create an application that uses a circular linked list (like that in Programming
// Project 5.3) to model this problem. Inputs are the number of people in the
// circle, the number used for counting off, and the number of the person where
// counting starts (usually 1). The output is the list of persons being eliminated.
// When a person drops out of the circle, counting starts again from the person
// who was on his left (assuming you go around clockwise). Here’s an example.
// There are seven people numbered 1 through 7, and you start at 1 and count off
// by threes. People will be eliminated in the order 4, 1, 6, 5, 7, 3. Number 2 will
// be left.
public class pp345 {

  private class Link {
    public int iData;              // data item (key)
    public double dData;           // data item
    public Link next;              // next link in list

    public Link(int id, double dd) // constructor
    {
      iData = id;
      dData = dd;
    }

    public void displayLink()      // display ourself
    {
      System.out.print("{" + iData + ", " + dData + "} ");
    }
  }  // end class Link

  private class CircularList {

    private Link current;

    public void insert(int iData, double dData) {
      Link newLink = new Link(iData, dData);
      if (current == null) {
        current = newLink;
        current.next = current;
      } else {
        newLink.next = current.next;
        current.next = newLink;
        current=newLink;
        System.out.println("Josh");
      }
    }

    public Link find(int key) {
      if (current.iData == key) {
        return current;
      } else {
        int firstKey = current.iData;
        current = current.next;
        while (current.iData != key) {
          if (current.iData == firstKey) {
            return null;
          } else {
            current = current.next;
          }
        }
        return current;
      }
    }

    public Link delete() {
      return delete(current.iData);
    }

    public Link delete(int key) {
      Link deleteLink;
      if (find(key) == null) {
        return null;
      }
      while (current.next.iData != key) {
        step();
      }
      deleteLink = current.next;
      if (current == current.next) {
        current = null;
      } else {
        current.next = current.next.next;
      }
      return deleteLink;
    }

    public void step() {
      if (!isEmpty()) {
        current = current.next;
      }
    }

    public boolean isEmpty() {
      return current == null;
    }

    public void display() {
      int firstKey =  current.iData;
      System.out.printf("Circular list: " + current.dData);
      step();
      while (current.iData != firstKey) {
        System.out.printf(", " + current.dData);
        step();
      }
      System.out.println();
    }
  }

  private class Stack {

    private CircularList circularList = new CircularList();

    public void push(int i, double d) {
      circularList.insert(i,d);
    }

    public Link pop() {
      return circularList.delete();
    }

    public void display() {
      circularList.display();
    }

  }

  public static void main(String[] args) {
    pp345 app = new pp345();
    CircularList cl = app.new CircularList();
    cl.insert(1, 11.0);
    cl.insert(2, 22.0);
    cl.insert(3, 33.0);
    cl.insert(4, 44.0);
    cl.display();
    cl.delete(2);
    cl.display();

    Stack stack = app.new Stack();
    stack.push(1, 11.0);
    stack.push(2, 22.0);
    stack.push(3, 33.0);
    System.out.println("Top of stack: " + stack.pop().dData);
    System.out.println("Top of stack: " + stack.pop().dData);


    final int PEOPLE = 7;
    final int COUNT = 3;
    final int FIRST = 1;

    cl = app.new CircularList();
    for (int i = 1; i <= PEOPLE ; i++) {
      cl.insert(i, (double)i);
    }

    cl.find(FIRST);

    while (!cl.isEmpty()) {
      cl.display();
      for (int i = 1; i <= COUNT; i++) {
        cl.step();
      }
      cl.delete();
      cl.step();
    }




  }

}
