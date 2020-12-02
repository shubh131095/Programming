package array;
// Say you have an array prices for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one
// and sell one share of the stock multiple times).
//
//Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy
// again).
public class SellStockMul
{
  public static void main( String[] args )
  {
    int[] arr = {5,4,3,2};
    int profit=0;
    int currPrice=arr[0];

    for(int j=1;j<arr.length;j++)
    {
      if( arr[j] > currPrice)
      {
        profit = profit + (arr[j] - currPrice);
      }
        currPrice = arr[j];
    }
    System.out.println(profit);
  }


}
