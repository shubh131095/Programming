package com.shubham;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Game
{

  private Board board;
  private Player player_turn;
  private List<Player> player; // limit to 5 players.


  public Game( Board board_, Optional<Player> player_turn_, List<Player> player_ )
  {
    board = board_;
    player_turn = player_turn_.orElse( player_.get( 0 ) );
    player = new ArrayList<>(player_);
  }
  // we will generate number using Random. and a person get 2 more chances if he get six
  private int nextNumberGenerator()
  {
    // two way to gnerate random number
      // 1. random(min-max)+min -> nextInt
      //2.  ThreadLocalRandom.current().nextInt(min, max + 1)
    int finalNo=0;
    while(true)
    {
      Random rn = new Random( 5 );  // will create random value from 0-5.
      int newNumber = rn.nextInt()+1; // our range now became 1-6;
      if(newNumber==6)
      {
        finalNo +=6;
        if(finalNo==18)
          return 0;
        else
          {
            continue;
          }
      }
        finalNo += newNumber;
        break;
    }
    return finalNo;
  }
  public void setNextPlayerMove()
  {
    int cur_palyer = player.indexOf( player_turn );
    cur_palyer++;
    if(cur_palyer== player.size()) cur_palyer=0;
    player_turn = player.get( cur_palyer );
  }

  public void move(Player p)
  {
    if( !p.getPlayerName().equalsIgnoreCase( player_turn.getPlayerName() ))
    {
      System.out.println("Its :- " +  player_turn.getPlayerName() + " chance to move");
      return;
    }
    int diceRoll = nextNumberGenerator();
    int nextMove = p.getPosition() + diceRoll;
    System.out.println( player_turn.getPlayerName() + "Rolls " + nextMove);
    if(nextMove==100)
    {
      System.out.println(  player_turn.getPlayerName() + " Won the game ");
      System.exit( 1 );
    }
    if(nextMove>100)
    {
      System.out.println(  player_turn.getPlayerName() + "cant Move ahead ");
    }
    int currX = p.getPosition()/10;
    int currY = (p.getPosition()%10)-1;
    int newX = nextMove/10;
    int newY = (nextMove%10)-1;

    board.box[currX][currY].removePlayer( p );

    // if snake tail dont do anything
    Box finalBox = board.box[newX][newY];
    if(finalBox.hasSnake())
    {
      if( !(finalBox.getBlockNo() == finalBox.getSnake().getHead().getNumber()))
      {
        System.out.println(player_turn.getPlayerName()+ "got bitten by snake");
        newX=finalBox.getSnake().getTail().getX();
        newY=finalBox.getSnake().getTail().getX();
      }
    }
  else if(finalBox.hasLadder())
  {
    if( !(finalBox.getBlockNo() == finalBox.getLadder().getStart().getNumber()))
    {
      System.out.println(player_turn.getPlayerName()+ "got a ladder");
      newX=finalBox.getLadder().getStart().getX();
      newY=finalBox.getLadder().getStart().getY();
    }
  }
    board.box[newX][newY].addPlayer( p );
    setNextPlayerMove();
  }
}
