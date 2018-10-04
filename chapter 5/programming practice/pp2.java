public class pp2 {

  private class Link {
    public long dData;
    public Link next;
    public Link previous;

    public Link(long var1) {
      this.dData = var1;
    }

    public void displayLink() {
      System.out.print(this.dData + " ");
    }
  }

  private class DoublyLinkedList {
    private Link first = null;
    private Link last = null;

    public DoublyLinkedList() {
    }

    public boolean isEmpty() {
      return this.first == null;
    }

    public void insertFirst(long var1) {
      Link var3 = new Link(var1);
      if(this.isEmpty()) {
        this.last = var3;
      } else {
        this.first.previous = var3;
      }

      var3.next = this.first;
      this.first = var3;
    }

    public void insertLast(long var1) {
      Link var3 = new Link(var1);
      if(this.isEmpty()) {
        this.first = var3;
      } else {
        this.last.next = var3;
        var3.previous = this.last;
      }

      this.last = var3;
    }

    public Link deleteFirst() {
      Link var1 = this.first;
      if(this.first.next == null) {
        this.last = null;
      } else {
        this.first.next.previous = null;
      }

      this.first = this.first.next;
      return var1;
    }

    public Link deleteLast() {
      Link var1 = this.last;
      if(this.first.next == null) {
        this.first = null;
      } else {
        this.last.previous.next = null;
      }

      this.last = this.last.previous;
      return var1;
    }

    public boolean insertAfter(long var1, long var3) {
      Link var5 = this.first;

      while(var5.dData != var1) {
        var5 = var5.next;
        if(var5 == null) {
          return false;
        }
      }

      Link var6 = new Link(var3);
      if(var5 == this.last) {
        var6.next = null;
        this.last = var6;
      } else {
        var6.next = var5.next;
        var5.next.previous = var6;
      }

      var6.previous = var5;
      var5.next = var6;
      return true;
    }

    public Link deleteKey(long var1) {
      Link var3 = this.first;

      while(var3.dData != var1) {
        var3 = var3.next;
        if(var3 == null) {
          return null;
        }
      }

      if(var3 == this.first) {
        this.first = var3.next;
      } else {
        var3.previous.next = var3.next;
      }

      if(var3 == this.last) {
        this.last = var3.previous;
      } else {
        var3.next.previous = var3.previous;
      }

      return var3;
    }

    public void displayForward() {
      System.out.print("List (first-->last): ");

      for(Link var1 = this.first; var1 != null; var1 = var1.next) {
        var1.displayLink();
      }

      System.out.println("");
    }

    public void displayBackward() {
      System.out.print("List (last-->first): ");

      for(Link var1 = this.last; var1 != null; var1 = var1.previous) {
        var1.displayLink();
      }

      System.out.println("");
    }
  }

  private class Deque {

    private DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

   
    public void insertLeft(long j) {
      doublyLinkedList.insertFirst(j);
    }

    public void insertRight(long j) {
      doublyLinkedList.insertLast(j);
    }

    public long removeLeft() {
      return doublyLinkedList.deleteFirst().dData;
    }

    public long removeRight() {
      return doublyLinkedList.deleteLast().dData;
    }

    public boolean isEmpty() {
      return doublyLinkedList.isEmpty();
    }

    public void display() {
      String s = "Queue contents (left --> right): ";
      if (!isEmpty()) {
        doublyLinkedList.displayForward();
      }
    }

  }

  public static void main(String[] args) {
    pp2 app = new pp2();
    Deque dq = app.new Deque();
    dq.insertLeft(11);
    dq.insertRight(22);
    dq.insertLeft(33);
    dq.display();
  }
}
