package com.example.jakartaee_l2.web.servlet;

import com.example.jakartaee_l2.dao.AnqueteDAO;
import com.example.jakartaee_l2.dao.AnqueteDAOStub;
import com.example.jakartaee_l2.entities.Anquete;
import com.example.jakartaee_l2.logic.AnqueteLogic;
import com.example.jakartaee_l2.web.EJBTest;
import com.example.jakartaee_l2.web.WebSupport;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = {"/anquetesearch"})
public class AnqueteSearchPageServlet extends HttpServlet
{
    @EJB
    private AnqueteLogic anqueteLogic;

    @EJB
    private EJBTest ejbTest;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //response.setContentType("text/html;charset=UTF-8");
        if(WebSupport.checkIfLoggedIn(request))
        {
            System.out.println(ejbTest.test());
            Optional<String> tagsStringOptional = Optional.ofNullable(request.getParameter("tags"));
            //AnqueteLogic anqueteLogic;
            List<Anquete> anquetes = anqueteLogic.findAnquetes(WebSupport.findAnquetesSupport(tagsStringOptional));

            request.setAttribute("anquetes", anquetes);

            request.getRequestDispatcher("/WEB-INF/jsp/anquetesearch.jsp").forward(request, response);
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/jsp/notloggedin.jsp").forward(request, response);
        }
    }
}
