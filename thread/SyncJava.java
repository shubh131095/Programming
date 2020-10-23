package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class Sample
{
  int a;
  synchronized void inc(int i)
  {
    a = a+i;
  }
  //or
  void inc1()
  {
    synchronized(this)
    {a = a+1;}
  }
}
public class SyncJava
{
  public static void stop(ExecutorService exe)
  {
    try
    {
      exe.shutdown();
      exe.awaitTermination( 20, TimeUnit.SECONDS );
    }
    catch(InterruptedException e  )
    {
      System.out.println("Termination iteerupted");
    }
    finally
    {

        if( !exe.isTerminated() )
        {
          System.out.println( " stopping Forcefully and ending all leftover task" );
        }
        exe.shutdownNow();
    }
  }
  public static void main( String[] args )
  {
    Sample s = new Sample();
    ExecutorService exe = Executors.newFixedThreadPool(3);
    IntStream.range( 0,1000 ).forEach( i -> exe.submit( ()-> s.inc( i )));//1
    IntStream.range( 0,1000 ).forEach( i -> exe.submit(s::inc1 )); //2
      stop( exe );
    System.out.println("final value of a:- " + s.a);

  }
}
