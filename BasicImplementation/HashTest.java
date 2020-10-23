package BasicImplementation;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class HashTest
{
  public static void main( String[] args )
  {
    HashMap h1 = new HashMap();
    Hashtable h2 = new Hashtable();
    ConcurrentHashMap h3 = new ConcurrentHashMap();
    h1.put( 1,1 );
    h2.put( 1,1 );
    h3.put( 1,1 );

    h1.put( null,1 );
  /*  h2.put( null,1 );*/
    /*h3.put( null,1 );*/
    h1.put( 1,null );
    /*h2.put( 1,null );*/
   /* h3.put( 1,null );*/
    h1.put( null,null );
  /*  h2.put( null,null  );
    h3.put(null,null  );*/
    h1.put( 2,null );
  /*  h2.put( 2,null );
    h3.put( 2,null );*/
    h1.put( null,2 );
    h2.put( 1,2 );
    h3.put( 1,2 );
   /* h2.put( null,2 );

    h3.put( null,2 );*/
    System.out.println(h1);
    System.out.println(h2);
    System.out.println(h3);

  }
}
