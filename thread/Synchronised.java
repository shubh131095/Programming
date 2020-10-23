package thread;


public class Synchronised
{
  volatile int counter;
  public  void incr()
  {
    counter++;
  }

  public static void main( String[] args )throws Exception
  {
    Synchronised s1 = new Synchronised();
    for(int i=0;i<1000;i++)
    {
      s1.incr();
    }
    System.out.println(s1.counter);

    Thread t1 = new Thread( () -> {
      for(int i=0;i<1000;i++)
      {s1.incr();}
    } );

    Thread t2 = new Thread( () -> {
      for(int i=0;i<1000;i++)
        s1.incr();
    } );

    t1.start();
    t2.start();

    t1.join();
    t2.join();
    System.out.println(s1.counter);
  }
}
