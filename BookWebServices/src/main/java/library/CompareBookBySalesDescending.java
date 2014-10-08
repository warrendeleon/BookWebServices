package library;

import java.util.Comparator;

public class CompareBookBySalesDescending implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {
		return b2.getNumSells() - b1.getNumSells();
	}
}
