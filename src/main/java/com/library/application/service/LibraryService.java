package com.library.application.service;

import com.library.domain.book.Book;
import com.library.domain.borrow.BorrowRecord;
import com.library.domain.member.Member;
import com.library.exception.LibraryException;

import java.util.List;

public sealed interface LibraryService permits LibraryServiceImpl{
    void addBook(Book book) throws LibraryException;
    void removeBook(String isbn) throws LibraryException;
    List<Book> searchBooksByAuthor(String author) throws LibraryException;
    void registerMember(Member member) throws LibraryException;
    void borrowBook(String isbn, String memberId) throws LibraryException;
    void returnBook(String isbn, String memberId) throws LibraryException;
    List<BorrowRecord> getBorrowRecords() throws LibraryException;
}
