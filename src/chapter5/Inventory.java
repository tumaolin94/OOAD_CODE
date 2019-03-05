package chapter5;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
  private List<Instrument> inventory;

  public Inventory() {
    this.inventory = new ArrayList<>();
  }

  public void addInstrument(String serialNumber, double price, InstrumentSpec instrumentSpec){
    Instrument instrument = null;

    if(instrumentSpec instanceof GuitarSpec){
      instrument = new Guitar(serialNumber, price, (GuitarSpec) instrumentSpec);
    }else if(instrumentSpec instanceof MandolinSpec){
      instrument = new Mandolin(serialNumber, price, (MandolinSpec) instrumentSpec);
    }
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

  public List<Instrument> search(GuitarSpec searchGuitar) {
    List<Instrument> res = new ArrayList<>();
    for(Instrument guitar: inventory){
      if(guitar.getSpec().equals(searchGuitar)){
        res.add(guitar);
      }
    }

    return res;
  }

  public List<Instrument> search(MandolinSpec mandolinSpec) {
    List<Instrument> res = new ArrayList<>();
    for(Instrument mandolin: inventory){
      if(mandolin.getSpec().equals(mandolinSpec)){
        res.add(mandolin);
      }
    }

    return res;
  }
}
