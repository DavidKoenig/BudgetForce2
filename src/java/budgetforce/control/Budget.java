
package budgetforce.control;

import budgetforce.model.DatabaseManager;
import java.util.ArrayList;

/**
 *
 * @author Soi Fon
 */
public class Budget 
{
    public Budget(int PersonID)
    {
        modelBudget = DatabaseManager.getDatabaseManager().getBudgetByPersonID(PersonID);
    }
    
    public float MonthBudget()
    {
        float entireBudget = 0.0f;
        for (budgetforce.model.Budget budget : modelBudget) 
        {
            if(budget.getBudgetId() == 0)
            {
                entireBudget += budget.getAmount();
            }
        }
        return entireBudget;
    }
    
    private ArrayList<budgetforce.model.Budget> modelBudget;
}
