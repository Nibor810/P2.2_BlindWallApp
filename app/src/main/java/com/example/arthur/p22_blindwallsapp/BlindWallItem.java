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


    public BlindWallItem(int id, String titel, String author, int year) {
        this.id = id;
        this.titel = titel;
        this.author = author;
        this.year = year;
    }
}
