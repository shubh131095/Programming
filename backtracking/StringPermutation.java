package backtracking;
// given a string of characters,find all the possbile permutation
// ex-> ABC
// o/p-> ABC,ACB,BAC,BCA,CAB,CBA

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// This que can have several modification
// 1. given string have repetaed char  -> one more condtion, so that u dont store alreay present
// 2. give the output in lexographic order.  -> just store the result in treeset.
// 3. give only the total no of possible permutation(atually easy its n!) -> if repetaed char , count freq and divide only maths.
// 4. instead of character numbers are given ( can be a string or aaray). -> exactly same as charcaters
public class StringPermutation
{
  public static void main( String[] args )
  {
    String s = "BADC";
    Set<String> ans = new TreeSet<>();
    getPermutation(s,ans,0,s.length()-1);
    System.out.println(ans);
  }

  private static void getPermutation( String s , Set<String> list,int start,int end)
  {
    if(start==end)
    {
      list.add( s );
      return;
    }
    for(int i=start;i<=end;i++)
    {
        s = charSwap(s,start,i);
        getPermutation( s,list,start+1,end );
        s = charSwap(s,start,i);
    }
  }

  private static String charSwap( String s, int start, int i )
  {
    //swapping of char in string can be done by 3 methods
    // 1. using string to char aaray.
    // 2. using string builder with setcharat
    //3. substring method of string

    //1.char aaray
   /* char[] str = s.toCharArray();
    str[i] = s.charAt( start );
    str[start] = s.charAt( i );
    return str.toString();*/

    //2. string builder
    StringBuilder sb = new StringBuilder(s);
    sb.setCharAt( i,s.charAt( start ) );
    sb.setCharAt( start,s.charAt( i ) );
    return sb.toString();

    //3. using substring
   /* if(i==start) return s;
    if(i==s.length()-1)
     return s= s.substring(0,start  ) + s.charAt( i ) + s.substring( start+1,i )+s.charAt( start );
    else
     return  s = s.substring( 0,start ) + s.charAt( i ) + s.substring( start+1,i ) + s.charAt( start) + s.substring( i+1 );
    */
  }
}
