package budgetforce.unused;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
*/

import budgetforce.model.DatabaseManager;
import budgetforce.model.login.Login;


import java.io.IOException;
import java.io.PrintWriter;
import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Soi Fon
*/

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {        
        
        Login login = DatabaseManager.getDatabaseManager().getLoginByUsername(request.getParameter("username"));
        
        HttpSession session = request.getSession();
        SessionLogin sessionLogin = new SessionLogin();
        
        if(login.getPassword().equals(request.getParameter("password")))
        {
            sessionLogin.loggedIn = true;
            session.setAttribute("loggedIn", sessionLogin);
            session.setAttribute("username", login.getUsername());
        }
        else
        {
            sessionLogin.loggedIn = false;
            session.setAttribute("loggedIn", sessionLogin);
        }
        
        //redirect to mainpage
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Logs a new user in";
    }
}

