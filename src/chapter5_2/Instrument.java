package chapter5_2;

public class Instrument {

  private String serialNumber;
  private double price;
  InstrumentSpec spec;

  public Instrument(String serialNumber, double price, InstrumentSpec spec) {
    this.serialNumber = serialNumber;
    this.price = price;
    this.spec = spec;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public InstrumentSpec getSpec(){
    return this.spec;
  }



  @Override
  public String toString() {
    return "Instrument{" +
        "serialNumber='" + serialNumber + '\'' +
        ", price=" + price +
        ", spec=" + spec +
        '}';
  }
}
