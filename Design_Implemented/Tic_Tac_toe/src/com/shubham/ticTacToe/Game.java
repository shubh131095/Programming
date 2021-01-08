package com.shubham.ticTacToe;

import java.util.List;
import java.util.Optional;

public class Game
{
  Board board;
  List<Player> playerList;
  Player player_turn;

  public Game( Board board_, List<Player> playerList_ )
  {
    board = board_;
    playerList = playerList_;
  }

  public void nextMove()
  {
    int index = playerList.indexOf( player_turn );
    int newIndex = index ^ 1;
    player_turn = playerList.get( newIndex );
  }
  public Boolean isFinished(Player p,int x,int y)
  {
    // todo wining condtion
    // approach -1 :- inefficient method:-keep move count in player and when it reaches size of board, then compare whole board for winning condtion. since a player cannot win with move less than size of board.
    // approach-2 :- still thinking

    //1
    Boolean flag = Boolean.TRUE;
    if(p.getMoveCount()< board.getSize())
      return false;
    else
    {
      // the player can win on the basis of its latest move only. so check acc to given x and y


      for(int i=0;i< board.getSize();i++)
          {
            if(!board.box[x][i].getMarked() || !board.box[x][i].getPlayer().getPlayerName().equalsIgnoreCase( p.getPlayerName() ))
            {
              flag = Boolean.FALSE;
              break;
            }
          }
      // vertical
      if(flag) return true;
      for(int i=0;i< board.getSize();i++)
      {
        if(!board.box[i][y].getMarked() || !board.box[i][y].getPlayer().getPlayerName().equalsIgnoreCase( p.getPlayerName() ))
        {
          flag = Boolean.FALSE;
          break;
        }
      }
      if(flag) return true;

      // right diagonal ( 2parts :- top right,down left)
      for(int i=x-1,j=y+1;x>=0&&y<board.getSize();i--,j++)
      {
        if(!board.box[i][j].getMarked() || !board.box[i][j].getPlayer().getPlayerName().equalsIgnoreCase( p.getPlayerName() ))
        {
          flag = Boolean.FALSE;
          break;
        }
      }
      if(flag)
      {
        for(int i=x+1,j=y-1;x< board.getSize()&&y>=0;i++,j--)
        {
          if(!board.box[i][j].getMarked() || !board.box[i][j].getPlayer().getPlayerName().equalsIgnoreCase( p.getPlayerName() ))
          {
            flag = Boolean.FALSE;
            break;
          }
        }
      }
      if(flag) return true;

      //left diagonal ( 2parts :- top left,down right)
      for(int i=x-1,j=y-1;x>=0&&y>=0;i--,j--)
      {
        if(!board.box[i][j].getMarked() || !board.box[i][j].getPlayer().getPlayerName().equalsIgnoreCase( p.getPlayerName() ))
        {
          flag = Boolean.FALSE;
          break;
        }
      }
      if(flag)
      {
        for(int i=x+1,j=y+1;x< board.getSize()&&y<board.getSize();i++,j++)
        {
          if(!board.box[i][j].getMarked() || !board.box[i][j].getPlayer().getPlayerName().equalsIgnoreCase( p.getPlayerName() ))
          {
            flag = Boolean.FALSE;
            break;
          }
        }
      }
    }
   return flag;
  }
  // which player is playing and at what box.
  public void doMove(Board board,Player player_,int x,int y)
  {
    // check if current player playing in its turn.
    if(!player_turn.getPlayerName().equalsIgnoreCase( player_.getPlayerName() ))
    {
      System.out.println( player_.getPlayerName() + " Its not ur turn");
      return;
    }
    // validate if move is outside board size
    if(x>= board.getSize() || y>= board.getSize() || y<0 || x<0)
    {
      System.out.println( player_.getPlayerName() + "the Box is outside boundary please select other box");
      return;
    }
    // if the position is already marked
    if(board.box[x][y].getMarked())
    {
      System.out.println( player_.getPlayerName() + "the Box is already marked please select other box");
      return;
    }
    else
    {
      board.box[x][y].setMarked( true );
      board.box[x][y].setPlayer( player_ );
      player_.setMoveCount( player_.getMoveCount()+1 );
      board.setBoxLeft( board.getBoxLeft()-1 );
    }
    // check if win
    if(isFinished( player_ ,x,y))
    {
      System.out.println(player_.getPlayerName() + "Has won the game");
      System.exit( 1 );
    }
    else if( board.getBoxLeft()==0)
    {
      System.out.println( "The game is draw");
      System.exit( 1 );
    }
    // set next player turn;
    nextMove();
  }
}
