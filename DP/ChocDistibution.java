// wromg soluntion and incomplete
package DP;
import java.util.Arrays;

public class ChocDistibution
{
  public static void main( String[] args )
  {
    int a[] = {10, 7, 12};
    int ans = getWays( a, a.length );
    System.out.println(ans);
  }

  private static int getWays( int[] a, int length )
  {
    if( checkEqual( a ) ) return 1;
    int min = Integer.MAX_VALUE;
    for(int i=0;i<a.length;i++)
    {
      updateArray(a,i,2,1);
      int by2 = getWays( a,length );
      updateArray(a,i,2,-1);
      updateArray(a,i,5,1);
      int by5 = getWays( a,length );
      updateArray(a,i,5,-1);
      updateArray(a,i,1,1);
      int by1 = getWays( a,length );
      updateArray(a,i,1,-1);
      min = Math.min(Math.min(by1,min),Math.min(by2,by5));
    }
    return min;
  }

  private static void updateArray( int[] a, int indexToIgnore, int number,int operation )
  {
    for(int i=0;i< a.length;i++)
    {
      if(i==indexToIgnore) continue;
      if(operation==-1)
      {
        a[i] = a[i] - number;
      }
      else
      {
        a[i] = a[i] + number;
      }
    }
  }

  private static boolean checkEqual( int[] a )
  {
    int match = a[0];
    return Arrays.stream( a ).allMatch( i -> i == match );
  }
}