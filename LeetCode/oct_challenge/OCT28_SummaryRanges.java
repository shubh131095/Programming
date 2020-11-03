package LeetCode.oct_challenge;

import java.util.ArrayList;
import java.util.List;

/*
Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

example
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
 */
public class OCT28_SummaryRanges
{
  public static List<String> summaryRanges( int[] nums) {
    List<String> output = new ArrayList<>();
    StringBuilder ans = new StringBuilder();
    int count=0;
    int size = nums.length;
    if(size<1)
    {
      return output;
    }
    for(int i=0,j=0;j<size;)
    {
      if(nums[i]==nums[j])
      {
        ans.append(nums[i]);
        j++;
      }
      else if(nums[j]-nums[i]==1) {i++;j++;count++;}
      else
      {
        if(count > 0)
        {
          ans.append("->"+nums[i]);
        }
        output.add(ans.toString());
        ans.delete(0,ans.length());
        i=j;
        count=0;
      }

    }
    if(count>0)
    {
      ans.append("->"+ nums[size-1] );
    }
    output.add(ans.toString());
    return output;
  }


  public static void main( String[] args )
  {
    int nums[] = {0,1,2,4,5,7};
    List<String> ans = summaryRanges(nums);
    System.out.println(ans);
  }
}
