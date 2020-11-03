package Strings;
// given a string find the min no of char need to convert that String into a pallindrome
// ex:- bca
// ans 2 , acbca or bcacb
public class MinCharForPalindrome
{
  public static void main( String[] args )
  {
    String input = "fieelds";
    int ans = findMinChar(input);
    System.out.println(ans);
  }
  private static int findMinChar( String input )
  {
    int ans =0;
    for(int i=0,j=input.length()-1;i<j;)
    {
      if(input.charAt( i ) != input.charAt( j ))
      {
        i++;
        ans++;
      }
      else
      {
        i++;j--;
      }
    }
    return ans;
  }
}
