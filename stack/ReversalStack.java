package stack;

import java.util.Stack;

// reverse the stack without using extra space(recusrrive allowed)
public class ReversalStack
{
  public static void reverseStack(Stack<Integer> s)
  {

  }
  public static void main( String[] args )
  {
    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    s.push(6);
    reverseStack(s);
    while( !s.isEmpty() ) { System.out.print(s.pop() + " "); }
  }
}
