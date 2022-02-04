import java.Library.LiraryCatalogue;
public class LibraryRun {
	public static void main(String[] args) {
        Map<String, Book> bookCollection = new HashMap<String, Book>();
        Book harry = new Book("Harry Porter" , 782322 , 23232334);
        bookCollection.put("Harry Porter", harry);
        LibraryCatalogue lib = new LibraryCatalogue(bookCollection);
        lib.checkOutBook("Harry Porter");
        lib.nextDay();
        lib.nextDay();
        lib.checkOutBook("Harry Porter");
        lib.setDay(17);
        lib.returnBook("Harry Porter");
        lib.checkOutBook("Harry Porter");
    }
}
