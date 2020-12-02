package BasicImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Random
{
  public static void main( String[] args )
  {
   /* int[] a = new int[5];
    System.out.println(a[0]);
    changeIt(a);
    System.out.println(a[0]);*/
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<Integer> temp = new ArrayList<>();
    temp.add( 1 );
    temp.add(2);
    temp.add( 3);
    temp.add(4);
    map.put(1,temp);
    map.put(2,temp);
    map.put(3,temp);
    map.put(4,temp);
    int sum = map.values().stream().map( i -> i.size() ).reduce( 0,(a,b) -> a+b);
    int sum1 = map.values().stream().mapToInt( i -> i.size() ).sum();
    int sum3 = map.values().stream().mapToInt( Random::listSum).sum();
    System.out.println(sum);
    System.out.println(sum1);
    System.out.println(sum3);
  }
private static int listSum(List<Integer> list)
{
  return list.stream().reduce( 0,(a,b) -> a+b );
}
  private static void changeIt( int[] a_ )
  {
   /* int [] arr = new int[a_.length];
    arr[0]=1;*/
  }
}
