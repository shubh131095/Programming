package LeetCode.nov_challenge;
// We have n chips, where the position of the ith chip is position[i].
//
//We need to move all the chips to the same position. In one step, we can change the position of the ith chip from
// position[i] to:
//
//position[i] + 2 or position[i] - 2 with cost = 0.
//position[i] + 1 or position[i] - 1 with cost = 1.
//Return the minimum cost needed to move all the chips to the same position.

// approach -> just moving all the even place chips to 0 and odd place chips to 1 and moving 2 places will not cost anything.
//              now whichever is min we can move that use 1 cost per each chips.
//              if anyone is 0 then total cost will be 0.
public class NOV5_MinCostChipMove
{
  public static void main( String[] args )
  {
    int [] position = {1,1,1,3,3,3};
    int ans = countMinMov(position);
    System.out.println(ans);
  }

  private static int countMinMov( int[] position )
  {
    int ans =0;
    int evenP=0;
    int oddP=0;
    if(position.length==1) return ans;
    for(int i=0;i<position.length;i++)
    {
      if( (position[i]-1)%2==0) evenP++;
      else oddP++;
    }


    if(evenP > oddP)
    {
      return oddP;
    }
    else return evenP;


  }
}
