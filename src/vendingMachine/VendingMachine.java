package vendingMachine;

import java.util.List;
import vendingMachine.myEnum.Coin;
import vendingMachine.myEnum.Item;

public interface VendingMachine {
  public long selectItemAndGetPrice(Item item);
  public void insertCoin(Coin coin);
  public List<Coin> refund();
  public Bucket<Item, List<Coin>> collectItemAndChange();
  public void reset();


}
