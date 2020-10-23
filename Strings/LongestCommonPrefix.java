package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// array of strings find longest common prefix in all
public class LongestCommonPrefix
{
  public static void findPrefix(String[] s)
  {
    List<String> list = new ArrayList<>(Arrays.asList( s ));
    Collections.sort( list, ( s1, s2 ) -> {
      if(s1.length() > s2.length()) return +1;
      else return -1;
    } );
   while(list.size()>1)
    {
      String s1 = list.remove( 0 );
      String s2 = list.remove( 0 );

      String ans = findCommon(s1,s2);
      if(ans.isEmpty() || ans.isBlank() )
      {
        System.out.println( "no common prefix exist" );
        return;
      }
      else
      {
        list.add( 0,ans);
      }
    }
    System.out.println(list.get( 0 ));
  }

  private static String findCommon( String s1_, String s2_ )
  {

    for(int i=0,j=0;i<s1_.length();i++,j++)
    {
      if( s1_.charAt( i ) != s2_.charAt( j ))
      {
        if(i==0)
          return "";
        else
          return s1_.substring( 0,i );
      }
    }
    return s1_;
  }

  public static void main( String[] args )
  {

    String [] s ={"prefix","prefixes","preorder","premature","press","prep"};
    findPrefix(s);
  }
}
