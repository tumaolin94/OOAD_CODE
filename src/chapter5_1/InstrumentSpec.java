package chapter5_1;

import java.util.Objects;

public abstract class InstrumentSpec {
  private Builder builder;
  private String model;
  private Type type;
  private Wood backWood;
  private Wood topWood;

  public InstrumentSpec(Builder builder, String model, Type type, Wood backWood,
      Wood topWood) {
    this.builder = builder;
    this.model = model;
    this.type = type;
    this.backWood = backWood;
    this.topWood = topWood;
  }

  public Builder getBuilder() {
    return builder;
  }

  public String getModel() {
    return model;
  }

  public Type getType() {
    return type;
  }

  public Wood getBackWood() {
    return backWood;
  }

  public Wood getTopWood() {
    return topWood;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstrumentSpec that = (InstrumentSpec) o;
    return builder == that.builder &&
        model.equalsIgnoreCase(that.model) &&
        type == that.type &&
        backWood == that.backWood &&
        topWood == that.topWood;
  }

  @Override
  public int hashCode() {
    return Objects.hash(builder, model, type, backWood, topWood);
  }

  @Override
  public String toString() {
    return "InstrumentSpec{" +
        "builder=" + builder +
        ", model='" + model + '\'' +
        ", type=" + type +
        ", backWood=" + backWood +
        ", topWood=" + topWood +
        '}';
  }
}
