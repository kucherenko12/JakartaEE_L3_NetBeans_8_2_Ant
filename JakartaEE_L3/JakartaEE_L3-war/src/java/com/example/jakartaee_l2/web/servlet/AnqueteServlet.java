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
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = {"/anquete"})
public class AnqueteServlet extends HttpServlet
{
    @EJB
    private AnqueteLogic anqueteLogic;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if(request.getParameter("id") != null)
        {
            Optional<String> idStringOptional = Optional.ofNullable(request.getParameter("id"));
            //AnqueteLogic anqueteLogic = new AnqueteLogic();

            Optional<Anquete> anqueteOptional = WebSupport.findAnqueteSupport(idStringOptional, anqueteLogic);

            if(anqueteOptional.isPresent())
            {
                request.setAttribute("anquete", anqueteOptional.get());
                request.getRequestDispatcher("/WEB-INF/jsp/anquete.jsp").forward(request, response);

            }
            else
            {
                request.getRequestDispatcher("/WEB-INF/jsp/unacceptableanqueteid.jsp").forward(request, response);
            }
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/jsp/unacceptableanqueteid.jsp").forward(request, response);
        }
    }
}
