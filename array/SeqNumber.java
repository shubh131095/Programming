package array;

import java.util.ArrayList;
import java.util.List;

// given a array with high and low value ex [100,200]
// find all the number in that range which has consecutive digit diff as 1 ex 123
public class SeqNumber
{
  public static int countDigit(int num)
  {
    int count=0;
    while(num>0)
    {
      num = num/10;
      count++;
    }
    return count;
  }
  public static void main( String[] args )
  {

    int[] input = {0, 3000};
    int intial;
    int power=1;
    int a=1;
    int k=8;
    int temp=1;
    List<Integer> list = new ArrayList<>();

    while(true)
    {
      power = power + (int)Math.pow( 10,a );
      int x = k;
      intial = power + temp;
      temp=intial;
      while(x>0)
      {
        if(intial > input[0] && intial < input[1])
        {
          list.add( intial );
        }
        else if( countDigit( intial ) < countDigit( input[0] ) || intial > input[1] )
        {
          break;
        }
        intial += power;
        x--;
      }
      a++;
      k--;
      if( intial > input[1] )
      break;
    }
    System.out.println(list);
  }
}
