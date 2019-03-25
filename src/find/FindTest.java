package find;

public class FindTest {

  public static void main(String[] args){
    Finder match = new Suffix("aba");

    MyPath path = new MyPath("aba", true, 1);

    System.out.println(match.match(path));
  }

}
