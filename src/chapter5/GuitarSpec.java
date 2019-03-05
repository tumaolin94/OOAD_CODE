package chapter5;

import java.util.Objects;

public class GuitarSpec extends InstrumentSpec{

  private int numStrings;

  public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood,
      int numStrings) {
    super(builder, model, type, backWood, topWood);
    this.numStrings = numStrings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    GuitarSpec that = (GuitarSpec) o;
    return numStrings == that.numStrings;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numStrings);
  }

  @Override
  public String toString() {
    return "GuitarSpec{" +
        "numStrings=" + numStrings +
        " spec="+ super.toString()+
        '}';
  }
}
