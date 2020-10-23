package array;
// Given two arrays X[] and Y[] of size M and N respectively. Find number of pairs such that xy > yx where x is an element from X[] and y is an element from Y[]. example X ={2,1,3}  and Y = {1,3,4} then ans =3 ( (2,1) (3,1) (3,4))
public class PowerPairs
{
  static long countPairs(int[] X, int[] Y, int m, int n)
  {
    long pair=0;
    for(int i=0;i<m;i++)
    {
      for( int j=0;j<n;j++)
      {
        if( ( Math.pow( X[i],Y[j] )) > (Math.pow( Y[j],X[i] )))
        {
          pair++;
          System.out.println( "[" + X[i] + " " + Y[j] + "]");
        }
      }
    }
    return pair;
  }
  public static void main( String[] args )
  {
    int a[] = {335,1,170,225,479,359,463,465,206,146,282,328,462,492,496,443,328,437,392,105,403,154,293,383,422,217,219,396,448,227,272,39,370,413,168,300,36,395,204,312,323,334};
    int b[] = {174,165,142,212,254,369,48,145,163,258,38,360,224,242,30,279,317,36,191,343,289,107,41,443,265,149,447,306,391,230,371,351,7,102,394,49,130,124,85,455,257,341,467,377,432,309,445,440,127,324,38,39,119,83,430,42,334,116,140,159,205,431,478,307,174,387,22,246};
    long count = countPairs(a,b,a.length, b.length );
    System.out.println(count);
  }
}
