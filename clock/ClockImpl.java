package clock;

import java.time.Clock;
import java.time.ZoneId;

public class ClockImpl
{
  public static void main( String[] args )
  {
    Clock c = Clock.systemUTC();


    Clock c1 = Clock.systemDefaultZone();

    System.out.println("systemDefaultZone :- " + c1.millis());
    System.out.println("systemUTC:- " + c.millis());

    ZoneId z = ZoneId.systemDefault();
  }
}
