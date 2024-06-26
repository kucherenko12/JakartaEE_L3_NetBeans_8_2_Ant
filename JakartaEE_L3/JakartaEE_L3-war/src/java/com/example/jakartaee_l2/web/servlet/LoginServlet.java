package com.example.jakartaee_l2.web.servlet;

import com.example.jakartaee_l2.entities.Account;
import com.example.jakartaee_l2.logic.AccountLogic;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;
import javax.ejb.EJB;

@WebServlet(urlPatterns = {"/loginpost"})
public class LoginServlet extends HttpServlet
{
    @EJB
    private AccountLogic accountLogic;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username: " + username);
        System.out.println("password: " + password);

        // do some processing here...
        //if(LoginLogic.IsUserValid(username, password) == true)
        //if(username.equals("a") && password.equals("a"))
        Optional<Account> accountOptional = accountLogic.findAccount(username, password);
        if(accountOptional.isPresent())
        {
            //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/forwarded");
            //dispatcher.forward(request, response);

            HttpSession session=request.getSession();
            //session.setAttribute("username", username);
            session.setAttribute("id", String.valueOf(accountOptional.get().getId()));

            response.sendRedirect(request.getContextPath() + "/anquetesearch");
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/jsp/invalidlogin.jsp").forward(request, response);
        }
    }
}