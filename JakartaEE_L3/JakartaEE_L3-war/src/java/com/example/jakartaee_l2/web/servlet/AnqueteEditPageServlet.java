package com.example.jakartaee_l2.web.servlet;

import com.example.jakartaee_l2.entities.Anquete;
import com.example.jakartaee_l2.logic.AnqueteLogic;
import com.example.jakartaee_l2.web.WebSupport;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = {"/anqueteedit"})
public class AnqueteEditPageServlet extends HttpServlet
{
    @EJB
    private AnqueteLogic anqueteLogic;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if(WebSupport.checkIfLoggedIn(request))
        {
            //AnqueteLogic anqueteLogic = new AnqueteLogic();
            Optional<Anquete> anqueteOptional = WebSupport.findAnqueteSupport
                    (Optional.of((String)request.getSession().getAttribute("id")), anqueteLogic);


            request.setAttribute("anquete", anqueteOptional.get());
            request.getRequestDispatcher("/WEB-INF/jsp/anqueteedit.jsp").forward(request, response);
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/jsp/notloggedin.jsp").forward(request, response);
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // do some processing here...
        //if(LoginLogic.IsUserValid(username, password) == true)
        if(WebSupport.checkIfLoggedIn(request))
        {
            // read form fields
            String idString = (String) request.getSession().getAttribute("id");
            String name = request.getParameter("name");
            String ageString = request.getParameter("age");
            String shortInfo = request.getParameter("shortInfo");
            String keywordsString = request.getParameter("keywords");
            String genderString = request.getParameter("gender");


            //AnqueteLogic anqueteLogic = new AnqueteLogic();
            WebSupport.ChangeAnquete
                    (anqueteLogic, idString,  name, ageString, shortInfo, keywordsString, genderString);

            response.sendRedirect(request.getContextPath() + "/anquetesearch");
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/jsp/notloggedin.jsp").forward(request, response);
        }
    }
}
