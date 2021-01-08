package BasicImplementation.random;

import java.util.Arrays;

public class ArrayTOString
{
  public static void main( String[] args )
  {
    int a[] = {1,2,3,4,5,6,78,9};
    System.out.println(Arrays.stream(a).mapToObj( i -> {
      if(i%2==0)
        return "e ";
      else
        return "o ";
    } ).reduce( "",(b,c) -> b+c ));
  }
}
