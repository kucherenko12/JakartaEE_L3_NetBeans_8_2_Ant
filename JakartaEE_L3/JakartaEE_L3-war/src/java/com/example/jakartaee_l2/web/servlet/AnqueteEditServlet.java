package com.example.jakartaee_l2.web.servlet;

import com.example.jakartaee_l2.entities.Anquete;
import com.example.jakartaee_l2.entities.Gender;
import com.example.jakartaee_l2.logic.AnqueteLogic;
import com.example.jakartaee_l2.web.WebSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;

@WebServlet(urlPatterns = {"/anqueteeditpost"})
public class AnqueteEditServlet extends HttpServlet
{
    @EJB
    private AnqueteLogic anqueteLogic;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if(WebSupport.checkIfLoggedIn(request))
        {
            int id = Integer.valueOf(((String)request.getSession().getAttribute("id")).trim()) ;
            String name = request.getParameter("name").trim();
            int age = Integer.valueOf(((String)request.getParameter("age")).trim());
            String shortinfo = request.getParameter("shortinfo");
            List<String> tags = Arrays.asList(WebSupport.stringToArray((request.getParameter("tags")).trim()));
            Gender gender = Gender.valueOf((request.getParameter("gender")).trim());
        
            Anquete anquete = new Anquete(id, name, age, shortinfo, tags, gender);
            anqueteLogic.editAnquete(id, anquete);

            //AnqueteLogic anqueteLogic = new AnqueteLogic();
            //List<Anquete> anquetes = anqueteLogic.findAnquetes(tags);
            //request.setAttribute("anquetes", anquetes);

            request.getRequestDispatcher("/anquetesearch").forward(request, response);
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/jsp/notloggedin.jsp").forward(request, response);
        }
    }
}
