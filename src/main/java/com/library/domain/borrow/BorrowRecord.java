package com.library.domain.borrow;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;
import java.util.Objects;

@Embeddable
//final class means unextended and it's not allowed by jpa cuz he require a no-args-constructor
//final attribute means immutability
public class BorrowRecord {
    private final String isbn;
    private final String memberId;
    private final LocalDate borrowDate;
    private final LocalDate returnDate;

    public BorrowRecord(String isbn,String memberId,LocalDate borrowDate,LocalDate returnDate){
        this.isbn = Objects.requireNonNull(isbn, "ISBN cannot be null");
        this.memberId = Objects.requireNonNull(memberId, "Member ID cannot be null");
        this.borrowDate = Objects.requireNonNull(borrowDate, "Borrow date cannot be null");
        this.returnDate = returnDate;
    }

    public BorrowRecord() {
        this.isbn = null;
        this.memberId = null;
        this.borrowDate = null;
        this.returnDate = null;
    }

    public String getIsbn() {
        return isbn;
    }
    public String getMemberId(){
        return memberId;
    }
    public LocalDate getBorrowDate(){
        return borrowDate;
    }
    public LocalDate getReturnDate(){
        return returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowRecord that = (BorrowRecord) o;
        return Objects.equals(isbn, that.isbn) && Objects.equals(memberId, that.memberId) && Objects.equals(borrowDate, that.borrowDate) && Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, memberId, borrowDate, returnDate);
    }

    @Override
    public String toString() {
        return "BorrowRecord{" +
                "isbn='" + isbn + '\'' +
                ", memberId='" + memberId + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
