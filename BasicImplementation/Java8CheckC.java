package BasicImplementation;

public class Java8CheckC implements Java8CheckA,Java8CheckB
{
  public void show()
  {
    System.out.println("show in C");
  }

  public static void main( String[] args )
  {
    Java8CheckC c= new Java8CheckC();
    Java8CheckB b=new Java8CheckB(){};
    Java8CheckA a=new Java8CheckA(){};
    c.show();
    a.show();
    b.show();
  }
}
