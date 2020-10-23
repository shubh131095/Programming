package BasicImplementation.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableComparator
{
  public static void main( String[] args )
  {
    MovieDao m1 = new MovieDao( 2000, 8, "Momento" );
    MovieDao m2 = new MovieDao( 1999, 6, "Fight Club" );
    MovieDao m3 = new MovieDao( 2010, 9, "Judwa" );
    MovieDao m4 = new MovieDao( 1999, 7, "Albela" );

    List<MovieDao> list = new ArrayList<>();
    list.add( m1 );
    list.add( m2 );
    list.add( m3 );
    list.add( m4 );

    System.out.println( "Before Sorting" );
    for( MovieDao a : list )
    {
      System.out.println( a );
    }
    System.out.println( "------------------------------" );
    System.out.println( "After Sorting on comparable (year based) " );
    Collections.sort( list );
    for( MovieDao a : list )
    {
      System.out.println( a );
    }
    System.out.println( "------------------------------" );
    System.out.println( "After Sorting on compartor (Year based) " );
    MovieyearCompare mn3 = new MovieyearCompare();
    Collections.sort( list, mn3 );
    for( MovieDao a : list )
    {
      System.out.println( a );
    }

    System.out.println( "------------------------------" );
    System.out.println( "After Sorting on compartor (Name based) " );
    MovieNameCompare mn1 = new MovieNameCompare();
    Collections.sort( list, mn1 );
    for( MovieDao a : list )
    {
      System.out.println( a );
    }


  }
}
