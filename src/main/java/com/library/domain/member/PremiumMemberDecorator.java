package com.library.domain.member;

import com.library.exception.LibraryException;

import java.util.Objects;

public class PremiumMemberDecorator extends Member{
    private final Member member;
    public PremiumMemberDecorator(Member member){
        this.member = Objects.requireNonNull(member,"Member cannot be null");
    }
    public void priorityBorrow(String isbn) throws LibraryException {
        System.out.println("Premium member " + getId() + " borrowed book " + isbn + " with priority");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof PremiumMemberDecorator decorator) {
            return member.equals(decorator.member);
        }
        return member.equals(o);
    }

    @Override
    public int hashCode() {
        return member.hashCode();
    }

    @Override
    public String toString() {
        return "PremiumMemberDecorator{member=" + member + "}";
    }

}
