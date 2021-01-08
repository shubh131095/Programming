package array;

import java.util.HashMap;

// find the elements in the array which occur most no of time.
// by convention majority element defination is :- number which occur more than n/2 times.

// 1 approach -> ( O(n),O(n))
// get count of all variables in a map and keeping max count, later display that

// 2 apporach -> ( O(n2) , O(1))
// run two loops and keep the count of current element.

// 3 approach
// just sort and iterate and count

// 4 approah( ideal)
// try to understand with example.
// iterate the aaray
// keep majority element index and count , intilized to 0 ,1 respect.
// as movinf forward if elemet is same increate count and if diff decreae count.
// if count reaches 0, update both to current index and count as 1.
// the last index which we will get has to be a majority element if present in array.
// if aaray doesnt have any majority element it can return any element.
// a final check required to check if return element is majority element. ( if in que given there will be a majority element then no need to check)

public class MajorityElement
{
  public static void main( String[] args )
  {
    // here there are no majority element
    // int arr[] = {2,1,2,1,3,2,1,2};

    int arr[] = {2,1,2,1,3,2,1,2}; // in this case 2 is majority
    getMajorityElement(arr,arr.length);
  }
  private static boolean checkIfMajorityElement( int[] arr,int majority_eleme, int length_ )
  {
    int count=0;
    for(int i=0;i<length_;i++)
    {
      if(arr[i]==majority_eleme)
      {
        count++;
      }
    }
    if(count>(length_/2)) return true;
    else return false;
  }

  private static void getMajorityElement( int[] arr, int length )
  {
    int majority_ele = 0;
    int count = 1;
    for(int i=1;i<length;i++)
    {
      if(arr[i]==arr[majority_ele]) count++;
      else count--;

      if(count==0)
      {
        count=1;
        majority_ele=i;
      }
    }
    if( checkIfMajorityElement( arr, arr[majority_ele], length ) ) { System.out.println( arr[majority_ele] ); }
    else { System.out.println("no majority element"); }
  }

}
