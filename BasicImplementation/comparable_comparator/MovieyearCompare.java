package BasicImplementation.comparable_comparator;

import java.util.Comparator;

public class MovieyearCompare implements Comparator<MovieDao>
{
  public int compare(MovieDao o1 , MovieDao o2)
  {
    if(o1.year - o2.year < 0) return +1;
    else return -1;
  }
}
