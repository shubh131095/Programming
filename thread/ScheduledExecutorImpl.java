package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorImpl
{
  public static void main( String[] args )
  {
    ScheduledExecutorService sexe= Executors.newScheduledThreadPool(1);
    Runnable r = () -> {
      for(int i=0;i<5;i++)
      System.out.println("new task scheduled: " + i + " : " + System.nanoTime() + " : "+ Thread.currentThread().getName());
    };
    // sexe.schedule( r,2, TimeUnit.SECONDS ); // secduling for intial delay of 2 sec. new task will scheduled after 2 sec

    // secduling a new task after every 2 sec with intial delay of 2nd, 1st parameter is intial delay 2nd is period.
    // period time doesnt depend on task execution, so every new task will start after period time
    sexe.scheduleAtFixedRate( r,2000,2,TimeUnit.MILLISECONDS );

    // it behave same as fixedrate only diffrence it wait for period amount of time after the prev task has been completed.
    // you can use this if you dont know the execution time of task
    sexe.scheduleWithFixedDelay( r,0,1,TimeUnit.SECONDS );
  }
}
