package com.example.jakartaee_l2.dao;

import com.example.jakartaee_l2.entities.Anquete;
import com.example.jakartaee_l2.entities.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnqueteDAOStub implements AnqueteDAO
{

    @Override
    public Optional<Anquete> findAnquete(int id)
    {
        List<Anquete> allAnquetes = getAllAnquetesDBStub();
        try
        {
            allAnquetes.get(id);
            return(Optional.of(allAnquetes.get(id)));
        }
        catch (Exception exception)
        {
            //exception.printStackTrace();
            return(Optional.empty());
        }
    }

    @Override
    public List<Anquete> findAnquetes(String[] tags)
    {
        List<Anquete> allAnquetes = getAllAnquetesDBStub();

        List<Anquete> anquetes = findAnquetesStub(allAnquetes, tags);
        //List<Anquete> anquetes = findAnquetes(tags);

        return(anquetes);
    }

    @Override
    public void editAnquete(int id, Anquete anquete)
    {

    }

    private static List<Anquete> getAllAnquetesDBStub()
    {
        List<Anquete> anquetes = new ArrayList<>();

        List<String> keywords0 = new ArrayList<>();
        keywords0.add("money");
        keywords0.add("space");
        anquetes.add(new Anquete(0, "Jeff Bezos", 60, "Billionaire", keywords0, Gender.MALE));

        List<String> keywords1 = new ArrayList<>();
        keywords1.add("money");
        keywords1.add("computers");
        anquetes.add(new Anquete(1 , "Bill Gates", 68, "Billionaire", keywords0, Gender.MALE));


        List<String> keywords2 = new ArrayList<>();
        keywords2.add("money");
        keywords2.add("cosmetics");
        keywords2.add("beauty");
        anquetes.add(new Anquete(2, "Françoise Bettencourt Meyers", 70, "Billionaire", keywords2, Gender.FEMALE));


        return(anquetes);
    }

    List<Anquete> findAnquetesStub(List<Anquete> allAnquetes, String[] requestTags)
    {
        List<Anquete> acceptableAnquetes = new ArrayList<>();

        if(requestTags.length == 0)
        {
            acceptableAnquetes = allAnquetes;
        }
        else
        {
            for(Anquete anquete : allAnquetes)
            {
                List<String> anqueteTags = anquete.getKeywords();
                boolean allpresent = true;
                for(String requestTag : requestTags)
                {
                    boolean present = false;

                    for(String anqueteTag : anqueteTags)
                    {
                        if(anqueteTag.equals(requestTag)) { present = true; break;}
                    }

                    if(present == false) { allpresent = false; break;}
                }
                if(allpresent == true) { acceptableAnquetes.add(anquete); }
            }
        }

        return(acceptableAnquetes);
    }
}
