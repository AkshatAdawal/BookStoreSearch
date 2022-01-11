package models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Publisher {
    String name;
    List<Book> booksPublished;
}
