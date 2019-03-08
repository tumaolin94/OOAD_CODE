package ticTokToeCase;

import ticTokToeCase.myEnum.PlayerType;

public class Player extends Account{
  private PlayerType playerType;

  public Player(int id, String name, PlayerType playerType) {
    super(id, name);
    this.playerType = playerType;
  }

  public PlayerType getPlayerType() {
    return playerType;
  }

  public void setPlayerType(PlayerType playerType) {
    this.playerType = playerType;
  }
}
