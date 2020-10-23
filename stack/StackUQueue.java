package stack;

import java.util.LinkedList;
import java.util.Queue;

// implementing stack using queue
// giving priority to access and popping i.e pop and access will take O(1) and push will take O(n).
//null checks not add in peek and poll
// size of stack is also not added.
 class MyQueueStack<T>
{
  Queue<T> q1 ;
  Queue<T> q2 ;
  MyQueueStack()
  {
    q1 = new LinkedList<T>();
    q2 = new LinkedList<T>();
  }
  public T popStack(){
    if(q1.isEmpty())
    {
      return q2.poll();
    }
    else
    {
      return q1.poll();
    }
  }
  public void pushStack(T element)
  {
    if(q1.isEmpty())
    {
      q1.offer( element );
      while( !q2.isEmpty() )
      {
        q1.offer( q2.poll() );
      }
    }
      else
    {
      q2.offer( element );
      while( !q1.isEmpty() )
      {
        q2.offer( q1.poll() );
      }
    }
  }
  public T peekStack()
  {
    if(q1.isEmpty())
    {
      return q2.peek();
    }
    else
    {
      return q1.peek();
    }
  }
  public boolean isEmptyStack()
  {
    if ( q1.isEmpty() && q2.isEmpty()) return true;
    else return false;
  }
}
public class StackUQueue
{
  public static void main( String[] args )
  {
   MyQueueStack<Integer> mqs = new MyQueueStack<>();
   mqs.pushStack( 1 );
    mqs.pushStack( 2 );
    mqs.pushStack( 3 );
    mqs.pushStack( 4);
    mqs.pushStack( 5);
    while( !mqs.isEmptyStack() )
    {
      System.out.println(mqs.peekStack() + " " + mqs.popStack());
    }
  }
}
