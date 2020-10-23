package thread;

public class ThreadsImpl extends Thread
{
  int a;
  int b;

  public void run()
  {
    for( int i = 0; i < 5; i++ )
    {
      System.out.println( a + " " + b + " by thread " + Thread.currentThread().getName() );
      a++;
      b++;
    }
  }
}
