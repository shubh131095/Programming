package com.shubham;

public class Player
{
  Boolean isWhitPlayer;
  String playerName;
  int pieceCount;

  public int getPieceCount()
  {
    return pieceCount;
  }

  public void setPieceCount( int pieceCount_ )
  {
    pieceCount = pieceCount_;
  }

  public Player( Boolean isWhitPlayer_ )
  {
      pieceCount=16;
    isWhitPlayer = isWhitPlayer_;
    if(isWhitPlayer_)
    {
      playerName="white";
    }
    else
    {
      playerName="black";
    }
  }

  public String getPlayerName()
  {
    return playerName;
  }
}
