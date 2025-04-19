package com.example.cs732assignmentbackendbaldm.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mood-cards")
public class MoodCard {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getThemeColour() {
        return themeColour;
    }

    public void setThemeColour(String themeColour) {
        this.themeColour = themeColour;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Unique identifier for the card (MongoDB document ID)
     */
    @Id
    private String id;

    /**
     * Month abbreviation (e.g: JAN, FEB)
     */
    private String month;

    /**
     * Day of month (1-31)
     */
    private String dayOfMonth;

    /**
     * Theme color code/name for card styling
     */
    private String themeColour;

    /**
     * FontAwesome icon name representing mood
     */
    private String mood;

    /**
     * Card title/heading
     */
    private String heading;

    /**
     * Diary content text
     */
    private String content;

}
