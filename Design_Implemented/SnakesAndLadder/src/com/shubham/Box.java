package com.shubham;

import java.util.ArrayList;
import java.util.List;

public class Box
{
  private Snake snake; // if it has any snake, we can get destination of tail from this
  private Ladder ladder; // same as snake
  private List<Player> player; // a block can have multiple player at a time.
  private Block blockNo; // the current position of the Box.


  public Box(Block blockNo_)
  {
    new Box(null,null,null,blockNo_);
  }
  public Box(Snake snake_,Block blockNo_)
  {
   new Box( snake_,null,null,blockNo_ );
  }
  public Box(Ladder ladder_,Block blockNo_)
  {
    new Box( null,ladder_,null,blockNo_ );
  }
  public Box( Snake snake_, Ladder ladder_, Player player_,Block blockNo_)
  {

    snake = snake_;
    ladder = ladder_;
    player = new ArrayList<>();
    if(player_!=null)
    {
      player.add( player_ );
    }

  }
  public boolean hasSnake()
  {
    if(this.getSnake()!=null) return true;
    else return false;
  }
  public boolean hasLadder()
  {
    if(this.getLadder()!=null) return true;
    else return false;
  }
  public void removePlayer(Player p)
  {
    player.remove( p );
  }
  public void addPlayer(Player p)
  {
    player.add( p );
  }
  public Snake getSnake()
  {
    return snake;
  }

  public void setSnake( Snake snake_ )
  {
    snake = snake_;
  }

  public Ladder getLadder()
  {
    return ladder;
  }

  public void setLadder( Ladder ladder_ )
  {
    ladder = ladder_;
  }

  public List<Player> getPlayer()
  {
    return player;
  }

  public void setPlayer( List<Player> player_ )
  {
    player = player_;
  }

  public int getBlockNo()
  {
    return blockNo.getNumber();
  }

  public void setBlockNo( Block blockNo_ )
  {
    blockNo = blockNo_;
  }
}
