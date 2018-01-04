package test.sysoev;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Main {
	public static void main(String[] args) {
/*		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		BookService bookService = container.instance().select(BookService.class).get();*/
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
//		SeContainer cont = contInit.initialize();
//		try (SeContainer container = initializer.disableDiscovery().addBeanClasses(BookService.class).initialize()) {
		try (SeContainer container = initializer.initialize()) {
			BookService bookService = container.select(BookService.class).get();
			Book book = bookService.createBook("H2G2", 12.5f, "Hello, world!");
			System.out.println(book);
		}
//		weld.shutdown();
	}
}
