package BasicImplementation.random;

// you have given an array with diff number.
// return the count of bit which lies in most of given number.(0-31)
// for example
// A -> [1,2,3,4];
// for 1 -> 1st posiiton bit is set
// for 2 -> 2 posiiton bit is set
// for 3 -> 1 and 2 positiion bit is set like wise

// current implementation is incorrect
public class BitCount
{
  public static void main( String[] args )
  {

    int a[] = {7,15,31,63,2,6};
    System.out.println( findBitCount( a, a.length ));
  }

  private static int findBitCount( int[] a, int length )
  {
    int odd_count=0;
    int even_count=0;
    int[] power = new int[32];
    for(int i=0;i<length;i++)
    {
      int ans = isPower(a[i]);
      if( ans!=0)
      {
        power[ans] = power[ans]+1;
      }
      else
      {

        if( a[i] % 2 == 0 )
        {

          if( ans == 0 )
          {
            even_count++;
          }
          else
          {
            power[ans] = power[ans] + 1;
          }
        }
        else
        {
          odd_count++;
        }
      }
    }
    int max =0;
    for(int i=0;i<power.length;i++)
    {
      max = Math.max( max,power[i] );
    }
    return Math.max( odd_count,Math.max( max,even_count ) );
  }

  private static int isPower( int i )
  {
    if(i==0) return 0;
    int count = 0;
    while(i!=1)
    {
      if(i%2==0)
      {
        i = i/2;
        count++;
      }
      else
        {
        return 0;
      }
    }
    return count;
  }
}
