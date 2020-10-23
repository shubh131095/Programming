package BasicImplementation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodRefernce
{
  public static void first(int a)
  {
    System.out.println("first");
    System.out.println(a*2);
  }
  private static void second(int a)
  {
    System.out.println("second");
    System.out.println(a*4);
  }
  private static void third( int a, Object b)
  {
    System.out.println("third");
    System.out.println(a*(int)b);
  }
  public static void main( String[] args )
  {
    List<Integer> list = Arrays.asList( 1,2,3,4,5,6 );

    list.forEach(MethodRefernce::first); //1
    list.forEach(MethodRefernce::second);

    Consumer c = new Consumer()
    {
      @Override
      public void accept( Object o_ )
      {
        System.out.println("consumer inner class" + 2*(int)o_);
      }
    };
    list.forEach( c ); //4

    Consumer c2 = System.out::println;
    list.forEach( c2 ); //5
    //list.forEach((i,j)->third( i,(Object)j); error
  }

}
