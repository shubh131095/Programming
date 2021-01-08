package BasicImplementation.random;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Emp
{
  int empId;
  String name;
  int marks;

  public Emp( int empId_, String name_, int marks_ )
  {
    empId = empId_;
    name = name_;
    marks = marks_;
  }

  public int getEmpId()
  {
    return empId;
  }

  public void setEmpId( int empId_ )
  {
    empId = empId_;
  }

  public String getName()
  {
    return name;
  }

  public void setName( String name_ )
  {
    name = name_;
  }

  public int getMarks()
  {
    return marks;
  }

  public void setMarks( int marks_ )
  {
    marks = marks_;
  }

  @Override
  public String toString()
  {
    return "Emp{" +
           "empId=" + empId +
           ", name='" + name + '\'' +
           ", marks=" + marks +
           '}';
  }
}
public class MultipleSort
{
  public static void main( String[] args )
  {
    Emp e1 = new Emp( 1,"Ballu",20 ) ;
    Emp e2 = new Emp( 2,"Shubham",20 ) ;
    Emp e3 = new Emp( 3,"Bantu",20 ) ;
    Emp e4 = new Emp( 4,"Shubhar",60 ) ;
    Emp e5 = new Emp( 5,"boxer",30 ) ;
    Emp e6 = new Emp( 6,"Nope",50 ) ;
    List<Emp> list = Arrays.asList( e1, e2, e3, e4, e5, e6 );
    System.out.println(list);
    List<Emp> list1 = new LinkedList<>(list);
    System.out.println(list1);
    Collections.reverse( list1 );
    System.out.println(list1);
/*    Comparator<Emp> comp = Comparator.comparing( Emp::getMarks).reversed().thenComparing(Emp::getName  );
    Collections.sort(list,comp);
    System.out.println(list);*/
  }
}
// Alternate approach
// 1. u can create a nested comparator block
  // for ex :- compare with 1st attribute
  // if 0 (means same) compare with other
  // if not same return that.

//2. you can implement compartor for each attribute of object and create a seprate class
  // let say new class aceept list of comparator.
  // there you can pass the list order in which u wanna sort
  // when passing compartor to collection.sort pass the new class object(EmployeeChainedComparator).

// 2nd approach code is here

// the main class which you should call.
class EmployeeChainedComparator implements Comparator<Emp> {

  private List<Comparator<Emp>> listComparators;

  @SafeVarargs
  public EmployeeChainedComparator(Comparator<Emp>... comparators) {
    this.listComparators = Arrays.asList(comparators);
  }

  @Override
  public int compare(Emp emp1, Emp emp2) {
    for (Comparator<Emp> comparator : listComparators) {
      int result = comparator.compare(emp1, emp2);
      if (result != 0) {
        return result;
      }
    }
    return 0;
  }
}

// like wise define comparator for others attribute
class EmployeeNameComparator implements Comparator<Emp>
{

  @Override
  public int compare( Emp emp1, Emp emp2 )
  {
    return emp1.getName().compareTo( emp2.getName() );

  }
}