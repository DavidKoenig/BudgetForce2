
package budgetforce.control;

import budgetforce.model.DatabaseManager;
import static budgetforce.model.EPeriod.DAY;
import static budgetforce.model.EPeriod.MONTH;
import static budgetforce.model.EPeriod.ONCE;
import static budgetforce.model.EPeriod.QUARTER;
import static budgetforce.model.EPeriod.WEEK;
import static budgetforce.model.EPeriod.YEAR;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Soi Fon
 */
public class Outgoing 
{
    public Outgoing(int personID)
    {
        modelOutgoing = new ArrayList<budgetforce.model.Outgoing>();
        //this s**t wouldn´t happening if we had a personID in Outgoing =D
        ArrayList<budgetforce.model.Budget> budgets = DatabaseManager.getDatabaseManager().getBudgetByPersonID(personID);
        for (budgetforce.model.Budget budget : budgets) 
        {
            ArrayList<budgetforce.model.Outgoing> temp = DatabaseManager.getDatabaseManager().getOutgoingByBudgetID(budget.getId());
            if(!temp.isEmpty())
            {
                modelOutgoing.addAll(temp);
            }
        }
    }
    
    public float MonthOutgoing(int year, int month)
    { 
        float completteOutgoings = 0.0f;
        
        for (budgetforce.model.Outgoing outgoing : modelOutgoing) 
        {
            Timestamp start = outgoing.getStart();
            Timestamp end   = outgoing.getEnd();
            
            System.err.println("ID: " + outgoing.getId() + " Amount: " + outgoing.getAmount() + " BudgetID: " + outgoing.getBudgetId() + " PeriodID: " + outgoing.getPeriod());

            //period starts before and ends after this month
            if(DateHandle.Compare(start, year, month) == -1 && 
               DateHandle.Compare(end, year, month) == 1)
            {
                switch(outgoing.getPeriod())
                {
                    case DAY    : completteOutgoings += outgoing.getAmount() *  DateHandle.GetDaysOfMonth(year, month);     break;
                    case WEEK   : completteOutgoings += outgoing.getAmount() * (DateHandle.GetDaysOfMonth(year, month) / 7);break;
                    case MONTH  : completteOutgoings += outgoing.getAmount();     break;
                    case QUARTER: completteOutgoings += outgoing.getAmount() / 3; break;
                    case YEAR   : completteOutgoings += outgoing.getAmount() / 12;break;
                }  
                
                continue;
            }
            //Period ends this month
            if(DateHandle.Compare(start, year, month) == -1 && 
               DateHandle.Compare(end, year, month) == 0)
            {
                float days = end.getDate() + 1;
                switch(outgoing.getPeriod())
                {
                    case DAY    : completteOutgoings +=  outgoing.getAmount() *        days;     break;
                    case WEEK   : completteOutgoings +=  outgoing.getAmount() *       (days / 7);break;
                    case MONTH  : completteOutgoings +=  outgoing.getAmount() *       (days / DateHandle.GetDaysOfMonth(year, month));break;
                    case QUARTER: completteOutgoings += (outgoing.getAmount() /  3) * (days / DateHandle.GetDaysOfMonth(year, month));break;
                    case YEAR   : completteOutgoings += (outgoing.getAmount() / 12) * (days / DateHandle.GetDaysOfMonth(year, month));break;
                }   
                
                continue;
            }
            //Period starts this month
            if(DateHandle.Compare(start, year, month) == 0 && 
               DateHandle.Compare(end, year, month) == 1)
            {
                float daysLeft = (DateHandle.GetDaysOfMonth(year, month) - start.getDate()) + 1;   
                switch(outgoing.getPeriod())
                {
                    case DAY    : completteOutgoings +=  outgoing.getAmount() *        daysLeft;     break;
                    case WEEK   : completteOutgoings +=  outgoing.getAmount() *       (daysLeft / 7);break;
                    case MONTH  : completteOutgoings +=  outgoing.getAmount() *       (daysLeft / DateHandle.GetDaysOfMonth(year, month));break;
                    case QUARTER: completteOutgoings += (outgoing.getAmount() /  3) * (daysLeft / DateHandle.GetDaysOfMonth(year, month));break;
                    case YEAR   : completteOutgoings += (outgoing.getAmount() / 12) * (daysLeft / DateHandle.GetDaysOfMonth(year, month));break;
                }   
                
                continue;
            }
            //Period starts and ends this month
            if(DateHandle.Compare(start, year, month) == 0 && 
               DateHandle.Compare(end, year, month) == 0)
            {
                float days = end.getDate() - start.getDate() + 1;                    
                switch(outgoing.getPeriod())
                {
                    case ONCE   : completteOutgoings += outgoing.getAmount();             break;
                    case DAY    : completteOutgoings += outgoing.getAmount() *  days;     break;
                    case WEEK   : completteOutgoings += outgoing.getAmount() * (days / 7);break;
                    case MONTH  : completteOutgoings += outgoing.getAmount();break; //there should not be a month , quarter or year period with 
                    case QUARTER: completteOutgoings += outgoing.getAmount();break; //a start and end date within a month anyway, so just the full amount will be
                    case YEAR   : completteOutgoings += outgoing.getAmount();break; //added in this case
                }
                
                continue;
            }        
        }
        return completteOutgoings;
    }
    
    private ArrayList<budgetforce.model.Outgoing> modelOutgoing;   
}
