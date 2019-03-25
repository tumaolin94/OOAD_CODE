package find;

public class MyPath {

  private String name;
  private boolean isDirectory;
  private int size;

  public MyPath(String name, boolean isDirectory, int size) {
    this.name = name;
    this.isDirectory = isDirectory;
    this.size = size;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isDirectory() {
    return isDirectory;
  }

  public void setDirectory(boolean directory) {
    isDirectory = directory;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
