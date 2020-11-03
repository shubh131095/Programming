package array;
// in this que you will be given a array of size N, you ave to tell the no of iteration it is needed to make all the element same(value)
// you have to increase n-1 element in a iteration and you can increment only by one. If all elements are same return 0;
// example : - 55688
//   1-> 66789 , 2-> 77889 , 3-> 88999 , 4-> 999 10 10 and so on.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxArray
{
  public static int countTimes1( List<Integer> numbers) {
    if (numbers == null || numbers.size() == 0) return 0;

    Collections.sort(numbers);
    int count = 1;

    while (true) {
      Collections.sort(numbers);
      int prev = numbers.get( 0 );
      int matches = 1;
      for (int i = 1; i < numbers.size(); i++) {
        if (prev == numbers.get( i )) matches++;
        else break;
      }
      if (matches == numbers.size()- 1) break;
      else {
        for (int i = 0; i < numbers.size() - 1; i++) {
          numbers.set( i, numbers.get( i ) + 1 );
        }
      }
      count++;
    }

    return count;
  }
  public static long countMoves( List<Integer> numbers)
  {
    int max = numbers.get(0);
    int updated_index=-1;
    int index=-1;
    long ans=0;
    boolean flag=false;
    boolean ini_flag=false;
    // if all elements are same
    for(int i=0,j=1;j<numbers.size();i++,j++)
    {
      if(numbers.get(i) != numbers.get(j))
      {
        ini_flag=true;
      }
      if( numbers.get(j) > max)
      {
        max = numbers.get(j);
        updated_index =j;
      }
    }
    if(!ini_flag) return 0;
    while(true)
    { index =updated_index;
    flag=false;
      for( int j = 0; j < numbers.size(); j++ )
      {
        if( j != index )
        {
          int current = numbers.get( j ) + 1;
          numbers.set( j, current );

          if( current > max )
          {
            max = current;
            updated_index = j;
          }
        }
        if(j!=0 && !flag)
        {
          if(numbers.get(j)!=numbers.get( j-1 )) flag=true;
        }
      }
      ans++;
      if(flag==false) break;
    }
    return ans;
  }
  public static void main( String[] args )
  {

    List<Integer> is = new ArrayList<>();
    is.add(1);
    is.add(1);
    is.add(1);
    is.add(1);
    is.add(1);
    long ans = countTimes1( is );
    System.out.println(ans);
  }
}
