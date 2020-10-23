package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class myLock
{
  Semaphore s = new Semaphore( 5 );
  boolean permit = false;
  public void tryRun()
  {
    try
    {
      permit = s.tryAcquire(1, TimeUnit.SECONDS);
      if(permit)
      {
        System.out.println("Locked acquired by: -" + Thread.currentThread().getName());
      }
      else {
        System.out.println("cannot acquir lock by: -" + Thread.currentThread().getName());
        Thread.sleep( 3000 );  // or  TimeUnit.SECONDS.sleep( 2 );
        tryRun();
      }
    }
    catch( InterruptedException e_ ){}
    finally
    {
      if( permit )
      {
        s.release();
        System.out.println( "Lock released by :- " + Thread.currentThread().getName() );
      }
    }
  }
}
public class SempahoresImpl
{
  public static void main( String[] args )
  {
    myLock m1 = new myLock();
    ExecutorService exe = Executors.newFixedThreadPool(10);
    IntStream.range( 0,10 ).forEach( i -> exe.submit( m1::tryRun ));
  }
}
