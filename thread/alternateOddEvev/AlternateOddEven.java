package thread.alternateOddEvev;
// in this problem,you have to develop a program to print numbers upto N using 2 threads
// the number should be printed in seq from 1 to N.
class Main
{
  int a;
  int curr;
  boolean turn;
  Main(int a)
  {
    this.a =a;
    turn = true;
    curr =1;
  }
  public synchronized void getEven()
  {
    if(turn)
    {
     try
     {
       wait();
     }
     catch( Exception e )
     {
       System.out.println(e);
     }
    }
    System.out.println(curr + " ");
    curr++;
    turn = true;
    notify();
  }
  public synchronized void getOdd()
  {
    if(!turn)
    {
      try
      {
        wait();
      }
      catch( Exception e )
      {
        System.out.println(e);
      }
    }
    System.out.println(curr+ " ");
    curr++;
    turn = false;
    notify();
  }
}
class Even implements Runnable
{
  Main m;

  Even(Main m)
  {
    this.m = m;
    Thread t = new Thread(this,"even");
    t.start();
  }
  @Override
  public void run()
  {
    while(m.curr!=m.a)
    {
      m.getEven(  );
    }
  }
}
  class Odd implements Runnable
  {
    Main m;
    Odd(Main m)
    {
      this.m = m;
      Thread t = new Thread(this,"odd");
      t.start();
    }
    @Override
    public void run()
    {
      while(m.curr!=m.a)
      {
        m.getOdd(  );
      }
    }
}
public class AlternateOddEven
{
  public static void main( String[] args )
  {
    Main m = new Main( 10 );
     new Even( m );
     new Odd( m );

  }
}
