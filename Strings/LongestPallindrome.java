package Strings;

import java.util.HashMap;
import java.util.Map;

// the implementation is very similar to Min char require in string to form a pallindrome.
public class LongestPallindrome
{
  static Map<String,Integer> dp;
  public static void main(String args[])
  {
    String ip = "aebabea";
    dp= new HashMap<>();
    System.out.println(getLongestPallindrome(ip,0,ip.length()-1));
  }

  private static int getLongestPallindrome( String ip, int low, int high )
  {
    if( low >=high)
    {
      return 0;
    }
    String s = ip.substring( low,high+1 );
    if(dp.containsKey( s )) return dp.get( s );
    if( low==high-1)
    {
      // if aa is there return 0 and if ab is there return 1
      if( ip.charAt( low )==ip.charAt( high ))
      {
        dp.put( s,2 );
        return 2;
      }
      else
      {
        dp.put( s,0 );
        return 1;
      }
    }

      dp.put( s, Math.max( checkPallindrom(s),Math.max( getLongestPallindrome( ip,low+1,high ),getLongestPallindrome(   ip,low,high-1 ) )));
    return dp.get( s );
  }

  private static int checkPallindrom( String s )
  {

    for(int i=0,j=s.length()-1;i<j;i++,j--)
    {
      if( s.charAt( i )!=s.charAt( j ))
      {

        return 0;
      }
    }
    return s.length();
  }
}
