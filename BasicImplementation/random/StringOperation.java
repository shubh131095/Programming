 package BasicImplementation.random;

import java.util.Arrays;

public class StringOperation
{
  public static void main( String[] args )
  {
    String s = "ABCSGy512j%$%^@12io2io1nzmxbx12345!@#$%^&**nbanshaAHSHGYAVbabv";
    char [] ch = s.toCharArray();
    System.out.println(ch.toString());
    for(int i=0;i<ch.length;i++)
    {
      System.out.print(Character.toLowerCase( ch[i] ) + "-");
    }
  }
}
