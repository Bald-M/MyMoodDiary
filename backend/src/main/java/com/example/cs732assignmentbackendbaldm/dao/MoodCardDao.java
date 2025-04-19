package com.example.cs732assignmentbackendbaldm.dao;

import com.example.cs732assignmentbackendbaldm.pojo.MoodCard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MoodCardDao extends MongoRepository<MoodCard, String> {
    /**
     * Find mood card by ID (Requires parameter implementation)
     * @return MoodCard entity
     */
    MoodCard findById();
    // MoodCard findAllBy();
}
