package BasicImplementation.random;

import java.util.Arrays;

public class Temp
{
  public static void main( String[] args )
  {
    int a[] = {1,1,1,1};
    int match = a[0];
    char[] arr = {'a','b','c'};
    String b = new String();
 /*   System.out.println(b);
    {
      b = b+"bye";
      System.out.println(b);
    }
    System.out.println(b);*/
    for(int i=0;i<3;i++)
    {
      b += arr[i]+"";
    }
    System.out.println(b);
    //System.out.println(Arrays.stream( a ).allMatch( i -> i == match ));



  }
}

