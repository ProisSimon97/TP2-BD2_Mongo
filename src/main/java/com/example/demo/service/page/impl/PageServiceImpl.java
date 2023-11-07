package com.example.demo.service.page.impl;

import com.example.demo.model.Page;
import com.example.demo.service.mapper.PageMapper;
import com.example.demo.service.page.PageService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PageServiceImpl implements PageService {
    private final MongoCollection<Document> collection;

    public PageServiceImpl(MongoClient client) {
        MongoDatabase db = client.getDatabase("test");
        this.collection = db.getCollection("page");
    }

    @Override
    public void create(Page page) {
        Document document = new Document("title", page.getTitle())
                .append("text", page.getText())
                .append("author", page.getAuthor())
                .append("date", LocalDateTime.now().toString());

        collection.insertOne(document);
    }

    @Override
    public Page find(String id) {
        Document filter = new Document("_id", new ObjectId(id));
        Document result = collection.find(filter).first();

        if(result == null)
            throw new RuntimeException();

        return PageMapper.map(result);
    }
}
