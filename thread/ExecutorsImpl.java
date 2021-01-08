package thread;
// this is a new away of iplementing threads.


import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsImpl
{
  public static void main( String[] args )
  {
    ExecutorService exe = Executors.newSingleThreadExecutor();

    List<Future<String>> fut = List.of(exe.submit( () ->
    {
      while( true )
      {
        System.out.println("hello bello");
        if (Thread.currentThread().isInterrupted()) {
          System.out.println("interrupted");
          break;
        }
      }
      return "bye";
    } ) , exe.submit( () ->
    {
      while( true )
      {
        System.out.println("hello bello");
        if (Thread.currentThread().isInterrupted()) {
          System.out.println("interrupted");
          break;
        }
      }
      return "hello";
    } ));


    for(Future<String> futre : fut)
    {
    }
    exe.shutdown(); // with this it will never stop
    exe.shutdownNow(); // with this it will only stop if you use the if condtion or handle the interuption.
  }
}
