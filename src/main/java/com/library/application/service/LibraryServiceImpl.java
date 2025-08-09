package com.library.application.service;

import com.library.domain.book.Book;
import com.library.domain.borrow.BorrowRecord;
import com.library.domain.datastructure.LibraryTrie;
import com.library.domain.member.Member;
import com.library.domain.member.PremiumMemberDecorator;
import com.library.exception.LibraryException;

import java.time.LocalDate;
import java.util.*;

//synchronized keyword ensures that only one thread can execute the getInstance methode at a time preventing multiple instance
public final class LibraryServiceImpl implements LibraryService {
    private static volatile LibraryServiceImpl libraryServiceImpl;
    private LibraryServiceImpl(){
        if(libraryServiceImpl!=null){
            throw new RuntimeException("Use getInstance() to get the single instance.");
        }
    }
    public static LibraryServiceImpl getInstance(){
        if(libraryServiceImpl==null){
            synchronized (LibraryServiceImpl.class){
                if(libraryServiceImpl==null){
                    libraryServiceImpl=new LibraryServiceImpl();
                }
            }
        }
        return libraryServiceImpl;
    }

    private HashMap<String,Book> books=new HashMap<>();
    private List<Member> members=new ArrayList<>();
    private LinkedList<BorrowRecord> borrowRecords=new LinkedList<>();
    private final LibraryTrie titleTrie = new LibraryTrie();

    @Override
    public void addBook(Book book) throws LibraryException {
        if (book == null) throw new LibraryException("Book cannot be null");
        if (books.containsKey(book.isbn())) throw new LibraryException("Book with ISBN " + book.isbn() + " already exists");
        books.put(book.isbn(), book);
        titleTrie.insert(book);
        System.out.println("Book added successfully");
    }

    public List<Book> searchBooksByTitlePrefix(String prefix) throws LibraryException {
        if (prefix == null) throw new LibraryException("Prefix cannot be null");
        return titleTrie.search(prefix);
    }

    @Override
    public void removeBook(String isbn) throws LibraryException {
        if (isbn == null) throw new LibraryException("ISBN cannot be null");
        if (!books.containsKey(isbn)) throw new LibraryException("Book with ISBN " + isbn + " not found");
        books.remove(isbn);
        System.out.println("Book removed successfully");
    }

    @Override
    public List<Book> searchBooksByAuthor(String author) throws LibraryException {
        if (author == null) throw new LibraryException("Author cannot be null");

        return books.values().stream().filter(book -> book.author().equalsIgnoreCase(author)).toList();
    }

    @Override
    public void registerMember(Member member) throws LibraryException {
        if (member == null) throw new LibraryException("Member cannot be null");
        members.add(member);
        System.out.println("Member registred successfully");
    }

    @Override
    public void borrowBook(String isbn, String memberId) throws LibraryException {
        if (isbn == null || memberId==null) throw new LibraryException("ISBN or MemberId cannot be null");
        if (!books.containsKey(isbn)) throw new LibraryException("Book with ISBN " + isbn + " not found");
        Optional<Member> member=members.stream().filter(m->m.getId().equals(memberId)).findFirst();
        if(member.isEmpty())throw new LibraryException("Member with ID " + memberId + " not found");
        if(borrowRecords.stream().anyMatch(b->b.getIsbn().equals(isbn) && b.getReturnDate()==null)) throw new LibraryException("Book with ISBN " + isbn + " is already borrowed");
        if(member.get() instanceof PremiumMemberDecorator premiumMember){
            premiumMember.priorityBorrow(isbn);
        }else{
            borrowRecords.add(new BorrowRecord(isbn,memberId, LocalDate.now(),null));
            System.out.println("The Book with ISBN :"+isbn+" is borrowed by "+memberId+" Successfully");
        }
    }

    @Override
    public void returnBook(String isbn, String memberId) throws LibraryException {
        if (isbn == null || memberId==null) throw new LibraryException("ISBN or MemberId cannot be null");
        Optional<BorrowRecord> borrowRecord=borrowRecords.stream().filter(borrow->{
            return borrow.getIsbn().equals(isbn) && borrow.getMemberId().equals(memberId);
        }).findFirst();
        if(borrowRecord.isEmpty()) throw new LibraryException("No active borrow record found for ISBN " + isbn + " and member " + memberId);
        BorrowRecord oldRecord=borrowRecord.get();
        BorrowRecord newRecord=new BorrowRecord(isbn,memberId,oldRecord.getBorrowDate(),LocalDate.now());
        borrowRecords.set(borrowRecords.indexOf(oldRecord),newRecord);
        System.out.println("Book with ISBN: " + isbn + " returned by " + memberId + " successfully");    }

    @Override
    public List<BorrowRecord> getBorrowRecords() throws LibraryException {
        return Collections.unmodifiableList(borrowRecords);
    }
}
