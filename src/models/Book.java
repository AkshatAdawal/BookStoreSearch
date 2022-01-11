package models;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Book {
    private String title;
    private String isbn;
    private Publisher publisher;
    private Set<Author> authors;
    private BookStats bookStats;
}