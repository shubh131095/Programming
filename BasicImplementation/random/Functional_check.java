package BasicImplementation.random;

@FunctionalInterface
public interface Functional_check
{
  public void cook(String name);

  default void doCook()
  {
    System.out.println("hello");
  }

  static void doCooking()
  {
    System.out.println("bonjior");
  }

}
