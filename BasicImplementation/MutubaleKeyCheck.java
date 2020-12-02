package BasicImplementation;

import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class Employee1
{

  private int a;
  private Integer b;
  private String c;

  public int getA()
  {
    return a;
  }

  public Employee1( int a_, Integer b_, String c_ )
  {
    a = a_;
    b = b_;
    c = c_;
  }

  public void setA( int a_ )
  {
    a = a_;
  }

  public Integer getB()
  {
    return b;
  }

  public void setB( Integer b_ )
  {
    b = b_;
  }

  public String getC()
  {
    return c;
  }

  public void setC( String c_ )
  {
    c = c_;
  }

  @Override
  public boolean equals( Object obj )
  {

    if(obj==null) return false;
    if( obj.getClass()!=( this.getClass())) return false;
    Employee1 ob = (Employee1)obj;
    if(ob.getA()==this.getA()) return true;
    return false;
  }

 /* @Override
  public int hashCode()
  {
    int b = 10;
    return a+getA();
  }*/

  @Override
  public String toString()
  {
    return "Employee1{" +
           "a=" + a +
           ", b=" + b +
           ", c='" + c + '\'' +
           '}';
  }
}
public class MutubaleKeyCheck
{
  public static void main( String[] args )
  {
    Set<Employee1> set = new TreeSet<>(( o1, o2 ) -> { if( o1.getA() == o2.getA() ) return 0; else return -1;});
    Employee1 e1 = new Employee1(1,2,"a");
    Employee1 e2 = new Employee1(1,2,"b");
    Employee1 e3 = new Employee1(1,3,"a");
    Employee1 e4 = new Employee1(2,2,"a");
    set.add( e1 );
    set.add( e2 );
    set.add( e3 );
    set.add( e4 );
    for(Employee1 e : set)
    {
      System.out.println(e);
    }
    e1.setA(100);
    e2.setB(200  );
    e3.setC( "hello" );
    System.out.println("-------------------");
    for(Employee1 e : set)
    {
      System.out.println(e);
    }
  }
}
