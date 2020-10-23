package thread;
// proudcer will produce value and consumer will consume.
// main aim is producer should produce then consumer consume and so on.
// producer should not produce consecutively twice and same for consumer.
class A
{
  int counter;
  boolean flag = false;
  public synchronized void set(int counter)
  {
    if(flag){
      try { wait();} catch(Exception e) {}
    }
    System.out.println("Put :- " + counter + Thread.currentThread().getName());
    this.counter = counter;
    this.flag = true;
    notify();
  }

  public synchronized void get()
  {
    if(!flag)
    {
      try { wait();} catch(Exception e) {}
    }
    System.out.println("Get :- " + this.counter + Thread.currentThread().getName());
    this.flag = false;
    notify();
  }

}
class Producer implements Runnable
{
   A a;
   int i=0;
   public Producer(A a)
   {
     this.a = a;
    Thread t = new Thread(this,"Producer");
     t.start();
   }
  @Override
  public void run()
  {
    while(true)
    {
      a.set( i++ );
      try { Thread.sleep( 1000 );} catch(Exception e) {}
    }

  }
}
class Consumer implements Runnable
{
   A a;

  public Consumer(A a)
  {
    this.a = a;
    Thread t = new Thread(this,"Consumer");
    t.start();
  }
  @Override
  public void run()
  {
      while(true)
      {
        a.get();
        try { Thread.sleep( 1000 );} catch(Exception e) {}
      }
  }

}
public class WaitNotify
{
  public static void main( String[] args )
  {

    A a = new A();
    new Consumer( a );
    new Producer( a );
  }
}
