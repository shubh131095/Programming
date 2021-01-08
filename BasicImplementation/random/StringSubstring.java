package BasicImplementation.random;

import java.util.Set;
import java.util.TreeSet;

public class StringSubstring
{
  public static void main( String[] args )
  {
    String s= "dcba";
    Set<String> set = new TreeSet<>();
    getSubPosition(s,s.length(),set,"");

  }



  private static void getSubPosition( String s, int length,Set<String> set,String curr)
  {
    if(s==null || s.isEmpty()) return ;

    for(int i=0;i<length;i++)
    {
      if(s.charAt( i )>s.charAt( 0 ))
      {
        continue;
      }
      for(int j=i;j<length;j++)
      {
        set.add(s.substring( i,j+1 ));
      }
    }
    System.out.println(set.size());
  }
}
