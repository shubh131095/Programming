package backtracking;

import java.util.ArrayList;
import java.util.List;

// given a string give all its sub sequence.
public class StringSubsequence
{
  public static void main( String[] args )
  {
    String s = "ABCD";
    List<String> ans = new ArrayList<>();
    getSubsequence(s,ans,"",0);
    ans.forEach( System.out::println );
  }

  private static void getSubsequence( String s, List<String> ans, String curr , int start)
  {
    if(start==s.length())
    {
      ans.add(curr);
      return;
    }
    getSubsequence( s,ans,curr+s.charAt( start ),start+1 );
    getSubsequence( s,ans,curr,start+1 );
  }
}
