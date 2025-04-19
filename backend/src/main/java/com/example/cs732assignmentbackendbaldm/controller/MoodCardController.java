package com.example.cs732assignmentbackendbaldm.controller;

import com.example.cs732assignmentbackendbaldm.pojo.MoodCard;
import com.example.cs732assignmentbackendbaldm.service.MoodCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing mood diary cards
 */

@RestController
@RequestMapping("/api/moodCards")
public class MoodCardController {

    // Service layer dependency
    @Autowired
    private MoodCardService moodCardService;

    /**
     * Get all mood cards
     * @return List of MoodCard entities in JSON format
     */
    @GetMapping
    public List<MoodCard> getMoodCards() {
        return moodCardService.getAllMoodCards();
    }

    /**
     * Create a new mood card entry
     * @param moodCard MoodCard object from request body
     * @return Persisted MoodCard entity with generated ID
     */
    @PostMapping
    public MoodCard createMoodCard(@RequestBody MoodCard moodCard) {
        return moodCardService.createMoodCard(moodCard);
    }

}
