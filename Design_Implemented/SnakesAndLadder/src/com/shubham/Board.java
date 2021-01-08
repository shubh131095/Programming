package com.shubham;

import java.util.List;

public class Board
{
   Box[][] box;
  List<Snake> snakeList;
   List<Ladder> ladderList;

  public Board(  List<Snake> snakeList_, List<Ladder> ladderList_ )
  {
    intilizeBoard();
    box = new Box[100][100];
    for(int i=0;i<100;i++)
    {
      for( int j = 0; j < 100; j++ )
      {
          box[i][j] = new Box( new Block( i,j ) );
      }
    }
    snakeList = snakeList_;
    ladderList = ladderList_;
  }

  // intilize the board
  private void intilizeBoard()
  {
    // put all snakes in their respective box.
    for(Snake snake:snakeList)
    {
      Block head = snake.getHead();
      Block tail = snake.getTail();
      int headX= head.getX();
      int headY=head.getY();
      int tailX= tail.getX();
      int tailY=tail.getY();
      if(box[headX][headY].hasSnake() || box[tailX][tailY].hasSnake())
      {
        System.out.println("Snake already exist,please provide proper input");
        return;
      }
      box[headX][headY].setSnake( snake );
      box[tailX][tailY].setSnake( snake );
    }

    for(Ladder ladder:ladderList)
    {
      Block start = ladder.getStart();
      Block finish = ladder.getFinish();
      int startX= start.getX();
      int startY=start.getY();
      int finishX= finish.getX();
      int finishY=finish.getY();
      if(box[startX][startY].hasSnake() || box[finishX][finishY].hasSnake())
      {
        System.out.println("Snake already exist,please provide proper input");
        return;
      }
      box[startX][startY].setLadder( ladder );
      box[finishX][finishY].setLadder( ladder );
    }
  }

}

