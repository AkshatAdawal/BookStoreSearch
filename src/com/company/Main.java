package com.company;

import models.Author;
import models.Book;
import models.BookStats;
import models.Publisher;
import repository.AuthorCatalog;
import repository.BookCatalog;
import repository.PublisherCatalog;
import services.SearchService;

import java.util.Arrays;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        PublisherCatalog publisherCatalog = new PublisherCatalog();
        AuthorCatalog authorCatalog = new AuthorCatalog();
        BookCatalog bookCatalog = new BookCatalog();

        Publisher publisher = Publisher.builder()
                .name("data guard")
                                       .build();
        Publisher pearson = Publisher.builder()
                                     .name("pearsons")
                                     .build();

        Author author_1 = Author.builder()
                .name("Dalai Lama")
                                .build();
        Author author_2 = Author.builder()
                                .name("mason lee")
                                .build();

        Author author_3 = Author.builder()
                                .name("lew dewis")
                                .build();

        Author author_4 = Author.builder()
                                .name("jeffrey ullaman")
                                .build();

        Book book_1 = Book.builder()
                .title("zen mind")
                .isbn("ABCD-A")
                .publisher(publisher)
                .authors(Set.of(author_1, author_2 ))
                          .build();

        Book book_2 = Book.builder()
                          .title("personality building")
                          .isbn("ABCD-B")
                          .publisher(publisher)
                          .authors(Set.of(author_3, author_1 ))
                          .build();

        Book book_3 = Book.builder()
                          .title("data structures")
                          .isbn("ABCD-C")
                          .publisher(pearson)
                          .authors(Set.of(author_3 ))
                          .build();

        publisher.setBooksPublished(Arrays.asList(book_1, book_2));
        pearson.setBooksPublished(Arrays.asList(book_3));
        author_1.setBooksWritten(Arrays.asList(book_1, book_2));
        author_2.setBooksWritten(Arrays.asList(book_1));
        author_3.setBooksWritten(Arrays.asList(book_2));
        author_4.setBooksWritten(Arrays.asList(book_3));

        authorCatalog.addAuthor(author_1);
        authorCatalog.addAuthor(author_2);
        authorCatalog.addAuthor(author_3);
        authorCatalog.addAuthor(author_4);

        bookCatalog.addBook(book_1);
        bookCatalog.addBook(book_2);
        bookCatalog.addBook(book_3);

        publisherCatalog.addPublisher(publisher);
        publisherCatalog.addPublisher(pearson);


        SearchService searchService = new SearchService(authorCatalog, publisherCatalog, bookCatalog);

        System.out.println(searchService.search("Data"));
        System.out.println(searchService.search("mas"));

    }
}
