package com.library.domain.repository;

import com.library.domain.member.Member;
import com.library.exception.LibraryException;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    void save(Member member) throws LibraryException;
    Optional<Member> findById(String id) throws LibraryException;
    List<Member> findAll() throws LibraryException;
}
