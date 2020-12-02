package backtracking;

import java.util.ArrayList;
import java.util.List;

// Given n generate all the binary number of n bits.
// example n-> 2
// o/p -> 00,11,10,01
public class NbitsString
{
  public static void main( String[] args )
  {
    List<String> s = new ArrayList<>();
    getAllBits(4,s, ""); // here 3 is n;
    System.out.println(s);
  }

  private static void getAllBits( int i, List<String> s, String sb)
  {
    if(sb.length()==i)
    {
      s.add( sb);
      return;
    }
   getAllBits( i,s,sb+'0' );
    getAllBits( i,s,sb+'1' );
  }
}
