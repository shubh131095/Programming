package BasicImplementation;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class CollectionConversion
{
  public static void main( String[] args )
  {
    Stack s = new Stack();
    for(int i=0;i<10;i++)
    s.push( i );

    Queue q = new LinkedList(s);

    System.out.println(q);
    q.poll();
    System.out.println(q);
    Vector v = new Vector();
    Enumeration e = v.elements();

  }
}
