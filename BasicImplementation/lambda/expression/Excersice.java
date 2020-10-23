package BasicImplementation.lambda.expression;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Excersice
{
  public static void sortByLastName(List<Person> p1)
  {
    /*Comparator c = new Comparator()
    {
      @Override
      public int compare( Object p1, Object p2 )
      {
        char[] t1 = p1.toString().toCharArray();
        char[] t2 = p2.toString().toCharArray();
        for(int i=0,j=0;i<t1.length&&j<t2.length;i++,j++)
        {
          if( t1[i]>t2[i]) return 1;
          else if (t1[i]<t2[i]) return -1;
          else continue;
        }
        return 0;
      }
    };
    p1.sort( c );*/ //1

    /*Collections.sort( p1, new Comparator<Person>()
    {
      @Override
      public int compare( Person p1, Person p2 )
      {
       return ( ( p1.getfName().compareTo( p2.getfName() ) ==0 ) ? p1.getlName().compareTo( p2.getlName() ) : (p1.getfName().compareTo( p2.getfName())));
      }
    } );*/ //2

    Collections.sort( p1,(o1,o2)-> ( o1.getfName().compareTo( o2.getfName() ) ==0 ) ? o1.getlName().compareTo( o2.getlName() ) : (o1.getfName().compareTo( o2.getfName())) );//3

  }
  public static void main( String[] args )
  {
    List<Person> p1 = Arrays.asList(
      new Person("ballu","agrawal",25),
      new Person("shubham","agrawal",22),
      new Person("swati","verma",24),
      new Person("swati","sahu",30),
      new Person("hari","sadu",21),
      new Person("rahul","baghel",33));

    sortByLastName(p1);
    System.out.println(p1);
  }
}
