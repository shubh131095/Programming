package Strings;
// findind the min index of the substring present in 1st string
public class StrStr
{
  public static int strstr(String str, String target)
  {
    int size = target.length();
    for(int i=0,j=size-1;j<str.length();i++,j++)
    {
      if(str.substring(i,j+1).equals(target))
        return i;
    }
    return -1;
  }
  public static void main( String[] args )
  {
    String s =  "lrnkbldxguzgcseccinlizyogwqzlifxcthdgmanjztlt";
    String s1 = "an";
    int ans = strstr( s,s1 );
    System.out.println(ans);
  }
}
