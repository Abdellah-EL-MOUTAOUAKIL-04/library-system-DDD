package com.library.domain.repository;

import com.library.domain.borrow.BorrowRecord;
import com.library.exception.LibraryException;

import java.util.List;
import java.util.Optional;

public interface BorrowRecordRepository {
    void save(BorrowRecord borrowRecord) throws LibraryException;
    Optional<BorrowRecord> findByBookAndMember(String isbn, String memberId) throws LibraryException;
    List<BorrowRecord> findAll() throws LibraryException;
}
