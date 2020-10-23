package array;

import java.util.Scanner;

public class SubArraySum
{
  /*public static void main( String[] args )
  {
    Scanner s = new Scanner( System.in );
    int test_case = s.nextInt();
    while( (test_case--) > 0 )
    {
      int array_size = s.nextInt();
      int sum = s.nextInt();
      int start_index = -1;
      int end_index = -1;
      boolean flag = false;
      int array[] = new int[array_size];
      int k = 0;
      while( (array_size--) > 0 )
      {
        array[k++] = s.nextInt();
      }
      int current_sum = array[0] + array[1];
      if( array[0] == sum )
      {
        start_index = 0;
        end_index = 0;
        flag = true;
      }
      for( int i = 0, j = i + 1; i < array.length; )
      {
        if( current_sum == sum )
        {
          start_index = i;
          end_index = j;
          flag = true;
          break;
        }
        else if( current_sum < sum )
        {
          j = j + 1;
          if( j < array.length ) { current_sum = current_sum + array[j];}
          else {break;}
        }
        else
        {
          if( i == j )
          {
            j = j + 1;
            if( j < array.length )
            {
              current_sum = array[j] + current_sum;
            }
          }
          else
          {
            current_sum = current_sum - array[i];
            i++;
          }
        }
      }
      if( flag )
      {
        System.out.println( (start_index + 1) + " " + (end_index + 1) );

      }
      else
      {
        System.out.println( "-1" );
      }
    }
    }
    */
  // using double loop
  public static void main( String[] args )
  {
    Scanner sc = new Scanner( System.in );
    int tc = sc.nextInt();
    while( tc-- > 0 )
    {
      int size_of_array = sc.nextInt();
      int desired_sum = sc.nextInt();
      int starting_index = 0;
      int sum = 0;
      int ending_index = size_of_array - 1;
      boolean flag = false;
      int[] input_array = new int[size_of_array];
      for( int i = 0; i < size_of_array; i++ )
      {
        input_array[i] = sc.nextInt();
      }
      for( int j = 0; j < size_of_array; j++ )
      {
        sum = input_array[j];
        if(sum==desired_sum)
        {
          System.out.println(j+1+ " "+ (j+1) );
          flag=true;
          break;
        }
        for( int k = j + 1; k < size_of_array; k++ )
        {
          sum = sum + input_array[k];
          if( sum == desired_sum )
          {
            System.out.println( j + " " + k );
            flag = true;
            break;
          }
        }
        if( flag ) break;
      }
      if( !flag ) System.out.println( -1 );
    }
  }
}