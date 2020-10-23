package LinkedList;

public class LinkedListImpl<T>
{
  T value;
  LinkedListImpl next;
  LinkedListImpl prev;
  static LinkedListImpl startNode;
  LinkedListImpl()
  {
    this.value=(T)null;
    this.next=null;
    this.prev=null;
  }
  LinkedListImpl(int value)
  {
    this.value=(T)null;
    this.next=null;
    this.prev=null;
  }
  public void add(T data)
  {
    LinkedListImpl<T> newNode = new LinkedListImpl<>();
    newNode.value = data;
    if( startNode == null )
    {
      startNode = newNode;
    }
    else
    {
      LinkedListImpl l1 = startNode;
      while( l1.next != null )
      {
        l1 = l1.next;
      }
      l1.next = newNode;
      newNode.prev = l1;
    }
  }
    public void delete(T data)
    {
      LinkedListImpl t1 = startNode;
      while(t1.value != data)
      {
        t1=t1.next;
      }
      if(t1==null) {
        System.out.println("Element not found");
      }
      else
      {
        t1.prev.next=t1.next;
        t1.next.prev=t1.prev;
      }
      t1.next=null;
      t1.prev=null;
      t1.value=null;    }
  }
