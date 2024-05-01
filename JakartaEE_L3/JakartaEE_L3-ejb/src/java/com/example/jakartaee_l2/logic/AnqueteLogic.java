package com.example.jakartaee_l2.logic;

import com.example.jakartaee_l2.dao.AnqueteDAO;
import com.example.jakartaee_l2.dao.AnqueteDAOStub;
import com.example.jakartaee_l2.entities.Anquete;
import com.example.jakartaee_l2.entities.Gender;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class AnqueteLogic
{
    public List<Anquete> findAnquetes(String[] tags)
    {
        AnqueteDAO anqueteDAO = new AnqueteDAOStub();
        List<Anquete> anquetes = anqueteDAO.findAnquetes(tags);

        return(anquetes);
    }

    public Optional<Anquete> findAnquete(int id)
    {
        AnqueteDAO anqueteDAO = new AnqueteDAOStub();
        Optional<Anquete> anqueteOptional = anqueteDAO.findAnquete(id);

        return(anqueteOptional);
    }

    public Optional<Anquete> editAnquete(int id, Anquete anquete)
    {
        AnqueteDAO anqueteDAO = new AnqueteDAOStub();

        return(null);
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

    private static String[] stringToArray(String anquetesString)
    {
        String[] anquetes = anquetesString.split(" ");
        return(anquetes);
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
        anquetes.add(new Anquete(3, "Françoise Bettencourt Meyers", 70, "Billionaire", keywords2, Gender.FEMALE));


        return(anquetes);
    }
}
