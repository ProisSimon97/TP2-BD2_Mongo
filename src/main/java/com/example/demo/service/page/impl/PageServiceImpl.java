package com.example.demo.service.page.impl;

import com.example.demo.domain.Page;
import com.example.demo.service.mapper.PageMapper;
import com.example.demo.service.page.PageService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {
    private final MongoCollection<Document> collection;

    public PageServiceImpl(MongoClient client) {
        MongoDatabase db = client.getDatabase("bd");
        this.collection = db.getCollection("page");
    }

    @Override
    public void create(Page page) {
        Document document = new Document("title", page.getTitle())
                .append("text", page.getText())
                .append("author", page.getAuthor())
                .append("date", page.getDate());

        collection.insertOne(document);
    }

    @Override
    public List<Page> find(String id) {
        Document filter = new Document("_id", new ObjectId(id));
        Document result = collection.find(filter).first();

        if(result == null)
            throw new RuntimeException();

        return List.of(PageMapper.map(result));
    }
}
