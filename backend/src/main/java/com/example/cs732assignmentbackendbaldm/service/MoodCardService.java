package com.example.cs732assignmentbackendbaldm.service;

import com.example.cs732assignmentbackendbaldm.dao.MoodCardDao;
import com.example.cs732assignmentbackendbaldm.pojo.MoodCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for mood card operations
 */
@Service
public class MoodCardService {
    // MongoDB data access object
    @Autowired
    private MoodCardDao moodCardDao;

    /**
     * Retrieve all mood cards from database
     * @return List of all MoodCard entities
     */
    public List<MoodCard> getAllMoodCards() {
        return moodCardDao.findAll();
    }

    /**
     * Create new mood card record
     * @param moodCard MoodCard entity to be saved
     * @return Persisted MoodCard with generated ID
     */
    public MoodCard createMoodCard(MoodCard moodCard) {
        return moodCardDao.save(moodCard);
    }

}
