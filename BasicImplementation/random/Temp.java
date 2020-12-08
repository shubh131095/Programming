package BasicImplementation.random;

import java.util.Arrays;

public class Temp
{
  public static void main( String[] args )
  {
    int a[] = {1,1,1,1};
    int match = a[0];

    System.out.println(Arrays.stream( a ).allMatch( i -> i == match ));
  }
}

