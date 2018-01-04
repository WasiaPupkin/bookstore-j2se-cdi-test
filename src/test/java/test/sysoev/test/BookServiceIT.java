package test.sysoev.test;


import static org.junit.Assert.assertTrue;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import org.junit.Test;

import test.sysoev.Book;
import test.sysoev.BookService;
import test.sysoev.LoggingInterceptor;



public class BookServiceIT {
	@Test
	public void shouldCheckNumberIsMOCK() {
/*		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		BookService bookService = container.instance().select(BookService.class).get();*/
//		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		SeContainerInitializer initializer = SeContainerInitializer.newInstance()
				.disableDiscovery()
				.addPackages(BookService.class, MockGenerator.class)
//				.addBeanClasses(BookService.class)
				.enableInterceptors(LoggingInterceptor.class)
				.selectAlternatives(MockGenerator.class)
				.addProperty("property", true);
		
//				;
//		SeContainer cont = contInit.initialize();
		try (SeContainer container = initializer.initialize()) {
//		try (SeContainer container = initializer.initialize()) {
			BookService bookService = container.select(BookService.class).get();
			Book book = bookService.createBook("H2G2", 12.5f, "Hello, world!");
			assertTrue(book.getNumber().startsWith("MOCK"));
		}
		

//		weld.shutdown();
	}
}
