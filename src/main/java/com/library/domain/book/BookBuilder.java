package com.library.domain.book;

import com.library.exception.LibraryException;

public class BookBuilder {
    private String isbn;
    private String author ;
    private String title;
    private int publicationYear;

    public BookBuilder withIsbn(String isbn){
        this.isbn=isbn;
        return this;
    }
    public BookBuilder withAuthor(String author){
        this.author=author;
        return this;
    }
    public BookBuilder withTitle(String title){
        this.title=title;
        return this;
    }
    public BookBuilder withPublicationYear(int publicationYear){
        this.publicationYear=publicationYear;
        return this;
    }
    public Book build() throws LibraryException{
        Book book=BookFactory.createBook(isbn,author,title,publicationYear);
        return book;
    }
}
