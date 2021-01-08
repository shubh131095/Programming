package Strings;

public class Atoi
{
  public static void main( String[] args )
  {
    String s = "123";
    String s2 = "123a";
    int number=0;
    int k = s.length();
   for(int i=0;i<s.length();i++)
   {
     if( ((s.charAt( i ) - '0') >=0 ) && ((s.charAt( i ) - '0') <=9))
     {
       number += Math.pow( 10, --k ) * (s.charAt( i ) - '0');
     }
     else
     {
       number = -1;
       break;
     }
   }
    System.out.println(number);

  }
}
