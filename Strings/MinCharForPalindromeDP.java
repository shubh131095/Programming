package Strings;
// given a string find the min no of char need to convert that String into a pallindrome
// ex:- bca
// ans 2 , acbca or bcacb

import java.util.HashMap;
import java.util.Map;

// Solved using Dp
// the problem can be divided into parts
// 1. if first and last char are same, just ignore and cal again by removing/excluding those 2
// 2. if they are not same
    //  cal min no required by string[L..H-1] , [L-1...H] ) +1
// try to understand with example. here L and H are pointer at extrmes poisiton of string.
public class MinCharForPalindromeDP
{
  static Map<String,Integer> dp;
  public static void main( String[] args )
  {
    String input = "fieelds";
    dp = new HashMap<>();
    int ans = findMinChar(input.toCharArray(),0,input.length()-1);
    System.out.println(ans);
  }

  private static int findMinChar( char[] inp, int low,int high)
  {
    // if single char come,ignore as we have already counted for it
    if( low>=high)
    {
      return 0;
    }
    String s = new String();
    for(int i=low;i<=high;i++)
    {
      s +=inp[i];
    }
    if(dp.containsKey( s )) return dp.get( s );
    if( low==high-1)
    {
      // if aa is there return 0 and if ab is there return 1
       if( inp[low]==inp[high])
      {
        dp.put( s,0 );
        return 0;
      }
      else
      {
        dp.put( s,1 );
        return 1;
      }
    }
    if(inp[low]==inp[high])
    {
      dp.put( s, findMinChar( inp,low+1,high-1 ));
    }
    else
    {
      dp.put( s, Math.min(findMinChar( inp,low,high-1 ),findMinChar( inp,low+1,high ))+1);
    }
    return dp.get( s );
  }

}
