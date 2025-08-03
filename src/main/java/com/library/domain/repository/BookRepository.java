package com.library.domain.repository;

import com.library.domain.book.Book;
import com.library.exception.LibraryException;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    void save(Book book) throws LibraryException;
    Optional<Book> findByIsbn(String isbn) throws LibraryException;
    List<Book> findAll() throws LibraryException;
    void delete(String isbn) throws LibraryException;
}