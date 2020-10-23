package BasicImplementation.lambda.expression;

public class LambdaExpression
{
  public static void main( String[] args )
  {
  Thread t1 = new Thread( ()-> System.out.println("here in runnable"));
  t1.run();
    System.out.println("main thread");
    Thread t2 = new Thread( ()-> System.out.println("here in t2 thread"));
    t2.run();
    System.out.println("main thread");
  }
}
