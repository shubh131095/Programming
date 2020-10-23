package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CircularTour
{
  public static int tour(int petrol[], int distance[])
  {
    int ans = -1;
    Queue<Integer> q = new LinkedList<>();
   int min=Integer.MAX_VALUE;
   int index = 0;
   q.offer(petrol[0]-distance[0]);
   for(int i=1;i< petrol.length;i++)
   {
     int cur_value = petrol[i]-distance[i];
     int last_value = q.peek();
     q.offer( cur_value + last_value );
   }
    return ans;
  }
  public static void main( String[] args )
  {

    int[] petrol = {4,6,7,4};
    int[] distance = {6,7,3,5};
    int ans = tour(petrol,distance);
    System.out.println(ans);

  }
}
