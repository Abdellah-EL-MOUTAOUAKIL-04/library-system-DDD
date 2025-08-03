package com.library.domain.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public record Book(@Id String isbn, String author, String title,int publicationYear) {
    public Book{
        Objects.requireNonNull(isbn,"ISBN cannot be null");
        Objects.requireNonNull(title,"Title cannot be null");
        Objects.requireNonNull(author,"Author cannot be null");
        if(publicationYear<0) throw new IllegalArgumentException("Publication year cannot be null");
    }
}
