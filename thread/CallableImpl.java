package thread;
// here we see cllable and future use.
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableImpl
{
  public static void main( String[] args ) throws ExecutionException, InterruptedException, TimeoutException
  {
    ExecutorService exe = Executors.newFixedThreadPool(1); // creating a thread pool of 1 thread;
    Callable<Integer> c = () ->
      {
        int i=0;
        for(;i<5;i++)
        {
          System.out.println("inside callable " + i + Thread.currentThread().getName());
        }
        return i;
      }; // calllable is a interface and we are giving anonymous defination to call method(return object)
    exe.submit( c ); // the callable can be declared here also.
    Future<Integer> fut = exe.submit(c);
   System.out.println("future done?  :- " + fut.isDone());

   try
   {
     // / it blocks the current thread until we get value from future. cannot be interrupted in between. if we dont get values in given timeout exception will come.
     Integer value = fut.get( 10, TimeUnit.MICROSECONDS );
     System.out.println("future done?  :- " + fut.isDone());
     System.out.println("future here:- " + value);
   }
   catch( Exception e_ )
   {
     System.out.println("oopss");
   }

  }
}
