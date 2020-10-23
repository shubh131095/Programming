package thread;

public class ThreadUsingLambda
{
  public static void main( String[] args ) throws Exception
  {
    Thread t1 = new Thread("1st thread"){
      public void run()
      {
        System.out.println("hello from thread:-" + Thread.currentThread().getName());
      }
    };
    Thread t2 = new Thread("2nd thread"){
      public void run()
      {
        System.out.println("hello from thread:-" + Thread.currentThread().getName());
      }
    };

    Runnable r2 =  () ->
    {
      System.out.println("hello from runnable:-" + Thread.currentThread().getName());
    };

    Thread rt1 = new Thread(() ->
      System.out.println("hello from runnable:-" + Thread.currentThread().getName()),"3rd thread"
    );
    Thread rt2 = new Thread(r2,"4th thread");

    t1.setPriority( 4 );
    t2.setPriority( 6 );
    rt1.setPriority( 1 );
    rt2.setPriority( 5 );
    t1.start();
    t2.start();
    rt1.start();
    rt2.start();
    t1.join();
    t2.join();
    rt1.join();
    rt2.join();
    System.out.println("im main");
  }
}
