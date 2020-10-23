package thread;
// this is a new away of iplementing threads.


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsImpl
{
  public static void main( String[] args )
  {
    ExecutorService exe = Executors.newSingleThreadExecutor();

    exe.submit( () ->
    {
      while( true )
      {
        System.out.println("hello bello");
        if (Thread.currentThread().isInterrupted()) {
          System.out.println("interrupted");
          break;
        }
      }
    } );

    exe.shutdown(); // with this it will never stop
    exe.shutdownNow(); // with this it will only stop if you use the if condtion or handle the interuption.
  }
}
