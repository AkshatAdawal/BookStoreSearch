package models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Author {
    String name;
    List<Book> booksWritten;
    private AuthorStats authorStats;
 }
