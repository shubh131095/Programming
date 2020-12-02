package BasicImplementation;
class ATest
{
  int a;
  String b;

  public ATest( )
  {
    a = 10;
    b = "hoo";
  }

}
class Btest
{
  int x;
  String y;
  ATest atest = new ATest();
  public Btest()
  {
    x = 100;
    y="hello";
  }

  @Override
  public String toString()
  {
    return "Btest{" +
           "x=" + x +
           ", y='" + y + '\'' +
           ", atest.A=" + atest.a + ", atest.B=" + atest.b +
           '}';
  }
}
class C
{
  int aa;
  String bb;

}
class D implements Cloneable
{
  int dd;
  String ee;
  C ct=new C();

  public Object clone() throws CloneNotSupportedException
  {
    // if we do this only its eqivalent to shallow copy if C doesnt imlement cloneable
   //return super.clone();

   // if we do this then its deep copy.
    D dt = (D)super.clone();
    dt.ct = new C();
    return dt;
  }

  @Override
  public String toString()
  {
    return "D{" +
           "dd=" + dd +
           ", ee='" + ee + '\'' +
           ", ct.aa=" + ct.aa + ", ct.bb=" + ct.bb +
           '}';
  }
}
public class Clonning
{
  public static void main( String[] args ) throws CloneNotSupportedException
  {
    /*Btest bt = new Btest();
    bt.x = 999;
    bt.y="change in main b";
    bt.atest.a=666;
    bt.atest.b="chain main a";
    System.out.println(bt);
    // default intilization is eqivalent to shallow copy.
    Btest bt2 = bt;
    bt2.x=11111;
    bt2.atest.a=66666;

    bt.y="chainging after int b";
    bt.atest.b="chainging after int a";
// both produce same o/p
    System.out.println(bt2);
    System.out.println(bt);*/


    D d = new D();
    d.dd=10;
    d.ee="hi D";
    d.ct.aa=20;
    d.ct.bb="hi C";

    D d1 = (D)d.clone();
    d1.dd=100;
    d1.ct.aa=200;
    d.ee="Hi D after";
    d.ct.bb="Hi C after";
    System.out.println(d);
    System.out.println(d1);

  }
}
