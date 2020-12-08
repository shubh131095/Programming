
package DP;

// A number is said to be ugly if its only divisor is 2,3 or 5.
// given a n, find the nth ugly number.
public class UglyNumber
{
  public static int getNthUglyNumber(int n)
  {
    int ans[]= new int[n];
    int nextMultipleOf2 = 2;
    int nextMultipleOf3 = 3;
    int nextMultipleOf5 = 5;
    int pointer2=0, pointer3 =0, pointer5 =0;
    ans[0]=1;
    for(int i=1;i<n;i++)
    {
      int nextUgly = Math.min(nextMultipleOf2,Math.min(nextMultipleOf3,nextMultipleOf5));
       ans[i] = nextUgly;

       if(nextUgly==nextMultipleOf2)
       {
         pointer2++;
         nextMultipleOf2 = ans[pointer2]*2;
       }
      if(nextUgly==nextMultipleOf3)
      {
        pointer3++;
        nextMultipleOf3 = ans[pointer3]*3;
      }
      if(nextUgly==nextMultipleOf5)
      {
        pointer5++;
        nextMultipleOf5 = ans[pointer5]*5;
      }
    }
    return ans[n-1];
  }

  public static void main( String[] args )
  {
    System.out.println(getNthUglyNumber( 150 ));
  }
}
