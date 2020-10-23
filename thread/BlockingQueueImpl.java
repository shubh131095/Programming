package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
class Resource
{
  BlockingQueue<Integer> bq;

  public Resource()
  {
    this.bq = new ArrayBlockingQueue<>( 10 );
  }
  public void putResource(int a) throws InterruptedException
  {
    System.out.println("adding " + a + "  by " + Thread.currentThread().getName());
    bq.put( a );
  }
  public void getResource() throws InterruptedException
  {
    int a = bq.take();
    System.out.println("getting " + a + "  by " + Thread.currentThread().getName());
  }
}
class Produce implements Runnable
{
  Resource r;

  public Produce(Resource r)
  {
    this.r = r;
    Thread t1 = new Thread(this,"Producer");
    t1.start();
  }
  @Override
  public void run()
  {
    for(int i=1;i>0;i++)
    {
      try
      {
        r.putResource( i );
        Thread.sleep( 1000 );
      }
      catch( InterruptedException e_ )
      {
        e_.printStackTrace();
      }
    }
  }
}
class Consume implements Runnable
{
  Resource r;

  public Consume(Resource r)
  {
    this.r = r;
    Thread t1 = new Thread(this,"Consumer");
    t1.start();
  }
  @Override
  public void run()
  {
    for(int i=1;i>0;i++)
    {
      try
      {
        r.getResource();
        Thread.sleep( 1000 );
      }
      catch( InterruptedException e_ )
      {
      }
    }
  }

}
public class BlockingQueueImpl
{
  public static void main( String[] args )
  {
    Resource r = new Resource();
    new Produce( r );
    new Consume( r );
  }
}
