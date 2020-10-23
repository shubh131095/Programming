package Strings;

public class Palindrome
{
  public static void main( String[] args )
  {
    String s = "harp";
    Boolean ans = checkPalindrom(s);
    System.out.println(ans);
  }

  private static Boolean checkPalindrom( String s_ )
  {
    boolean ans = true;

    for(int i=0,j= s_.length()-1;i<j;i++,j--)
    {
      if(s_.charAt( i )!=s_.charAt( j ))
      {
        return false;
      }
    }
    return ans;
  }
}
