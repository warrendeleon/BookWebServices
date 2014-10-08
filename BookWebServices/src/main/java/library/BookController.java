package library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/search")
	public List<Book> search(
			@RequestParam(value = "author", required = false) String author,
			@RequestParam(value = "title", required = false) String title) {

		List<Book> demoBooks = getDemoBooks();
		List<Book> resultSearch = new ArrayList<Book>();

		for (Book book : demoBooks) {
			boolean added = false;

			if (author != null && !added) {
				if ((book.getAuthor()).toLowerCase().contains(
						author.toLowerCase())) {
					System.out.println(book.getAuthor());
					System.out.println(author.toLowerCase());
					resultSearch.add(book);
					added = true;
				}
			}

			if (title != null && !added) {
				if ((book.getTitle()).toLowerCase().contains(
						title.toLowerCase())) {
					resultSearch.add(book);
					added = true;
				}
			}
		}

		return resultSearch;
	}

	@RequestMapping("/topsells")
	public List<Book> topsells(
			@RequestParam(value = "num", required = false, defaultValue = "1") int numSells) {
		List<Book> demoBooks = getDemoBooks();
		if (numSells > 0 && numSells <= demoBooks.size()) {
			Collections.sort(demoBooks, new CompareBookBySalesDescending());
			return demoBooks.subList(0, numSells);
		}

		return new ArrayList<Book>();

	}

	@RequestMapping("/autores")
	public Map<String, List<Book>> autores() {

		Map<String, List<Book>> mapBooksOtheredByAuthor = new HashMap<String, List<Book>>();
		List<Book> demoBooks = getDemoBooks();

		for (Book book : demoBooks) {
			if (!(mapBooksOtheredByAuthor.containsKey(book.getAuthor()))) {
				List<Book> list = new ArrayList<Book>();
				list.add(book);
				mapBooksOtheredByAuthor.put(book.getAuthor(), list);

			} else {
				(mapBooksOtheredByAuthor.get(book.getAuthor())).add(book);
			}
		}

		return mapBooksOtheredByAuthor;
	}

	/*
	 * @RequestMapping("/greeting") public Book greeting(
	 * 
	 * @RequestParam(value = "name", required = false, defaultValue = "World")
	 * String name) { return new Book(counter.incrementAndGet(),
	 * String.format(template, name)); }
	 */

	private List<Book> getDemoBooks() {
		List<Book> bookList = new ArrayList<Book>();

		Book book1 = new Book(counter.incrementAndGet(), "9788441531482",
				"IOS 5 (PROGRAMACION)");
		book1.setAuthor("ROB NAPIER");
		book1.setPublishedDate("" + new Date());
		book1.setNumSells(8500);

		Book book2 = new Book(counter.incrementAndGet(), "9788441531470",
				"Android 3 (PROGRAMACION)");
		book2.setAuthor("John Doe");
		book2.setPublishedDate("" + new Date());
		book2.setNumSells(10000);

		Book book3 = new Book(counter.incrementAndGet(), "9788441531450",
				"Spring (PROGRAMACION)");
		book3.setAuthor("Jane Doe");
		book3.setPublishedDate("" + new Date());
		book3.setNumSells(5000);

		Book book4 = new Book(counter.incrementAndGet(), "9788441531460",
				"IOS 6 (PROGRAMACION)");
		book4.setAuthor("ROB NAPIER");
		book4.setPublishedDate("" + new Date());
		book4.setNumSells(80000);

		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);

		return bookList;
	}
}
