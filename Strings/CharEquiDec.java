package Strings;
// find the decimal eqivalent for the given char
// example A -> 1 , AA-> 27 , AAA->703 etc
public class CharEquiDec
{
  public static void main( String[] args )
  {
    String s = "AAB";
    int num = 704;
    String value = findString(num);
    int ans = findDec(s);
    System.out.println(ans);
    System.out.println(value);
  }

  private static String findString( int num )
  {
    StringBuilder ans = new StringBuilder();
    Character ch = null;
    boolean flag=false;
    while(num>=26)
    {
      flag = false;
      if(num%26==0){ ch = 'Z';flag=true;}
       else{ ch = (char) (num % 26 + 'A' - 1); }
       ans.append( ch );

      num =num/26;
    }
    if (!flag)
    {
      ch = (char) (num + 'A' - 1);
      ans.append( ch );
    }
    return ans.toString();

  }

  private static int findDec( String s )
  {
    int len = s.length();
    int ans=0;
    int i=0;
    while(len>0)
    {
      ans += Math.pow(26,--len)*( ( s.charAt( i++ ) - 'A' ) +1);
    }
    return  ans;
  }
}
