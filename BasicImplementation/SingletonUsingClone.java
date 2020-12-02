package BasicImplementation;
// in this we will try to create multiple instance of a singleton class using clone
class SingeltonA implements Cloneable
{
  private static SingeltonA obj = null;
  int a;
  String b;
  private SingeltonA()
  {
  }
  public static SingeltonA getInstance()
  {
    if(obj==null) return new SingeltonA();
    else return obj;
  }

  @Override
  public String toString()
  {
    return "SingeltonA{" +
           "a=" + a +
           ", b='" + b + '\'' +
           '}';
  }
}
public class SingletonUsingClone
{
  public static void main( String[] args )
  {
    SingeltonA x = SingeltonA.getInstance();
    x.a=10;x.b="hi";

    SingeltonA y = x;
    SingeltonA z = SingeltonA.getInstance();
    System.out.println(x);
    System.out.println(y);
    System.out.println(z);

    y.a=100;
    z.b="Z chnage";
    System.out.println(x);
    System.out.println(y);
    System.out.println(z);
  }
}
