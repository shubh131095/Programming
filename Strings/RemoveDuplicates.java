package Strings;

public class RemoveDuplicates
{
  public static void removeDuplicates(String s)
  {
    StringBuilder sb = new StringBuilder();
    int [] a = new int[26];
    sb.append( s.charAt( 0 ) );
    a[s.charAt( 0 ) - 'a'] = 1;
    for(int i=1;i<s.length();i++)
    {
      if(a[s.charAt( i ) - 'a'] ==0)
      {
        sb.append( s.charAt( i ) );
        a[s.charAt( i ) - 'a'] =1;
      }
      else
      {
        continue;
      }
    }
    System.out.println(sb);
  }
  public static void main( String[] args )
  {
    String s="abcdefaabbccss";
    removeDuplicates(s);
  }
}
