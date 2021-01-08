package BasicImplementation;

import java.util.ArrayList;
import java.util.List;

class Raw<T>
{
  T name;
  T number;

  @Override
  public String toString()
  {
    return "Raw{" +
           "name=" + name +
           ", number=" + number +
           '}';
  }
}
public class RawTypeTest
{
  public static void main( String[] args )
  {
    Raw raw = new Raw(); // since its a genric class still we havent provided any type. it means its raw;
    raw.name = "hello";
    raw.number = 1;
    List list = new ArrayList(); // raw
    list.add(1);
    list.add("name");
    list.add(2.0);
    list.add(raw);
    System.out.println(list); // no error till now;

   // int number = raw.number; // error you have to type cast
  }
}
