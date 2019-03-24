package battleShip;

import java.util.List;

public class Game {

  public static void main(String[] args){

  }

  public void setupInitialboard(Player player, List<Ship> ships){
    for(Ship ship: ships){
      int[] pos = player.getPositionByInput();
      Direction direction = Direction.getDirection(player.getIntByInput());
      player.placeShipOn(ship, pos[0], pos[1], direction);
    }
  }

  public void play(Player p1, Player p2){
    Player[] players = new Player[]{p1, p2};
    int idx = 0;
    while(!players[idx].lostGame()){
      Player curPlayer = players[idx % 2];
      Player targetPlayer = players[(idx + 1) % 2];
      int[] pos = curPlayer.getPositionByInput();
      curPlayer.attackTarget(targetPlayer, pos[0], pos[1]);

      if(targetPlayer.lostGame()){
        System.out.println(curPlayer.name + "win the game");
        break;
      }

    }
  }
}
