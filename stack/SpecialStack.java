package stack;

import java.util.Stack;

// This stack should work normally and will create its own function
//getMin-> which should give min number in stack at O(1), push pop and peek should also be O(1)
 /*class MyStack
{
  Stack s1;
  Stack s2;

  MyStack()
  {
    s1 = new Stack();
    s2 = new Stack();
  }
  public void push(int number)
  {
    s1.push( number );
    if( !s2.isEmpty() )
    {
      if( number < (int)s2.peek()) s2.push( number );
    }
    else s2.push( number );

  }
  public int getMin()
  {
    return (int)s2.peek();

  }
  public int pop()
  {
    if ( (int) s1.peek() == (int)s2.peek() ) s2.pop();
    return (int)s1.pop();
  }
}*/
class MyStack
{
  int minEle;
  Stack<Integer> s;


  MyStack()
  {
    s = new Stack<>();
  }
  /*returns min element from stack*/
  int getMin()
  {
    if( s!=null && !s.isEmpty() ) return minEle;
    else return -1;
  }

  /*returns poped element from stack*/
  int pop()
  {
    int ans=0;
    if(!s.isEmpty())
    {
      ans = s.pop();
      if( ans < minEle)
      {
        int temp = minEle - (ans);
        ans = minEle;
        minEle=temp;
      }
    }
    if(s==null || s.isEmpty()) {minEle=Integer.MAX_VALUE;}
    return ans;
  }

  /*push element x into the stack*/
  void push(int x)
  {
    if(s.isEmpty()) { s.push(x); minEle=x;}
    else
    {
      if( x>minEle){ s.push(x);}
      else {s.push(x-minEle); minEle=x;}
    }
  }
}

public class SpecialStack
{
  public static void main( String[] args )
  {
    MyStack st = new MyStack();
    st.push(8);
    System.out.println(st.getMin());
    st.push(4);
    System.out.println(st.getMin());
    st.push(7);
    System.out.println(st.getMin());
    st.push(3);
    System.out.println(st.getMin());
    st.push(10);
    System.out.println(st.getMin());
    st.push(2);
    System.out.println(st.getMin());
    st.push(11);
    System.out.println(st.getMin());

    st.pop();
    st.pop();
    System.out.println(st.getMin());
  }
}
