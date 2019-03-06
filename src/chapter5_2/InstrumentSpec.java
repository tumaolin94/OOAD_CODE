package chapter5_2;

import java.util.HashMap;
import java.util.Map;

public class InstrumentSpec {
  private Map<String, Object> properties;

  public InstrumentSpec(Map<String, Object> properties){
    if(properties == null){
      this.properties = new HashMap<>();
    }else{
      this.properties = new HashMap<>(properties);
    }
  }

  public Object getProperty(String propertyName){
    return properties.getOrDefault(propertyName, "null");
  }

  public Map<String, Object> getProperties(){
    return properties;
  }

  public boolean matches(InstrumentSpec otherSpec){
    for(String key: otherSpec.getProperties().keySet()){
      if(!properties.getOrDefault(key,"null").equals(otherSpec.getProperty(key))){
        return false;
      }
    }

    return true;
  }

  @Override
  public String toString() {
    return "InstrumentSpec{" +
        "properties=" + properties +
        '}';
  }
}
