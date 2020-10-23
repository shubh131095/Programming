package BasicImplementation.comparable_comparator;

public class MovieDao implements Comparable<MovieDao>
{
  int year;
  int rating;
  String name;

  public MovieDao( int year_, int rating_, String name_ )
  {
    year = year_;
    rating = rating_;
    name = name_;
  }

  public int getYear()
  {
    return year;
  }

  public int getRating()
  {
    return rating;
  }

  public String getName()
  {
    return name;
  }

  // used for years sorting
  @Override
  public int compareTo( MovieDao o_ )
  {

    return this.year - o_.year;
  }

  @Override
 public String toString()
 {
   return "Movie[ Name:- " + this.name + " Year:- " + this.year + " Rating:- " + this.rating ;
 }
}
