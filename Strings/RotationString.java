package Strings;
//given 2 string find out whether theay are the same string with some rotation
// example : s1 = abcd s2 = cdab
public class RotationString
{
  public static boolean isRotationString( String s1, String s2)
  {
    if(s1.equals( s2 )) return true;
    char ch = s1.charAt( 0 );
    int a =0;
    boolean ans = true;
    while(true)
    {
      int start = s2.indexOf(ch,a );
      if(start == -1) { break;}
      a = start+1;
      ans=true;
      for(int i=0,j=start;i<s1.length();i++,j++)
      {
        if(j==s2.length()) j=0;
        if(s1.charAt( i )!=s2.charAt( j ))
        {
          ans = false;
          break;
        }
      }
    }
return ans;
  }
  public static void main(String args[])
  {
    String s1 = "ravi";
    String s2 = "irav";
 /*   boolean ans = isRotationString(s1,s2);
    System.out.println(ans);*/
    // 2nd approach
    StringBuilder s3 = new StringBuilder(s1);
    s3.append( s1 );
    System.out.println(s3.toString().contains( s2 ));
  }


}
