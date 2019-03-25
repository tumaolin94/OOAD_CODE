package find;

import java.nio.file.Path;

public class Suffix implements Finder {

  String str;

  public Suffix(String str){
    this.str = str;
  }

  @Override
  public boolean match(MyPath path) {
    return path.getName().equals(this.str);
  }

}
