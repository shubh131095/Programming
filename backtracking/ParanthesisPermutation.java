package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// given n ->  tota pair of () , find the permutation of all valid paranthesis combination.
// n-> 2
// op-> (()),()()
//n->3
// op-> ()()(),(())(),((())),(()()),()(())
public class ParanthesisPermutation
{
  public  static boolean  checkString(String sb)
  {
    String as = sb.toString();
    Stack<Character> stk = new Stack<>();
    int count=0;
    for(int i=0;i<sb.length();i++)
    {
      Character ch = as.charAt(i);
      if(ch=='(')
      {
        stk.push(ch);
        count++;
      }
      else
      {
        if(stk.isEmpty()) return false;
        else
        {
          stk.pop();
          count--;
        }
      }
    }
    if(count==0) return true;
    else return false;
  }
  public static void  getStrings( List<String> ans , String sb , int opPara, int clPara, int totalSize)
  {
    if(sb.length()==totalSize)
    {
      boolean isValid = checkString(sb);
      if(isValid) ans.add(sb);
      return;
    }
    if(sb.length()>totalSize) return;
    if(opPara>0)
    {
      getStrings(ans,sb+'(',opPara-1,clPara,totalSize);
    }
    if(clPara>0)
    {
      getStrings(ans,sb+')',opPara,clPara-1,totalSize);
    }

  }
  public static List<String> generateParenthesis(int n) {
    if(n==0) return null;
    List<String> ans = new ArrayList<>();
    String sb = "";
    getStrings(ans,sb,n,n,2*n);
    return ans;
  }

  public static void main( String[] args )
  {
    List<String> ans = generateParenthesis( 3 );
    System.out.println(ans);
  }
}