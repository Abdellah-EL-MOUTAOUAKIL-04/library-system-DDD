package com.library.domain.member;

import com.library.domain.book.Book;
import com.library.domain.book.BookFactory;
import com.library.exception.LibraryException;

import java.util.Objects;

public class JsonBookAdapter {

    public static Book fromJson(String json) throws LibraryException{
        try {
            Objects.requireNonNull(json, "JSON string cannot be null");
            // Simple parsing (replace with org.json or Jackson in production)
            String cleanJson = json.replaceAll("[{}\"]", "");
            String[] parts = cleanJson.split(",");
            if (parts.length != 4) throw new LibraryException("Invalid JSON format: expected 4 fields");
            String isbn = parts[0].split(":")[1].trim();
            String title = parts[1].split(":")[1].trim();
            String author = parts[2].split(":")[1].trim();
            int year = Integer.parseInt(parts[3].split(":")[1].trim());
            return BookFactory.createBook(isbn, author, title, year);
        } catch (Exception e) {
            throw new LibraryException("Failed to parse JSON: " + e.getMessage(), e);
        }
    }
}
