package BasicImplementation.random;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// multiply 2 very big number
public class Multply2Big
{
  public static void main( String[] args )
  {
    int a = 1234567;
    int b = 1234567;
    String a1 = String.valueOf( a );
    String b1 = String.valueOf( b );
    String ans = mul(a1,b1);
    System.out.println(ans);
  }

  private static String mul( String a1, String b1 )
  {
    List<List<Integer>> op = new ArrayList<>();
    int carry=0;
    int shift=0;
    for( int i= b1.length()-1;i>=0;i-- )
    {
      List<Integer> list = new ArrayList<>();
      int curr = b1.charAt( i ) - '0';
      carry=0;
      for(int l=shift;l>0;l--)
      {
        list.add(0);
      }
      for(int j=a1.length()-1;j>=0;j--)
      {

        int nu= a1.charAt( j )-'0';
        int prod = curr*nu+carry;
        carry = prod/10;
        prod = prod%10;
        list.add( prod  );
      }
      if(carry>0)
      {
        list.add( carry );
      }
      shift++;
      op.add( list );
    }
    StringBuilder ans = new StringBuilder();
    carry=0;
    int j=0;
   for(int x=0;x<(a1.length()+b1.length());x++)
    {
      /*if(x > op.size())
      {
        break;
      }*/
      int sum = carry;

      for(int i=0;i<op.size();i++)
      {
          if( !(j>(op.get( i ).size()-1)))
           sum += op.get( i ).get( j );
      }
      j++;
      carry = sum/10;
      sum = sum%10;
      ans.append( sum );
    }
   if(carry>0)
   {
     ans.append( carry);
   }
     ans.reverse();
   return ans.toString();
  }
}
