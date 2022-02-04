import java.CentralLibrary.Book;
import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue {

    // PROPERTIES, FIELDS, GLOBAL VARIABLES
    Map<String,Book> bookCollection = new HashMap<String, Book>();
    int currentDay = 0;
    int lengthOfCheckOutPeriod = 7;
    double initialLateFee = 10;
    double feePerLateDay = 5;

    // CONSTRUCTORS
    public LibraryCatalogue(Map<String,Book> collection ) {
        this.bookCollection = collection;
    }
    public LibraryCatalogue(Map<String,Book> collection, int lengthOfCheckOutPeriod, double initialLateFee, int feePerLateDay ) {
        this.bookCollection =collection;
        this.lengthOfCheckOutPeriod = lengthOfCheckOutPeriod;
        this.initialLateFee = initialLateFee;
        this.feePerLateDay = feePerLateDay;
    }

    // GETTERS
    public int getCurrentDay() {
        return this.currentDay;
    }

    public Map<String, Book> getBookCollection() {
        return this.bookCollection;
    }

    public Book getBook(String bookTitle) {
        return getBookCollection().get(bookTitle);
    }

    public int getLengthOfCheckOutPeriod() {
        return this.lengthOfCheckOutPeriod;
    }

    public double getInitialLateFee() {
        return this.initialLateFee;
    }

    public double getFeePerLateDay() {
        return this.feePerLateDay;
    }

    // SETTERS
    public void nextDay() {
        currentDay++;
    }

    public void setDay(int day) {
        currentDay = day;
    }

    // INSTANCE METHODS
    public void checkOutBook(String title) {
        Book book = getBook(title);
        if (book.getIsCheckedOut()) {
            sorryBookAlreadyCheckedOut(book);
        }else {
            book.setIsCheckedOut(true, currentDay);
            System.out.println("You got checked out " + title + ". It is due on day " + (getCurrentDay() + getLengthOfCheckOutPeriod()) + ".");
        }
    }

    public void returnBook(String title) {
        Book book = getBook(title);
        int daysLate = currentDay - (book.getDayCheckedOut() + getLengthOfCheckOutPeriod());
        if (daysLate > 0) {
            System.out.println("You owe to the library ₹" + (getInitialLateFee()+ daysLate * getFeePerLateDay()) + " because your book is " + daysLate + " days overdue.");
        }else {
            System.out.println("Book returned. Thank you.");
        }
        book.setIsCheckedOut(false, -1);
    }

    public void sorryBookAlreadyCheckedOut(Book book) {
        System.out.println("Sorry, " + book.getTitle() + " is already out. It would be back on " + (getLengthOfCheckOutPeriod() + book.getDayCheckedOut()) + " .");
    }
}
