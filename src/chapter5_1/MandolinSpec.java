package chapter5_1;

import java.util.Objects;

public class MandolinSpec extends  InstrumentSpec{


  Style style;

  public MandolinSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood,
      Style style) {
    super(builder, model, type, backWood, topWood);
    this.style = style;
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
    MandolinSpec that = (MandolinSpec) o;
    return style == that.style;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), style);
  }

  @Override
  public String toString() {
    return "MandolinSpec{" +
        "style=" + style +
        " spec="+ super.toString()+
        '}';
  }
}
