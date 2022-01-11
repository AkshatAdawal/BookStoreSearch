package repository;

import models.Publisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PublisherCatalog {
    private Map<String, Publisher> publisherNameTopublisherMap;


    public PublisherCatalog() {
        publisherNameTopublisherMap = new HashMap<>();
    }

    public Publisher getPublisherByName(String name) {
        return publisherNameTopublisherMap.get(name);
    }

    public void addPublisher(Publisher publisher) {
        publisherNameTopublisherMap.put(publisher.getName(), publisher);
    }

    public List<Publisher> getAllPublishers() {
        List<Publisher> publishers = new ArrayList<>();
        publishers.addAll(publisherNameTopublisherMap.values());
        return publishers;

    }
}
