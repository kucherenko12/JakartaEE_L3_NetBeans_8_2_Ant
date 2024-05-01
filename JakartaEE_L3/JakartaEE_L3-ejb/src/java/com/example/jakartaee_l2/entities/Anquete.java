package com.example.jakartaee_l2.entities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Anquete
{
    private int id;
    private File photo;
    private String name;
    private int age;
    private String shortInfo;

    private List<String> keywords;
    private Gender gender;

    public Anquete(int id,String name, int age, String shortInfo, List<String> keywords, Gender gender)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.shortInfo = shortInfo;
        this.keywords = keywords;
        this.gender = gender;
    }

    public Integer getId() { return(id); }
    public String getName() { return(name); }
    public int getAge() { return(age); }
    public String getShortinfo() { return(shortInfo); }
    public List<String> getKeywords() { return(keywords); }
    public String getKeywordsstring()
    {
        String keywordsString = "";
        for(String keyword : keywords) { keywordsString = keywordsString + " " + keyword; }
        return(keywordsString.trim());
    }
    public String getGenderstring() { return(gender.toString()); }
}
