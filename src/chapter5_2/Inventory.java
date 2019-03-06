package chapter5_2;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
  private List<Instrument> inventory;

  public Inventory() {
    this.inventory = new ArrayList<>();
  }

  public void addInstrument(String serialNumber, double price, InstrumentSpec instrumentSpec){
    Instrument instrument = new Instrument(serialNumber, price, instrumentSpec);

    if(instrument != null){
      inventory.add(instrument);
    }

  }

  public Instrument getInstrument(String serialNumber) {
    for(Instrument instrument: inventory){
      if(instrument.getSerialNumber().equals(serialNumber)){
        return instrument;
      }
    }

    return null;
  }

  public List<Instrument> search(InstrumentSpec searchSpec) {
    List<Instrument> res = new ArrayList<>();
    for(Instrument instrument: inventory){
      if(instrument.getSpec().matches(searchSpec)){
        res.add(instrument);
      }
    }

    return res;
  }

}
