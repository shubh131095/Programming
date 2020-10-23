package BasicImplementation;

public class InnerClass
{
   private int mgr;
   public int id;
   private static int count;
   private static int sal;
   static class StaticIClass
   {

      public void display()
      {
         System.out.println("trying to access every vriable here in static inner class , NON static method");
         count++;
         sal++;
        // id++; not accesible
        //  mgr++; not accesible
         System.out.println("count is: " + count + "sal is : "+ sal);
      }
      public static void show()
      {
         System.out.println("trying to access every vriable here in static inner class , static method");
         count++;
         sal++;
         // id++; not accesible
         //  mgr++; not accesible
         System.out.println("count is: " + count + "sal is : "+ sal);
      }
   }
   class NonStaticIClass
   {
      public void display()
      {
         System.out.println("trying to access every vriable here in  inner class , NON static method");
         count++;
         sal++;
          id++;
          mgr++;
         System.out.println("count is: " + count + "sal is : "+ sal);
         System.out.println("id is: " + id + "mgr is : "+ mgr);
      }
      // not allowed
    /*  public static void show()
      {
         System.out.println("trying to access every vriable here in static inner class , static method");
         count++;
         sal++;
         // id++; not accesible
         //  mgr++; not accesible
         System.out.println("count is: " + count + "sal is : "+ sal);
      }  */
   }

   public static void main( String[] args )
   {
      InnerClass.StaticIClass staticIclass = new InnerClass.StaticIClass();
      staticIclass.display();
      InnerClass.StaticIClass.show(); // show cannot be called using already instantiated object.
      staticIclass.display();

      InnerClass.NonStaticIClass nonStaticIClass = new InnerClass().new NonStaticIClass();
      nonStaticIClass.display();
      staticIclass.display();
      nonStaticIClass.display();
   }
}
