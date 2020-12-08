package Graph;

public class Edges<T>
{
  private int weight;
  private T source;
  private T destination;

  public Edges( int weight_, T source_, T destination_ )
  {
    weight = weight_;
    source = source_;
    destination = destination_;
  }

  public int getWeight()
  {
    return weight;
  }

  public void setWeight( int weight_ )
  {
    weight = weight_;
  }

  public T getSource()
  {
    return source;
  }

  public void setSource( T source_ )
  {
    source = source_;
  }

  public T getDestination()
  {
    return destination;
  }

  public void setDestination( T destination_ )
  {
    destination = destination_;
  }

  @Override
  public String toString()
  {
    return "Edges from source =" + source +
           " to destination=" + destination +
           " with weight= " + weight +
           '}';
  }
}
