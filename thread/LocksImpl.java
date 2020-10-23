package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

// if you dont want to use syncronised and want to implement locking by urself, you can achieve that by locks.
class Locks
{
  int a;
  ReentrantLock lock = new ReentrantLock();
  void inc()
  {
    try
    {
      System.out.println("locking by :-" + Thread.currentThread().getName());
      lock.lock();//1
      //lock.tryLock();//2
      a++;
    }
    finally
    {
      System.out.println("unLocking by :-" + Thread.currentThread().getName());
      lock.unlock();
    }
  }
}

public class LocksImpl
{
  public static void main( String[] args )
  {
   Locks l1 = new Locks();
    ExecutorService exe = Executors.newFixedThreadPool(3);
    IntStream.range( 0,3 ).forEach( i -> exe.submit(l1::inc )); //2
    SyncJava.stop( exe );
    System.out.println("final value of a:- " + l1.a);
  }
}
