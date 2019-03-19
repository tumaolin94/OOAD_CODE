package LibraryCase;

import java.util.HashMap;
import java.util.Map;

public class BookManager {

  private static Map<String, BookReservation> bookReservationMap;
  private static Map<String, BookLending> bookLendingMap;

  public BookManager() {
    bookReservationMap = new HashMap<>();
    bookLendingMap = new HashMap<>();
  }

  public static BookReservation fetchReservationDetails(String barcode){
    return bookReservationMap.getOrDefault(barcode, null);
  }

  public static BookLending fetchLendingDetails(String barcode){
    return bookLendingMap.getOrDefault(barcode, null);
  }

  public static boolean lendBook(String barcode, String memberId){
    BookLending bookLending = new BookLending(barcode, memberId);
    return true;
  }


}
