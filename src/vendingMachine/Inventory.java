package vendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {

  private Map<T, Integer> inventory = new HashMap<>();

  public int getQuentity(T item) {
    return inventory.getOrDefault(item, 0);
  }

  public void add(T item) {
    inventory.put(item, inventory.getOrDefault(item, 0) + 1);
  }

  public void deduct(T item) {
    if (hasItem(item)) {
      int count = inventory.get(item);
      inventory.put(item, count - 1);
    }
  }


  public void put(T item, int count) {
    inventory.put(item, count);
  }

  public boolean hasItem(T item) {
    return inventory.containsKey(item) && inventory.get(item) > 0;
  }

  public void clear() {
    inventory = new HashMap<>();
  }


}
