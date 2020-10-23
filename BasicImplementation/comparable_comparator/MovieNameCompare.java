package BasicImplementation.comparable_comparator;

import java.util.Comparator;

// o1 will be the current object which is being compared, o2 is existing object
public class MovieNameCompare implements Comparator<MovieDao>
{
  public int compare(MovieDao o1 , MovieDao o2)
  {
if(o1.name.compareToIgnoreCase( o2.name ) < 0) return +1;
else return -1;
  }
}
