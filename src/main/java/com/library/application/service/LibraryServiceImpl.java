package com.library.application.service;

import com.library.domain.book.Book;
import com.library.domain.borrow.BorrowRecord;
import com.library.domain.member.Member;
import com.library.exception.LibraryException;

import java.util.List;

public final class LibraryServiceImpl implements LibraryService {
    @Override
    public void addBook(Book book) throws LibraryException {

    }

    @Override
    public void removeBook(String isbn) throws LibraryException {

    }

    @Override
    public List<Book> searchBooksByAuthor(String author) throws LibraryException {
        return List.of();
    }

    @Override
    public void registerMember(Member member) throws LibraryException {

    }

    @Override
    public void borrowBook(String isbn, String memberId) throws LibraryException {

    }

    @Override
    public void returnBook(String isbn, String memberId) throws LibraryException {

    }

    @Override
    public List<BorrowRecord> getBorrowRecords() throws LibraryException {
        return List.of();
    }
}
