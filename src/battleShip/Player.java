package battleShip;

import java.util.List;
import java.util.Scanner;

public class Player {

  String name;
  int number;
  Board board;

  int totalNumber;

  private Scanner input;
  public Player(String name, int number, Board board) {
    this.name = name;
    this.number = number;
    this.board = board;
    this.totalNumber = 0;
    input = new Scanner(System.in);
  }

  public Player(Board board) {
    this.board = board;
  }

  public boolean placeShipOn(Ship ship, int x, int y, Direction direction){
    if(board.checkPosition(ship, x, y, direction)){
      totalNumber += ship.length;
      board.placeShipOn(ship, x, y, direction);
      return true;
    }else{
      return false;
    }
  }

  public void attackTarget(Player targetPlayer, int x, int y){
    targetPlayer.wasAttackAt(x, y);

  }

  public void wasAttackAt(int x, int y) {
    if(board.wasAttackAt(x, y)){
      totalNumber--;
    }
  }

  public int getIntByInput(){
    return input.nextInt();
  }

  public int[] getPositionByInput() {
    int x = input.nextInt();
    int y = input.nextInt();
    return new int[]{x, y};
  }

  public boolean lostGame() {
    return totalNumber == 0;
  }
}
