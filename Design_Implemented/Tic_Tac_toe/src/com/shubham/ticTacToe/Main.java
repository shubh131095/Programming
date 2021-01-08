package com.shubham.ticTacToe;

import java.util.ArrayList;
import java.util.List;

public class Main
{
  public static void main( String[] args )
  {
    Board board = new Board(3  );
    Player player1 = new Player("Ballu");
    Player player2 = new Player("Shubham");
    List<Player> players = new ArrayList<>();
    players.add(player1);
    players.add( player2 );
    Game game = new Game( board,players );

  }
}
