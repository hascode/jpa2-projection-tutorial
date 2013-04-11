package com.hascode.tutorial.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class SimpleBook {
	private Long id;
	private String title;
	private String author;

	public SimpleBook() {
	}

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
