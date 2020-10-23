package BasicImplementation;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest
{
  public static void main( String[] args )
  {


    Queue que = new LinkedList();
    for(int i=0;i<10;i++)
    {
      que.offer( i );
      que.offer( "added" );
    }
    System.out.println(que);

    PriorityQueue que1 = new PriorityQueue();

  }
}
