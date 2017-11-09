package com.example.arthur.p22_blindwallsapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by robin on 9-11-2017.
 */

public class BlindWallItem implements Serializable{
    private int id;
    private String titel;
    private String author;
    private int year;
    private String description;

    public BlindWallItem(JSONObject json){
        try {
            this.id = json.getInt("id");
            this.titel = json.getJSONObject("title").getString("en").trim();
            this.author = json.getString("author").trim();
            this.year = json.getInt("year");
            this.description = description;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public BlindWallItem(int id, String titel, String author, int year,String description) {
        this.id = id;
        this.titel = titel;
        this.author = author;
        this.year = year;
        this.description = description;
    }

    public String getTitel() {
        return titel;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
