package com.hascode.tutorial.app;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hascode.tutorial.dto.SimpleBook;
import com.hascode.tutorial.entity.Book;

public class Main {
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;

	public static void main(final String[] args) {
		new Main().run();
	}

	private void run() {
		emf = Persistence.createEntityManagerFactory("hascode-manual");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		for (int i = 0; i < 100; i++) {
			Book book = new Book();
			book.setTitle("title" + i);
			book.setAuthor("author" + i);
			book.setDescription("description" + i);
			book.setExcerpt("excerpt" + i);
			book.setIsbn("isbn" + i);
			book.setSomeOtherProp("prop" + i);
			em.persist(book);
		}
		long amount = em.createNamedQuery("Book.countAll", Long.class)
				.getSingleResult();
		System.out.println(amount + " books in the store..");
		tx.commit();

		List<Book> books = em.createNamedQuery("Book.findAll", Book.class)
				.getResultList(); // list of attached entities .. expensive ..
		System.out.println(books.size() + " Book entities' guessed size is: "
				+ sizeOf(books));
		List<SimpleBook> bookDtos = em.createNamedQuery(
				"Book.findAll.toSimpleBook", SimpleBook.class).getResultList();
		System.out.println(bookDtos.size()
				+ " Book entities' guessed size is: " + sizeOf(bookDtos));
		em.close();
		emf.close();
	}
}
