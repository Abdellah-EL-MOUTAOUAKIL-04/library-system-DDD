package com.library.domain.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record Book(@Id String isbn, String author, String title,int publicationYear) {
}
