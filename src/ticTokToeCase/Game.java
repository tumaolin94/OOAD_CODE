package ticTokToeCase;

import java.util.Scanner;

public class Game {

  private GameController gameController;
  private Player[] players;
  private Board board;
  private boolean isOver;
  private int index = 0;
  private Scanner input;


  public Game(GameController gameController, Player player1, Player player2, Board board) {
    this.gameController = gameController;
    this.players = new Player[]{player1, player2};
    this.board = board;
    this.isOver = false;
    input = new Scanner(System.in);
  }

  public void play(){
    System.out.println("Game Start!");
    board.showBoard();
    while(!isOver){
      Player curPlayer = geCurPlayer();
      System.out.println("It is "+ curPlayer.getName()+" Turn he/she is " + curPlayer.getPlayerType().toString());
      int[] pos = getPosition();
      while(!gameController.canPutOn(pos)){
        System.out.println("The postion is not valid, please re-input new position");
        pos = getPosition();
      }

      isOver = gameController.putOn(curPlayer, pos);
      board.showBoard();
    }

    System.out.println(getResult());

  }

  private int[] getPosition() {
    int[] pos = new int[2];
    pos[0] = input.nextInt();
    pos[1] = input.nextInt();
    return pos;
  }

  private Player geCurPlayer() {
    Player curPlayer = players[index % 2];
    index = (++index) % 2;
    return curPlayer;
  }

  public String getResult(){
    return gameController.getGameType().toString();
  }


}
