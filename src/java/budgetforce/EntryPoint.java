/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce;

import budgetforce.model.DatabaseManager;
import budgetforce.model.Receipt;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author Soi Fon
 */
@WebListener()
public class EntryPoint implements ServletContextListener 
{
    @Override
    public void contextInitialized(ServletContextEvent sce) 
    {
        Receipt.SetReceiptCount(DatabaseManager.getDatabaseManager().getMaxReceiptID());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) 
    {
        
    }
}
