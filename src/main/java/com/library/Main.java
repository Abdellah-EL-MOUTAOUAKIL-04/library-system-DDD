package com.library;

import com.library.application.service.LibraryService;
import com.library.application.service.LibraryServiceImpl;
import com.library.domain.book.Book;
import com.library.exception.LibraryException;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws LibraryException {
        LibraryService libraryService= LibraryServiceImpl.getInstance();
        libraryService.addBook(new Book("1234","abdellah","java",2030));
        libraryService.addBook(new Book("43","fsgfdsg","java",2030));
        libraryService.addBook(new Book("123234","abdgdsellah","java",2030));
        libraryService.addBook(new Book("231","fsdsf","java",2030));
        libraryService.addBook(new Book("432","weabd","java",2030));


        //search
        TreeSet<Book> search=libraryService.searchBooksByAuthor("abd");
        search.forEach(a -> System.out.println("Book : "+a.author()+" ,"+a.isbn()+" ,"+a.title()+" ,"+a.publicationYear()));
    }
}