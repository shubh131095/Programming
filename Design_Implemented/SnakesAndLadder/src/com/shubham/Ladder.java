package com.shubham;

public class Ladder
{
  Block start;
  Block finish;

  public Ladder( Block start_, Block finish_ )
  {
    // head should be before tail.
  if(! (start_.getNumber() < finish_.getNumber()))
  {
    System.out.println("invalid position for start and finish of a ladder.Please provide valid o/p");
  }
    start = start_;
    finish = finish_;
  }

  public Block getStart()
  {
    return start;
  }

  public void setStart( Block start_ )
  {
    start = start_;
  }

  public Block getFinish()
  {
    return finish;
  }

  public void setFinish( Block finish_ )
  {
    finish = finish_;
  }
}
