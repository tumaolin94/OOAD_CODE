package chapter5_1;

import java.util.List;

public class FindInstumentTester {
  public static void main(String[] args){
    Inventory inventory = new Inventory();

    inventory.addInstrument("2",100,new GuitarSpec(Builder.ANY, "A", Type.ACOUSTIC,Wood.BRAZILIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD,12));
    inventory.addInstrument("1",10,new GuitarSpec(Builder.ANY, "A", Type.ACOUSTIC,Wood.BRAZILIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD,12));

    GuitarSpec searchGuitar = new GuitarSpec(Builder.ANY, "a", Type.ACOUSTIC,Wood.BRAZILIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD , 12);
    List<Instrument> res  = inventory.search(searchGuitar);
    res.forEach(r -> System.out.println(r));
  }
}
