package battleShip;

public class Board {

  private int rows;
  private int cols;

  Grid[][] grids;

  public Board(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.grids = new Grid[rows][cols];
  }

  public boolean checkPosition(Ship ship, int x, int y, Direction direction) {

    int len = ship.getLength();
    for(int i = 0; i < len; i++){
      int curX = x + direction.getX();
      int curY = y + direction.getY();
      if(!canPlace(curX, curY)){
        return false;
      }
    }
    return true;
  }

  private boolean canPlace(int x, int y){
    if(x < 0 || x >= rows || y < 0 || y >= cols || grids[x][y].isHitted() || grids[x][y].isShip()){
      return false;
    }else{
      return true;
    }
  }


  public void placeShipOn(Ship ship, int x, int y, Direction direction) {
    int len = ship.getLength();
    for(int i = 0; i < len; i++){
      int curX = x + direction.getX();
      int curY = y + direction.getY();
      setupGrid(curX, curY, true, false);
    }
  }

  private void setupGrid(int curX, int curY, boolean isShip, boolean isHitted) {
    grids[curX][curX].setShip(isShip);
    grids[curX][curX].setHitted(isHitted);
  }

  public boolean wasAttackAt(int x, int y) {
    Grid grid = grids[x][y];
    if(grid.isShip() && !grid.isHitted()){
      setupGrid(x, y, grid.isShip(), true);
      return true;
    }else{
      setupGrid(x, y, grid.isShip(), true);
      return false;
    }
  }
}
