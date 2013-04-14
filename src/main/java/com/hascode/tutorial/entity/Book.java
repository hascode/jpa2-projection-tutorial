package com.hascode.tutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
		@NamedQuery(name = "Book.countAll", query = "SELECT COUNT(b) FROM Book b"),
		@NamedQuery(name = "Book.findAll.toSimpleBook", query = "SELECT NEW com.hascode.tutorial.dto.SimpleBook(b.id, b.title, b.author) FROM Book b") })
public class Book {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String author;
	private String isbn;
	private String description;
	private String excerpt;
	private String someOtherProp;

	public final Long getId() {
		return id;
	}

	public final void setId(final Long id) {
		this.id = id;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(final String title) {
		this.title = title;
	}

	public final String getAuthor() {
		return author;
	}

	public final void setAuthor(final String author) {
		this.author = author;
	}

	public final String getIsbn() {
		return isbn;
	}

	public final void setIsbn(final String isbn) {
		this.isbn = isbn;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(final String description) {
		this.description = description;
	}

	public final String getExcerpt() {
		return excerpt;
	}

	public final void setExcerpt(final String excerpt) {
		this.excerpt = excerpt;
	}

	public final String getSomeOtherProp() {
		return someOtherProp;
	}

	public final void setSomeOtherProp(final String someOtherProp) {
		this.someOtherProp = someOtherProp;
	}
}
