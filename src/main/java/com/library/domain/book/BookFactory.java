package com.library.domain.book;

import com.library.exception.LibraryException;

import java.util.Objects;

public class BookFactory {
    private static boolean isValidIsbn(String isbn) {
        return isbn != null && (isbn.length() == 10 || isbn.length() == 13) && isbn.matches("\\d+");
    }

    public static Book createBook(String isbn, String author, String title, int publicationYear)
            throws LibraryException {
        if (!isValidIsbn(isbn)) throw new LibraryException("Invalid ISBN format");
        Objects.requireNonNull(title, "Title cannot be null");
        Objects.requireNonNull(author, "Author cannot be null");
        if (publicationYear < 0) throw new LibraryException("Publication year cannot be negative");
        return new Book(isbn, author, title, publicationYear);
    }
}
