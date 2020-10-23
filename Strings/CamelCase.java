package Strings;
// given string provide camel casenfor the same by removing all the next char to special char as uppercase
// ex - a bCs-eFs//gh
// ans- ABcsEfsGh
public class CamelCase
{
  public static boolean isUnder(Character ch)
  {
    if(((ch - 'a') >=0 ) && ((ch - 'a') <=25 ) || ((ch- 'A') >=0 ) && ((ch - 'A') <=25 ) )
      return true;
    else
      return false;
  }
  public static void main( String[] args )
  {
    String s = "a b c-dE/gb BF";

    if(s.length()<=0) return;
    StringBuilder ans = new StringBuilder();
    Character ch = s.charAt( 0 );
    if(isUnder( ch ) )
    {
      ans.append( ch.toString().toUpperCase() );
    }

    for(int i=0,j=1;j<s.length();i++,j++)
    {
      Character current=s.charAt( j );
      Character prev=s.charAt( i );
      if( isUnder( prev )  )
      {
        if(isUnder( current ))
        {
          ch = s.charAt( j );
          ans.append( ch.toString().toLowerCase() );
        }
      }
      else
      {
        if( isUnder( current )  )
        {
          ch = s.charAt( j );
          ans.append( ch.toString().toUpperCase() );
        }
      }
    }
    System.out.println(ans);
  }
}
