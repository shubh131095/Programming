package Strings;

import java.util.Arrays;
import java.util.Scanner;
//incomplete
public class PermutationString
{
  public static char[] convertToArray(String s)
  {
    char[] ans = new char[s.length()];
    for(int i=0;i<s.length();i++)
    {
      ans[i] = s.charAt( i );
    }
    return ans;
  }
  public static void main( String[] args )
  {
    Scanner sc = new Scanner( System.in );
    int tc = sc.nextInt();
    while( tc-- > 0 )
    {
      String input= sc.nextLine();
      char[] arr = convertToArray(input);
      Arrays.sort(arr);

    }

  }
}
