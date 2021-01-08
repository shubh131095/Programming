package BasicImplementation.random;

public class Value_Parse
{
  public static void main( String[] args )
  {
    int a = 10;
    Integer b = 10;
    String str = "100";
    String str2 = "abc";
    char ch1 = 'a';
    char ch2 = '9';

    System.out.println(Integer.parseInt( str )); //100
    // System.out.println(Integer.parseInt( str2 )); // runtime error
    System.out.println(Integer.parseInt( str,10 )); // 100 ,radix is base
    // System.out.println(Integer.parseInt( ch2 ) )); error
    // System.out.println(Integer.parseInt( a )); error

    System.out.println(Integer.valueOf( str )); //100
    // System.out.println(Integer.valueOf( str2 )); // runtime error
    System.out.println(Integer.valueOf( str,10 )); //100
    // System.out.println(Integer.valueOf( str2,10 )); // runtime error
    System.out.println(Integer.valueOf( a )); //10
    System.out.println(Integer.valueOf( b )); //10
    System.out.println(Integer.valueOf( ch1 ));// 97
    System.out.println(Integer.valueOf( ch2 ));//57



  }
}
