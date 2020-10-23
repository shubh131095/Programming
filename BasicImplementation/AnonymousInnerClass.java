package BasicImplementation;

public class AnonymousInnerClass
{
  public static void main( String[] args )
  {
    int outer=0;
    int x=1;
    AnonymousImpl a1 = new AnonymousImpl()
    {
      int outer =10;
      @Override
      public void proveit()
      {
        System.out.println(outer + " " + x);
      }

      @Override
      public void doit()
      {
        System.out.println(outer + " " + x);
      }
    };
    a1.doit();
    a1.proveit();
    x=999;
    a1.doit();
    a1.proveit();

  }
}
