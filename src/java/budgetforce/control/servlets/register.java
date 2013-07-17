package budgetforce.control.servlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
*/ 



import budgetforce.control.Budget;
import budgetforce.control.Income;
import budgetforce.control.Outgoing;
import budgetforce.model.DatabaseManager;
import budgetforce.model.Login;
import budgetforce.model.Person;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author Soi Fon
*/
@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            Income i = new Income(20);
            Outgoing o = new Outgoing(20);
            Budget b = new Budget(20);
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Income:   " +i.MonthIncome(2013, 6)); 
            out.println("<br>");
            out.println("Budget:   " + b.MonthBudget()); 
            out.println("<br>");
            out.println("Outgoing: " + o.MonthOutgoing(2013, 6));
            out.println("</body>");
            out.println("</html>");
        } 
        finally 
        {            
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
        processRequest(request, response);  
    }

    @Override
    public String getServletInfo() 
    {
        return "Registers a new User at this page";
    }
}
