package BasicImplementation;

import com.sun.jdi.Value;

import java.util.ArrayList;

class Nodes<K,V>
{
   K key;
   V value;
   Nodes<K,V> next;


  Nodes(K key,V value)
  {
    this.key=key;
    this.value=value;
    next = null;
  }
}
class Employee
{
  int emp_id;
  String emp_name;
  int emp_salary;

  public Employee( int emp_id_, String emp_name_, int emp_salary_ )
  {
    emp_id = emp_id_;
    emp_name = emp_name_;
    emp_salary = emp_salary_;
  }

  public int getEmp_id()
  {
    return emp_id;
  }

  public void setEmp_id( int emp_id_ )
  {
    emp_id = emp_id_;
  }

  public String getEmp_name()
  {
    return emp_name;
  }

  public void setEmp_name( String emp_name_ )
  {
    emp_name = emp_name_;
  }

  public int getEmp_salary()
  {
    return emp_salary;
  }

  public void setEmp_salary( int emp_salary_ )
  {
    emp_salary = emp_salary_;
  }
  public String toString()
  {
    return " Employee [ ID = " + this.emp_id + " Name = " + this.emp_name + " Salary= " + this.emp_salary + " ]";
  }
  public int hashCode()
  {
    return emp_id/2;
  }
}

public class CustomHashMap<K,V>
{
  final static double LOAD_FACTOR=0.7;
  private ArrayList<Nodes<K,V>> buckets ; // this is the main buckets, inside the buckets all elements with same hashcode resides.
  private int capacity; // this is the total no of intial buckets
  private int size; // this is the size of aaraylist inside each bucket.

  CustomHashMap()
  {

    buckets = new ArrayList<>();
    capacity = 10;
    size=0;
      for(int i=0;i<capacity;i++) // creating empty chain in each buckets.
      {
        buckets.add(null);
      }
  }
  public int size() { return size;  }
  public boolean isEmpty() { return size()==0;}
  private int getKey(K key)  // this will provide only the bucket index which can contain this key. only for internal use.
  {
    int hash = key.hashCode();  // the object which will be passsed inside this should override hashcode.
    int index = hash%capacity;
    return  index;
  }
  public V get(K key)  // return the value for the key passed.
  {
    int current_bucket = getKey( key );
    Nodes<K,V> headOfList = buckets.get(current_bucket);

    while(headOfList!=null)
    {
      if(headOfList.key.equals( key )) return headOfList.value;
      headOfList=headOfList.next;
    }
    return null;
  }
  public V remove(K key)
  {
    int current_bucket = getKey( key );
    Nodes<K,V> headOfList = buckets.get( current_bucket );
    System.out.println( "Removing :- "+ key + " + key" );
    Nodes<K,V> prev = null;

    while( headOfList!=null )
    {
      if(headOfList.key.equals( key ))
        break;
      prev = headOfList;
      headOfList=headOfList.next;
    }
    if(headOfList==null) // this case will handle both if intially the key is not present or the bucket was empty.
    {
      System.out.println(  key + " not present" );
      return null;
    }
    size -- ;   // its been used for inreasing size of map(buckets) later
    if(prev!=null)   // that means its not the first element of list
      prev.next=headOfList.next;
    else
      buckets.set( current_bucket, headOfList.next ); // its the first element so the bucket start has to be changed to 2nd element
    return headOfList.value;
  }
  public void add(K key,V value)
{
     int current_bucket = getKey( key );
     Nodes<K,V> head = buckets.get( current_bucket );
     System.out.println( "Adding :- " + value + " for key: " + key );
     while(head !=null)
     {
       if(head.key.equals( key ))
       {
         head.value=value;
         return;
       }
       head= head.next;
     }
     size++ ; // adding new element
  head = buckets.get(current_bucket);
  Nodes<K,V> newNode = new Nodes<>( key,value );
   newNode.next=head;
   buckets.set( current_bucket,head );

   // this part is little trivial.
  // if the size of the hashmap (total elements) increase by load factor(we can decide that) we have to double the size of hashmap
  // since the key position can change after increasing hashpmap, we have to traverse each buckets and each element and add them again to the map.

  if(size*1.0/capacity >= LOAD_FACTOR)
  {
    System.out.println( "Loading factor crossed threshold increasing size" );
     ArrayList<Nodes<K,V>> temp = buckets;
     buckets = new ArrayList<>();
     capacity = capacity*2;
     size=0;
     for(int i=0;i<capacity;i++)
     {
       buckets.add(null);
     }
     for(Nodes<K,V> curr : temp)
     {
       while(curr!=null)
       {
         add(curr.key,curr.value);
         curr=curr.next;
       }
     }
  }
}
}
class Caller
{
  public static void main( String[] args )
  {
    Employee e1 = new Employee( 1,"Ballu",12000 );
    Employee e2 = new Employee( 2,"Shubham",13000 );
    Employee e3 = new Employee( 44,"ABhay",23300 );
    Employee e4 = new Employee( 3,"Rituraj",23000 );
    Employee e5 = new Employee( 10,"Passed",1900 );
    Employee e6 = new Employee( 15,"Champ",82210 );
    Employee e7 = new Employee( 23,"Null",000 );
    CustomHashMap<Integer,Employee> myMap = new CustomHashMap<>();
    myMap.add(e1.getEmp_id(),e1);
    myMap.add(e2.getEmp_id(),e2);
    myMap.add(e3.getEmp_id(),e3);
    myMap.add(e4.getEmp_id(),e4);myMap.add(e4.getEmp_id(),e4);
    myMap.add(e5.getEmp_id(),e5);
    myMap.add(e6.getEmp_id(),e6);
    myMap.add(e7.getEmp_id(),e7);myMap.add(e7.getEmp_id(),e7);

  }
}
