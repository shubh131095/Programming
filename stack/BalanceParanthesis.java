package stack;

import java.util.Scanner;
import java.util.Stack;

public class BalanceParanthesis
{
  public static void main( String[] args )
  {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while(tc-- >0)
    {
      String input = sc.nextLine();
      char[] arr = input.toCharArray();
      Stack<Character> stk = new Stack<>();
      for(char ch : arr)
      {
        if((ch == '{') || (ch == '[') || (ch == '('))
        {
          stk.push( ch );
        }
        else if ( ch=='}')
        {
          if(stk.isEmpty() || stk.pop()!='{' )
          {
            System.out.println( "not balanced" );
            break;
          }
        }
        else if ( ch==']')
        {
          if(stk.isEmpty() || stk.pop()!='[' )
          {
            System.out.println( "not balanced" );
            break;
          }
        }
        else if ( ch==')')
        {
          if(stk.isEmpty() || stk.pop()!='(' )
          {
            System.out.println( "not balanced" );
            break;
          }
        }
      }
      if(stk.isEmpty()) System.out.println( "balanced" );
      else System.out.println( "not balanced" );
    }
  }
}
