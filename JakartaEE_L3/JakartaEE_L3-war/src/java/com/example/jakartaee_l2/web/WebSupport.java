package com.example.jakartaee_l2.web;

import com.example.jakartaee_l2.entities.Anquete;
import com.example.jakartaee_l2.entities.Gender;
import com.example.jakartaee_l2.logic.AnqueteLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class WebSupport
{
    public static Optional<Anquete> findAnqueteSupport
            (Optional<String> idStringOptional, AnqueteLogic anqueteLogic)
    {
        if(idStringOptional.isPresent() == true)
        {
            try
            {
                return(anqueteLogic.findAnquete(Integer.valueOf(idStringOptional.get())));
            }
            catch (Exception exception)
            {
                //exception.printStackTrace();
                return(Optional.empty());
            }
        }
        else
        {
            return(Optional.empty());
        }
    }

    public static String[] findAnquetesSupport(Optional<String> tagsStringOptional)
    {
        String[] tags;
        if(tagsStringOptional.isPresent() == true && tagsStringOptional.get().equals(""))
        {
            tags = new String[] {};
        }
        else if(tagsStringOptional.isPresent() == true)
        {
            tags = stringToArray(tagsStringOptional.get().trim());
        }
        else
        {
            tags = new String[] {};
        }
        return(tags);
    }

    public static void ChangeAnquete
            (AnqueteLogic anqueteLogic, String idString, String name, String ageString,
             String shortInfo, String keywordsString, String genderString)
    {
        int id  = Integer.parseInt(idString);
        int age = Integer.parseInt(ageString);
        List<String> keywords = Arrays.asList(stringToArray(keywordsString));
        Gender gender = Gender.valueOf(genderString);
        Anquete anquete = new Anquete(id, name, age, shortInfo, keywords, gender);

        anqueteLogic.editAnquete(id, anquete);
    }

    public static boolean checkIfLoggedIn(HttpServletRequest request)
    {
        if(request.getSession().getAttribute("id") != null) { return(true); }
        else { return(false); }
    }

    public static String[] stringToArray(String anquetesString)
    {
        String[] anquetes = anquetesString.split(" ");
        return(anquetes);
    }
}
