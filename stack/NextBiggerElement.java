package stack;

import java.util.Scanner;
import java.util.Stack;

public class NextBiggerElement
{
  public static void main( String[] args )
  {
    Scanner sc = new Scanner(System.in);
    long tc = sc.nextLong();
    while(tc-- >0)
    {
      int size = sc.nextInt();
      long arr[] = new long[size];
      int k = size - 1;
      Stack<Long> s1 = new Stack<>();
      for( int i = 0; i < size; i++ )
      {
        arr[i]= sc.nextLong() ;
      }
      s1.push(arr[k]);
      arr[k]=-1;

      for(int j=k-1;j>=0;)
      {

        long curr=arr[j];
        if( !s1.isEmpty())
        {
          long prev = s1.peek();
          if(curr<prev)
          {
            arr[j] = prev;
            s1.push( curr );
            j--;
          }
          else
          {
            s1.pop();
            continue;
          }
        }
        else
        {
          arr[j]=-1;
          s1.push( curr );
          j--;
        }
      }
      for(long a:arr)
      { System.out.print(a + " ");}
      System.out.println();
    }
  }
}
