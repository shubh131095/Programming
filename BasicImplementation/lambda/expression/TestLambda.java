package BasicImplementation.lambda.expression;

@FunctionalInterface
public interface TestLambda<T>
{
  public void display(T a,T b);

}

class A
{
  public static void hope(Integer a,Integer b, TestLambda<Integer> e)
  {
    e.display(a,b);
  }

  public static void main( String[] args )
  {
    TestLambda<Integer> t1 =
      ( a, b) ->  System.out.println( a+b );
    t1.display( 10,20 ); //

    TestLambda<String> t2 =
      ( a, b) ->  System.out.println( a+b );
    t2.display( "hello","world" );

    hope(12,14,t1);

  }


}