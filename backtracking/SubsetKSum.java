package backtracking;


import java.util.ArrayList;
import java.util.List;

// in this problem you have given a array(set) and a sum value k
// find the subset from the given set/array which sums upto k.
// since its a subset any possible combination is valid.
// since its a set , [1,5] and [5,1] is same;
// this can be solve using Dp also, that will de done in dp section
public class SubsetKSum
{
  public static List<List<Integer>> ans = new ArrayList<>();
  public static void main( String[] args )
  {
    int a[] = {1,5,2,8,4,6};
    int k = 10;
    List<Integer> set = new ArrayList<>();
    getSubsetSum(a,k,0,0,set);

    ans.stream().forEach( System.out::println );
  }

  private static void getSubsetSum( int[] a, int k,int sum,int current,List<Integer> set  )
  {
    if(sum>k) return;
    if(sum==k)
    {
      List<Integer> newList = new ArrayList<>(set);
      ans.add( newList );
      return;
    }
    for(int i=current;i<a.length;i++)
    {
      set.add( a[i] );
      sum += a[i];
      getSubsetSum( a,k,sum,i+1,set );
      set.remove( set.size()-1 );
        sum -= a[i];

    }
  }
}
