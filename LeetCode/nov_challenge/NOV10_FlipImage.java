package LeetCode.nov_challenge;
// Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
//
//To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0]
// horizontally results in [0, 1, 1].
//
//To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1,
// 1] results in [1, 0, 0].
//
//Example 1:
//
//Input: [[1,1,0],[1,0,1],[0,0,0]]
//Output: [[1,0,0],[0,1,0],[1,1,1]]
//Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
//Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]
public class NOV10_FlipImage
{
  public static void main( String[] args )
  {
    int [][] input = { {1,1,0} , {1,0,1} , {0,0,0} };
      input = filpIt(input);
      for(int[] a : input)
      {
        for(int b : a)
        {
          System.out.print(b + " ");
        }
        System.out.println();
      }
  }

  private static int[][] filpIt( int[][] input )
  {
    for(int i =0;i<input.length;i++)
    {
      for (int j=0,k=input.length-1;j<=k;j++,k--)
      {
        if(j==k)
        {
          input[i][j] =  (input[i][j]) ^ 1;
        }
        else
        {
          int temp = (input[i][j]) ^ 1;
          input[i][j] = (input[i][k]) ^ 1;
          input[i][k] = temp;
        }
      }
    }
    return input;
  }
}
