package BasicImplementation.lambda.expression;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.io.StringBufferInputStream;

public class Closure
{
  public static void processAll(int a, process p)
  {
    p.show(a);
  }
  public static void main( String[] args )
  {
    int a=10;
    int b=20;
    // b=b+a; error b should be final / if not final should no be changes (effictvely final) as its being used in lambda expression.
    processAll(a,i-> System.out.println(i+b));

  }
}
interface process
{
  void show(int i);
}
