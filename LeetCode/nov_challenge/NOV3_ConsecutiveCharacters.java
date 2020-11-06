package LeetCode.nov_challenge;
//Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one
// unique character.
//
//Return the power of the string.
// example :- hello -> 2
//            perda -> 1
//            eeeee -> 5
public class NOV3_ConsecutiveCharacters
{
  public static int maxPower(String s) {
    int ans = 0;
    int count =0;
    if(s.isBlank()||s.isEmpty()) return ans;
    for(int i=0,j=0;j<s.length();)
    {
      if(s.charAt( i )==s.charAt( j ))
      {
        count++;
        j++;
      }
      else
      {
        if(i==j)
        {
          i++;j++;
        }
        else
        {
          i=j;
        }
        count=0;
      }
      if(count>ans) {
        ans = count;
      }

    }
    return ans;
  }
  public static void main( String[] args )
  {
    String s = "healo";
    int ans = maxPower( s );
    System.out.println(ans);
  }
}
