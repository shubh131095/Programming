package com.shubham;

public class Snake
{
 Block head;
 Block tail;

  public Snake( Block head_, Block tail_ )
  {
    // head should be after tail.
    if(! (head_.getNumber() > tail_.getNumber()))
    {
      System.out.println("invalid position for head and tail of a snake.Please provide valid o/p");
    }
    head = head_;
    tail = tail_;
  }

  public Block getHead()
  {
    return head;
  }

  public void setHead( Block head_ )
  {
    head = head_;
  }

  public Block getTail()
  {
    return tail;
  }

  public void setTail( Block tail_ )
  {
    tail = tail_;
  }
}
