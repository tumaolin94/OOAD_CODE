package chapter5_2;

import chapter5_2.myEnum.Builder;
import chapter5_2.myEnum.InstrumentType;
import chapter5_2.myEnum.Type;
import chapter5_2.myEnum.Wood;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindInstumentTester {
  public static void main(String[] args){
    Inventory inventory = new Inventory();
    initializeInventory(inventory);

    Map<String, Object> properties = new HashMap<>();
    properties.put("instrumentType", InstrumentType.GUITAR);
    properties.put("builder", Builder.COLLINGS);
    InstrumentSpec clientSpec = new InstrumentSpec(properties);

    List<Instrument> matchings = inventory.search(clientSpec);
    if(matchings.isEmpty()){
      System.out.println("Sorry, we have nothing for you.");
    }else{
      System.out.println("You might like these instruments: ");
      for(Instrument matching: matchings){
        System.out.println(matching);
      }
    }

  }

  private static void initializeInventory(Inventory inventory) {

    Map<String, Object> properties = new HashMap<>();
    properties.put("instrumentType", InstrumentType.GUITAR);
    properties.put("builder", Builder.COLLINGS);
    properties.put("model", "CJ");
    properties.put("type", Type.ACOUSTIC);
    properties.put("numString", 6);
    properties.put("topWood", Wood.INDIAN_ROSEWOOD);
    properties.put("backWood", Wood.BRAZILIAN_ROSEWOOD);
    InstrumentSpec spec1 = new InstrumentSpec(properties);
    inventory.addInstrument("1",100.0, spec1);

    Map<String, Object> properties2 = new HashMap<>();
    properties.put("instrumentType", InstrumentType.GUITAR);
    properties.put("builder", Builder.FENDER);
    properties.put("model", "CJ");
    properties.put("type", Type.ELECTRIC);
    properties.put("numString", 6);
    properties.put("topWood", Wood.INDIAN_ROSEWOOD);
    properties.put("backWood", Wood.BRAZILIAN_ROSEWOOD);
    InstrumentSpec spec2 = new InstrumentSpec(properties);
    inventory.addInstrument("2",200.0, spec2);
  }
}
