package ticTokToeCase;

import ticTokToeCase.myEnum.PlayerType;

public class TicTokToe {

  public static void main(String[] args){
    Player player1 = new Player(1, "BLACK", PlayerType.BLACK);
    Player player2 = new Player(2, "WHITE", PlayerType.WHITE);
    Board board = new Board(3, 3);
    GameController gameController = new GameController(board);
    Game game = new Game(gameController, player1, player2, board);

    game.play();
  }

}
