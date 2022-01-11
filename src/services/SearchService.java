package services;

import datastructures.Trie;
import models.Author;
import models.Book;
import models.Publisher;
import repository.AuthorCatalog;
import repository.BookCatalog;
import repository.PublisherCatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {
    private Trie bookSearchStore;
    private Trie bookAuthorSearchStore;
    private Trie publisherSearchStore;

    private AuthorCatalog authorCatalog;
    private PublisherCatalog publisherCatalog;

    public SearchService(AuthorCatalog authorCatalog, PublisherCatalog publisherCatalog, BookCatalog bookCatalog) {
        buildBookTitlesTrie(bookCatalog.getAllBooks());
        buildBookAuthorsTrie(authorCatalog.getAllAuthors());
        buildBookPublishersTrie(publisherCatalog.getAllPublishers());
        this.authorCatalog = authorCatalog;
        this.publisherCatalog = publisherCatalog;
    }


    private void buildBookTitlesTrie(List<Book> books) {
        bookSearchStore = new Trie();
        for (Book book : books) {
            bookSearchStore.insert(book.getTitle());
        }
    }

    private void buildBookAuthorsTrie(List<Author> authors) {
        bookAuthorSearchStore = new Trie();
        for (Author author : authors) {
            bookAuthorSearchStore.insert(author.getName());
        }
    }

    private void buildBookPublishersTrie(List<Publisher> publishers) {
        publisherSearchStore = new Trie();
        for (Publisher publisher : publishers) {
            publisherSearchStore.insert(publisher.getName());
        }
    }


    public List<String> search(String queryTerm) {
        List<String> results = new ArrayList<>();
        List<String> bookTitles = bookSearchStore.search(queryTerm);

        if(bookTitles != null)
        results.addAll(bookTitles);

        List<String> authors = bookAuthorSearchStore.search(queryTerm);
        if(authors != null) {
            for (String author : authors) {
                System.out.println(author);
                Author authorObject = authorCatalog.getAuthorByName(author);
                results.addAll(authorObject
                                       .getBooksWritten()
                                       .stream()
                                       .map(book -> book.getTitle())
                                       .collect(Collectors.toList()));
            }

        }

        List<String> publishers = publisherSearchStore.search(queryTerm);
        if(publishers != null) {
            for (String publisher : publishers) {
                System.out.println(publisher);
                Publisher publisherObject = publisherCatalog.getPublisherByName(publisher);
                results.addAll(publisherObject
                                       .getBooksPublished()
                                       .stream()
                                       .map(book -> book.getTitle())
                                       .collect(Collectors.toList()));
            }
        }
        return results;
    }
}
