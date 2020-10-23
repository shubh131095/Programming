package array;
// given 2 sorted array merge them without extra space
public class MergeSortedArray
{

  public static void mergeFaster(int arr1[], int arr2[], int n, int m)
  {
    int gap=0;
    if( (n+m)%2==0) gap = (n+m)/2;
    else gap = (n+m)/2+1;
    while( gap >=1 )
    {
      int i=0;
      int j=gap;
     while(j < (m+n) )
     {
      if( j < n)
      {
        if(arr1[i] > arr1[j])
        {
          int temp = arr1[i];
          arr1[i] = arr1[j];
          arr1[j]=temp;
        }
      }
      else if( j> n-1 && j< (n+m))
      {
        int y = j - n;
        if( i< n)
        {

          if( arr1[i]>arr2[y] )
          {
            int temp = arr1[i];
            arr1[i] = arr2[y];
            arr2[y]=temp;
          }
        }
        else
        {
          int x= i-n;
          if( arr2[x]>arr2[y] )
          {
            int temp = arr2[x];
            arr2[x] = arr2[y];
            arr2[y]=temp;
          }
        }
      }
      i++;j++;
     }
     if(gap/2==0) break;
      if( gap%2==0) gap = gap/2;
      else gap = (gap/2)+1;
    }
  }
  public static void merge(int arr1[], int arr2[], int n, int m)
  {

    for(int i=0;i<n;i++)
    {
      if(arr1[i]>=arr2[0])
      {
        int temp=arr1[i];
        arr1[i]=arr2[0];
        arr2[0]=temp;
        for(int k=1;k<m;k++)
        {
          if(arr2[k]<arr2[k-1])
          {
            int t = arr2[k-1];
            arr2[k-1] = arr2[k];
            arr2[k]=t;
          }
          else break;
        }
      }
    }

  }
  public static void main( String[] args )
  {
    int[] a1={0,8,9,20};
    int[] a2 = {1,3,6,14};
    //merge(a1,a2,a1.length,a2.length); // take O(M*N)
    mergeFaster(a1,a2,a1.length,a2.length) ;// take O(NlogN) gap algo standard.

    for(int i=0;i<a1.length;i++)
    {
      System.out.print(a1[i] + " ");
    }
    for(int i=0;i<a2.length;i++)
    {
      System.out.print(a2[i] + " ");
    }
  }
}
