/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.control;

import budgetforce.model.DatabaseManager;
import java.util.ArrayList;

/**
 *
 * @author Soi Fon
 */
public class SystemNotification 
{
    private SystemNotification()
    {
        
    }
    
    public static enum ENotification
    {
        BudgedCreated(0),
        OutgoingCreated(1),
        IncomeCreated(2),
        BudgetCreationFailed(3),
        OutgoingCreationFailed(4),
        IncomeCreationFailed(5),
        BudgetExeeded(6),
        BudgetExeedsIncome(7),
        BudetAlmostExeeded(8);
        
        private int code;
 
        private ENotification(int i) 
        {
          code = i;
        }

        public int value() 
        {
            return code;
        }
    }
    
    public static void Initialize()
    {
        systemNotifications = DatabaseManager.getDatabaseManager().getSystemNotifications();
    }            
    
    public static String Get(ENotification e)
    {
        switch(e)
        {
            case BudgedCreated          : return systemNotifications.get(e.value()).getMessage();
            case OutgoingCreated        : return systemNotifications.get(e.value()).getMessage();
            case IncomeCreated          : return systemNotifications.get(e.value()).getMessage();
            case BudgetCreationFailed   : return systemNotifications.get(e.value()).getMessage();
            case OutgoingCreationFailed : return systemNotifications.get(e.value()).getMessage();
            case BudgetExeeded          : return systemNotifications.get(e.value()).getMessage();
            case BudgetExeedsIncome     : return systemNotifications.get(e.value()).getMessage();
            case BudetAlmostExeeded     : return systemNotifications.get(e.value()).getMessage();
        }
        
        return null;
    }
    
    private static ArrayList<budgetforce.model.SystemNotification> systemNotifications;
}
