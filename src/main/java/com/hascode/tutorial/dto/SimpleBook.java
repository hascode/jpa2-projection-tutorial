package com.hascode.tutorial.dto;

public class SimpleBook {
	private final Long id;
	private final String title;
	private final String author;

	public SimpleBook(final Long id, final String title, final String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public final Long getId() {
		return id;
	}

	public final String getTitle() {
		return title;
	}

	public final String getAuthor() {
		return author;
	}

}
