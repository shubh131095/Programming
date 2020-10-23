package array;

// in the given array representing stock prices , find max profit u can obtain
/* apporaches
 1. brute force find for each array index
 */
public class StockMaxProfit
{
  public static void main( String[] args )
  {
    int[] arr = {2,5,12,7,1,5,4,10};
    int maxProfit=0;
    // approach1
   /* for(int i=0;i<input.length-1;i++)
    {
      for(int j=i+1;j<input.length;j++)
      {
        if(input[j]-input[i] > maxProfit)
          maxProfit = input[j]-input[i];
      }
    }*/

    int max_diff = arr[1] - arr[0];
    int min_element = arr[0];
    int i;
    for (i = 1; i < arr.length; i++)
    {
      if (arr[i] - min_element > max_diff)
        max_diff = arr[i] - min_element;
      if (arr[i] < min_element)
        min_element = arr[i];
    }

    System.out.println(max_diff);
  }
}
