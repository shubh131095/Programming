package BasicImplementation.random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class twts
{
  public static int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparing(( int[] itv) -> itv[0]));

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int count = 0;
    for (int[] itv : intervals) {
      if (heap.isEmpty()) {
        count++;
        heap.offer(itv[1]);
      } else {
        if (itv[0] >= heap.peek()) {
          heap.poll();
        } else {
          count++;
        }

        heap.offer(itv[1]);
      }
    }

    return count;
  }
  public static void main( String[] args )
  {
      int arr[][] = {
        {2,15},{36,45},{9,29},{16,23},{4,9}
      };
    System.out.println(minMeetingRooms( arr ));
  }
}
