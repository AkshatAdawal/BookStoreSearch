package repository;

import models.Author;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorCatalog {
    private Map<String, Author> authorNameToAuthorMap;


    public AuthorCatalog() {
        authorNameToAuthorMap = new HashMap<>();
    }

    public Author getAuthorByName(String name) {
        return authorNameToAuthorMap.get(name);
    }

    public void addAuthor(Author author) {
        authorNameToAuthorMap.put(author.getName(), author);
    }

    public List<Author> getAllAuthors() {
        List<Author> authorList = new ArrayList<>();
        authorList.addAll(authorNameToAuthorMap.values());
        return authorList;
    }
}
