package array;
//Given an array of positive integers. The task is to find inversion count of array.
//inversion is how steps away from being sorted.
public class InversionArray
{
  public static void shiftArray(int[] arr,int i,int j)
  {
    int temp=arr[i];
    int startIndex=i;
    i++;
    for(;i<=j;i++)
    {
      int temp2=arr[i];
      arr[i]=temp;
      temp=temp2;
    }
    arr[startIndex]=temp;
  }
  public static void main( String[] args )
  {
    int[] arr= {468,335,1,170,225,479,359,463,465,206,146,282,328,462,492,496,443,328,437,392,105,403,154,293,383,422,217,219,396,448,227,272,39,370,413,168,300,36,395,204,312,323};
    int count=0;
    /*
    apporach1 -> min steps
    int k=1;
    for( k=1;k<arr.length;k++)
    {
      if( arr[k]<arr[k-1] )
      {
        continue;
      }
      else
      {
        break;
      }
    }
    if(k==arr.length)
    {
      System.out.println("reverse order");
      count= arr.length;
      System.out.println(count);
      return;
    }
    for(int i=0;i<arr.length;i++)
    {
      int min = arr[i];
      int index=i;

      for( int j=i+1;j<arr.length;j++)
      {
        if(arr[j]<min)
        {
          min = arr[j];
          index=j;
        }
      }
      if(!(i==index))
      {
        count++;
        min = arr[i];
        arr[i] = arr[index];
        arr[index] = min;
      }
    }
    for( int i = 0; i < arr.length; i++ )
    { System.out.print(arr[i] +  "  "); }
    System.out.println( " \n " + count);*/

    // aproach2 -> swapping not allowed
    for(int i=0;i<arr.length;i++)
    {
      int min = arr[i];
      int index = i;
      for( int j=i+1;j<arr.length;j++)
      {
        if(arr[j]<min)
        {
          min = arr[j];
          index=j;
        }
      }
      count+= (index-i);
      shiftArray(arr,i,index);

    }
    System.out.println(count);
  }
}
