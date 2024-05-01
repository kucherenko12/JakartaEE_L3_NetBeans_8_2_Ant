package com.example.jakartaee_l2.dao;

import com.example.jakartaee_l2.entities.Anquete;

import java.util.List;
import java.util.Optional;

public interface AnqueteDAO
{
    public Optional<Anquete> findAnquete(int id);
    public List<Anquete> findAnquetes(String[] tags);
    public void editAnquete(int id, Anquete anquete);
}
