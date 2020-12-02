package Strings;
// swap 2 charcter in string  given the index, without using extra space.
public class StringSwap
{
  public static String swapChar(String s, int start,int i)
  {
    if(i==start);
    else if(i==s.length()-1)
      s= s.substring(0,start  ) + s.charAt( i ) + s.substring( start+1,i )+s.charAt( start );
    else
      s = s.substring( 0,start ) + s.charAt( i ) + s.substring( start+1,i ) + s.charAt( start) + s.substring( i+1 );

    return  s;
  }
  public static void main( String[] args )
  {
    String s = "ABCD";
    System.out.println(swapChar( s,0,1 ));
    System.out.println(swapChar( s,0,s.length()-1 ));
    System.out.println(swapChar( s,0,0 ));
    System.out.println(swapChar( s,2, s.length()-1 ));
  }
}
