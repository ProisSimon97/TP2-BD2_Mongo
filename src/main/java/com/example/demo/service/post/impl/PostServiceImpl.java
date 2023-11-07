package com.example.demo.service.post.impl;

import com.example.demo.model.Post;
import com.example.demo.service.mapper.PostMapper;
import com.example.demo.service.post.PostService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final MongoCollection<Document> collection;

    public PostServiceImpl(MongoClient client) {
        MongoDatabase db = client.getDatabase("test");
        this.collection = db.getCollection("post");
    }

    @Override
    public void create(Post post) {
        Document document = new Document("title", post.getTitle())
                .append("resume", post.getResume())
                .append("text", post.getText())
                .append("tags", post.getTags())
                .append("relatedLinks", post.getRelatedLinks())
                .append("author", post.getAuthor())
                .append("date", LocalDateTime.now());

        this.collection.insertOne(document);
    }

    @Override
    public List<Post> findLatest() {
        List<Document> latest = this.collection.find()
                .sort(Sorts.descending("date"))
                .limit(4)
                .into(new ArrayList<>());

        return latest.stream()
                .map(PostMapper::map)
                .toList();
    }
}
