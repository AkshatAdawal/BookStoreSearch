package repository;

import models.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookCatalog {
    private Map<String, Book> bookNameToBookMap;


    public BookCatalog() {
        bookNameToBookMap = new HashMap<>();
    }

    public Book getBookByName(String name) {
        return bookNameToBookMap.get(name);
    }

    public void addBook(Book book) {
        bookNameToBookMap.put(book.getTitle(), book);
    }

    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList.addAll(bookNameToBookMap.values());
        return bookList;
    }
}
