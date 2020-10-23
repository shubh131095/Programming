package thread;

public class MyMain
{
  public static void main( String[] args )
  {
    ThreadsImpl t1 = new ThreadsImpl();
    ThreadsImpl t2 = new ThreadsImpl();
    ThreadsImpl t3 = new ThreadsImpl();
    System.out.println("caliing threads now");

    t1.start();
    t2.start();
    t3.start();


    System.out.println("main method doing its operation");
    for(int i=0;i<5;i++)
    {
      System.out.println("im main thread");
    }
  }
}
