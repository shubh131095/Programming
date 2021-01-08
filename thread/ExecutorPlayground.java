package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyTestRunnable implements Runnable
{
  static int a =10;
  public void run()
  {
    for(int i=1;i<10;i++)
    {
      System.out.println("incremneted a from " + a + " to:" + ++a + "by : " + Thread.currentThread().getName());
    }
  }
}

public class ExecutorPlayground
{
  public static void main( String[] args )
  {
    // 1st execice to show execute and submit
    /*ExecutorService exe = Executors.newFixedThreadPool( 2 );
    exe.submit( () ->
    {
      for( int i = 0; i < 10; i++ )
        System.out.println( "tthis is threads JOB1" + Thread.currentThread().getName() );
    });

    // both are same if u use runnable
    exe.execute( () ->
    {
      for( int i = 0; i < 10; i++ )
        System.out.println( "tthis is threads JOB2" + Thread.currentThread().getName() );
    });

    exe.shutdown();*/

    // 2nd

    ExecutorService exe = Executors.newFixedThreadPool( 4 );
    exe.submit( new MyTestRunnable() );
    exe.execute( new MyTestRunnable() );
  }

}
