package BasicImplementation;
interface X
{
  void show();
}
interface Y
{
  void show();
}
 class Z implements X,Y
{
  public void show()
  {
    System.out.println("Z show");
  }
  void people()
  {
    System.out.println("hello");
  }

}
/*class D extends Z implements X
{
  public void show()
  {
    System.out.println("D show");
  }
}*/

public class FunctionOverriding
{
  public static void main( String[] args )
  {

  }
}
