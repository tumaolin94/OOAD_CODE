package ticTokToeCase;

import ticTokToeCase.myEnum.StoneType;

public class Board {
  private int row;
  private int col;

  private StoneType[][] board;
  public Board(int row, int col) {
    this.row = row;
    this.col = col;
    this.board = new StoneType[row][col];

    initializeBoard();
  }

  private void initializeBoard() {
    for(int i = 0; i < row; i++){
      for(int j = 0; j < col; j++){
        board[i][j] = StoneType.EMPTY;
      }
    }
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public void showBoard(){
    System.out.println("This time: ");
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j].getContent()+", ");
      }
      System.out.println();
    }
  }

  public void add(int x, int y, int val) {
    board[x][y] = val == 1? StoneType.BLACK: StoneType.WHITE;
  }

  public boolean canPutOn(int x, int y) {
    if(x < 0 || x >= row || y < 0 || y >= col || board[x][y] != StoneType.EMPTY) return false;
    return true;
  }
}
