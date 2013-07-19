
package budgetforce;

import budgetforce.control.DateHandle;
import budgetforce.control.SystemNotification;
import budgetforce.model.DatabaseManager;
import budgetforce.model.Receipt;
import budgetforce.*;
import budgetforce.control.login.LoginTokenController;

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
        DateHandle.Initialize();
        SystemNotification.Initialize();
        
        Receipt.SetReceiptCount(DatabaseManager.getDatabaseManager().getMaxReceiptID());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) 
    {
        
    }
}
