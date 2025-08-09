package com.library.domain.datastructure;

import com.library.domain.book.Book;

import java.util.*;

public class LibraryTrie {
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        List<Book> books = new ArrayList<>();
    }

    private final TrieNode root = new TrieNode();

    public void insert(Book book) {
        if (book == null || book.title() == null) return;
        TrieNode node = root;
        for (char c : book.title().toLowerCase().toCharArray()) {
            node.children.computeIfAbsent(c, k -> new TrieNode());
            node = node.children.get(c);
            node.books.add(book);
        }
    }

    public List<Book> search(String prefix) {
        if (prefix == null) return Collections.emptyList();
        TrieNode node = root;
        for (char c : prefix.toLowerCase().toCharArray()) {
            node = node.children.get(c);
            if (node == null) return Collections.emptyList();
        }
        return Collections.unmodifiableList(node.books);
    }
}
