package com.shubham.ticTacToe;

public class Player
{

  private String playerName;
  private int moveCount;

  public int getMoveCount()
  {
    return moveCount;
  }

  public void setMoveCount( int moveCount_ )
  {
    moveCount = moveCount_;
  }

  public Player( String playerName_ )
  {
    playerName = playerName_;
    moveCount =0;
  }

  public String getPlayerName()
  {
    return playerName;
  }

  public void setPlayerName( String playerName_ )
  {
    playerName = playerName_;
  }
}
