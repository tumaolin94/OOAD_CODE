package LibraryCase;

public abstract class Librarian extends Account {
  public abstract boolean addBookItem(BookItem bookItem);
  public abstract boolean blockMember(Member member);
  public abstract boolean unBlockMember(Member member);
}
