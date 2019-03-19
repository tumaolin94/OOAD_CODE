package LibraryCase;

import LibraryCase.myEnum.BookStatus;
import LibraryCase.myEnum.ReservationStatus;
import java.time.LocalDate;
import java.util.Date;

public class Member extends Account {
  private Date dateOfMembership;
  private int totalBooksCheckedout;

  public int getTotalBooksCheckedout(){
    return totalBooksCheckedout;
  }

  public Date getDateOfMembership() {
    return dateOfMembership;
  }

  public void setDateOfMembership(Date dateOfMembership) {
    this.dateOfMembership = dateOfMembership;
  }

  public void setTotalBooksCheckedout(int totalBooksCheckedout) {
    this.totalBooksCheckedout = totalBooksCheckedout;
  }

  public boolean checkoutBookItem(BookItem bookItem) {
    if(this.getTotalBooksCheckedout() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER ) {
//      ShowError("The user has already checkedout maximum number of books");
      return false;
    }
    BookReservation bookReservation = BookManager.fetchReservationDetails(bookItem.getBarcode());
    if( bookReservation != null &&  bookReservation.getMemberId() != this.getId() ) {
      // book item has a pending reservation from another user
      System.out.println("This book is reserved by another member");
      return false;
    } else if( bookReservation != null ) {
      // book item has a pending reservation from the give member, update it
      bookReservation.setStatus(ReservationStatus.COMPLETED);
    }

    if(!bookItem.checkout(this.getId())) {
      return false;
    }

    this.incrementTotalBooksCheckedout();
    return true;
  }


  protected void incrementTotalBooksCheckedout(){
    this.setTotalBooksCheckedout(this.getTotalBooksCheckedout() + 1);
  }
  private void checkForFine(String bookItemBarcode) {
    BookLending bookLending = BookManager.fetchLendingDetails(bookItemBarcode);
    Date dueDate = bookLending.getDueDate();
    Date today = new Date();
    // check if the book has been returned within the due date
    if(today.compareTo(dueDate) > 0) {
//      long diff = todayDate.getTime() - dueDate.getTime();
//      long diffDays = diff / (24 * 60 * 60 * 1000);
//      Fine.collectFine(memberId, diffDays);
    }
  }

  public void returnBookItem(BookItem bookItem) {
    BookReservation bookReservation = BookManager
        .fetchReservationDetails(bookItem.getBarcode());
    if(bookReservation != null) {
      // book item has a pendening reservation
      bookItem.setStatus(BookStatus.RESERVED);
    }
    bookItem.setStatus(BookStatus.AVAILABLE);
  }

  public boolean renewBookItem(BookItem bookItem) {
    return true;
  }
}