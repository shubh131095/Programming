package BasicImplementation.random.compare;

// by this excercise we will try to find out if we have a class which implement comparable and then you sort a list of object of the same class by passing a compartor. which will get more priority.

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable<Employee>
{
  String name;
  Integer id;

  public Employee(  int id_,String name_ )
  {
    name = name_;
    id = id_;
  }

  public String getName()
  {
    return name;
  }

  public void setName( String name_ )
  {
    name = name_;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId( Integer id_ )
  {
    id = id_;
  }

  @Override
  public String toString()
  {
    return "Employee{" +
           "name='" + name + '\'' +
           ", id=" + id +
           '}';
  }

  @Override
  public int compareTo( Employee emp )
  {
    return this.id.compareTo( emp.id );
  }
}
public class Compare
{
  public static void main( String[] args )
  {
    List<Employee> list = new ArrayList<>()
    {{
      add(new Employee(3,"A"));
      add(new Employee(4,"B"));
      add(new Employee(1,"D"));
      add(new Employee(2,"C"));

    }};
    System.out.println(list);

    Collections.sort(list);
    System.out.println(list);

    Collections.sort( list,(i,j)-> {
      return i.name.compareTo( j.name );
    } );
    // Collections.sort( list , Comparator.comparing(i -> i.name)) same as above
    System.out.println(list);

    Collections.sort( list, Comparator.comparing( Employee::getId ).thenComparing( Employee::getName ) );
  }
}
