package com.shubham;

public class Player
{
  private String playerName;
  private Block position;

  public Player( String playerName_)
  {
    playerName = playerName_;
    position = new Block( 0,-1 );
  }

  public String getPlayerName()
  {
    return playerName;
  }

  public void setPlayerName( String playerName_ )
  {
    playerName = playerName_;
  }

  public int getPosition()
  {
    return position.getNumber();
  }

  public void setPosition( Block position_ )
  {
    position = position_;
  }
}
