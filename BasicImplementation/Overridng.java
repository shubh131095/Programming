package BasicImplementation;

import java.io.Serializable;

class A
{
  int x=10;
  private void show()
  {
    System.out.println("A private show");
  }
  public static void print()
  {
    System.out.println("A public static print");
  }
   static void display()
  {
    System.out.println("A private static display");
  }
  
}
class B extends A
{
  int y=10;
  private void show()
  {
    System.out.println("B private show");
  }
  public static void print()
  {
    System.out.println("B public static print");
  }
   static void display()
  {
    System.out.println("B private static display");
  }
}
public class Overridng
{
  public static void main( String[] args )
  {
    A a = new A();
    B b = new B();
    A ab = new B();
    // B ba = (B) new A(); learn more about this related to factory pattern
    //a.show(); // error as private
    a.print();
    a.display();
    System.out.println(a.x);
    //System.out.println(a.y); // not aviable
    //b.show(); // error as private
    b.print();
    b.display();
    System.out.println(b.x);
    System.out.println(b.y);
    //ab.show(); // error as private
    ab.print();
    ab.display();
    System.out.println(ab.x);
    //System.out.println((ab.y);// even though child object is used the type is parent i.e why y not avaibale
    //ba.show(); // error as private

  }
}
