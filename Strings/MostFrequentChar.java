package Strings;

public class MostFrequentChar
{
  public static void findMostFreqChar(String s)
  {
    int[] arr = new int[26];
    int max = 0;
    char ch = '.';
    for( int i = 0; i < s.length(); i++ )
    {
      int cur = arr[s.charAt( i ) - 'a'];
      cur++;
      arr[s.charAt( i ) - 'a'] = cur;
      if( cur > max )
      {
        max = cur;
        ch = s.charAt( i );
      }
    }
    System.out.println(ch + " came for " + max );
  }
  public static void main( String[] args )
  {
    String s = "aaabbbcccc";
    findMostFreqChar(s);
  }
}

