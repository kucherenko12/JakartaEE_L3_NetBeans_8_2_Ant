package com.example.jakartaee_l2.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/logoutpost"})
public class LogOutServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        System.out.println("session");
        HttpSession session=request.getSession();

        //session.invalidate();
        //System.out.println("session invalidated, redirected");
        //=======================================================
        if(session.getAttribute("id") != null)
        {
            session.removeAttribute("id");
        }

        response.sendRedirect(request.getContextPath() + "/");
    }
}
