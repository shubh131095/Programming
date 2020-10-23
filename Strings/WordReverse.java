package Strings;

import java.util.Scanner;

//Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.
// example
// input:
// i.like.this.program.very.much
//Output:
//much.very.program.this.like.i
public class WordReverse
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while(tc-->0)
    {
      String[] input = sc.nextLine().split( "\\." );
      StringBuffer ans= new StringBuffer();
      for(int i=input.length-1;i>=0;i--)
      {
        ans.append(input[i]).append( "." );
      }
      ans.deleteCharAt( ans.length()-1 );
      System.out.println(ans);


    }
  }
}
