package com.example.arthur.p22_blindwallsapp;

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
