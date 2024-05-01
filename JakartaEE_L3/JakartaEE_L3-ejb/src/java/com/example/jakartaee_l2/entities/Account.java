package com.example.jakartaee_l2.entities;

import java.util.List;

public class Account
{
    private int id;
    private String username;
    private String password;
    private Anquete anketa;
    
    public Account(int id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public Integer getId() { return(id); }
    public String getUsername() { return(username); }
    public String getPassword() { return(password); }
}
