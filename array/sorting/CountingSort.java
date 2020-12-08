package array.sorting;

import java.util.Arrays;
import java.util.OptionalInt;

// its the only non-comparison sort.
// here array is sorted by keeping the track of all the no's in  temp array.
// the compexity is -> O(n+k) where k is the range of number in original array.
// space complexity is quite large -> O(n+k)
public class CountingSort
{
  public static void main( String[] args )
  {
    int[] ip_array = {2,0,3,1,2,4,0,0,1,1,3,2,5};
    int[] op_array = new int[ip_array.length];
    int greatest = Arrays.stream( ip_array).reduce( 0,(a,b) -> Math.max( a,b ) );
    int[] temp_array = new int[greatest+1];
    doCountingSort(ip_array,op_array,temp_array);
    Arrays.stream( op_array ).forEach( i-> System.out.print(i + " ") );
}

  private static void doCountingSort( int[] ip_array, int[] op_array, int[] temp_array )
  {
    // counting all the number occurence in original araay and keeping the count in respective index in temp array
    for(int i=0;i<ip_array.length;i++)
    {
      temp_array[ip_array[i]] += 1;
    }
    // cummalting all the sum,now every index will let u know how many no greater than this index is present.
    for(int i=1;i<temp_array.length;i++)
    {
      temp_array[i] += temp_array[i-1];
    }

    //actual sorting i.e taversing original aaaray and stroing value in o/p array
    for(int i=ip_array.length-1;i>=0;i--)
    {
      // putting the number in respective index
      op_array[temp_array[ip_array[i]]-1] = ip_array[i];
      temp_array[ip_array[i]] -= 1;
    }
  }
  }
