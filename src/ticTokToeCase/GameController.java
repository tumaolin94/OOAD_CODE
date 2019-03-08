package ticTokToeCase;

import ticTokToeCase.myEnum.GameType;
import ticTokToeCase.myEnum.PlayerType;

public class GameController {

  private Board board;
  private int[] rows;
  private int[] cols;
  private int diagonal;
  private int antiDiagonal;
  private int row;
  private int col;
  private int stoneNumber;
  private GameType gameType;

  public GameController(Board board) {
    this.board = board;

    this.row = board.getRow();
    this.col = board.getCol();

    this.rows = new int[row];
    this.cols = new int[col];
    this.diagonal = 0;
    this.antiDiagonal = 0;

    this.stoneNumber = 0;

    this.gameType = GameType.ACTIVE;
  }

  public GameType getGameType() {
    return gameType;
  }

  public boolean putOn(Player curPlayer, int[] pos) {
    int x = pos[0];
    int y = pos[1];
    int val = curPlayer.getPlayerType().getValue();


    board.add(x, y, val);

    rows[x] += val;
    cols[y] += val;
    if(x == y) {
      diagonal += val;
    }

    if(x + y == row - 1){
      antiDiagonal += val;
    }

    stoneNumber++;

    gameType = judgement(curPlayer, x, y);

    return gameType.isOver();

  }

  private GameType judgement(Player curPlayer, int x, int y) {
    if(Math.abs(rows[x]) == row || Math.abs(cols[y]) == col || Math.abs(diagonal) == row || Math.abs(antiDiagonal) == row){
      if(curPlayer.getPlayerType() == PlayerType.BLACK){
        return GameType.BLACK_WIN;
      }else{
        return GameType.WHITE_WIN;
      }
    }

    if(stoneNumber == row * col){
      return GameType.TIE;
    }

    return GameType.ACTIVE;

  }


  public boolean canPutOn(int[] pos) {
    if(pos == null) return false;
    return board.canPutOn(pos[0], pos[1]);
  }
}
