
package budgetforce.control.statistics;

import java.util.Iterator;
import java.util.ArrayList;

import budgetforce.model.DatabaseManager;
import budgetforce.model.statistics.StatisticOutgoingCategory;
import budgetforce.model.Outgoing;
import budgetforce.model.Category;

/**
 *
 * @author David
 */
public class StatisticOutgoingCategoryController 
{
    public StatisticOutgoingCategoryController()
    {
    }
    
    public static StatisticOutgoingCategory getStatistic(Integer _CategoryId, Integer _PersonId)
    {
        StatisticOutgoingCategory Statistic = new StatisticOutgoingCategory();
        
        //---------------------------------------------------
        // set PersonId
        Statistic.setUserId(_PersonId);
        //---------------------------------------------------       
        
        //---------------------------------------------------
        // get Category
        Statistic.setCategory(DatabaseManager.getDatabaseManager().getCategoryByIDAndPersonID(_CategoryId.intValue(), _PersonId.intValue()));
        //---------------------------------------------------
        
        //---------------------------------------------------
        // get Outgoings
        Statistic.setOutgoings(DatabaseManager.getDatabaseManager().getOutgoingByCategoryID(_CategoryId));
        //---------------------------------------------------
        
        float Sum   = Statistic.getSum();
        
        Statistic.setStartDate(Statistic.getOutgoings().get(0).getStart());
        Statistic.setEndDate(Statistic.getOutgoings().get(0).getEnd());
        
        for (Outgoing current: Statistic.getOutgoings())
        {
           //---------------------------------------------------
           // calculate sum for statistics
           Sum += current.getAmount();
           
           Statistic.setSum(Sum); 
           //---------------------------------------------------
           
           //---------------------------------------------------
           // calculate start date
            if(current.getStart().compareTo(Statistic.getStartDate()) < 0)
            {
                Statistic.setStartDate(current.getStart());
            }
           //---------------------------------------------------
              
           //---------------------------------------------------
           // calculate end date
            if(current.getEnd().compareTo(Statistic.getEndDate()) > 0)
            {
                Statistic.setEndDate(current.getEnd());
            }
           //---------------------------------------------------
        }
        
        //---------------------------------------------------
        // calculate overall percentage of category
        Statistic.setOverallPercentage(calculateOverallPercentage(Statistic.getSum(), _PersonId));
        //---------------------------------------------------
        
        
        return Statistic;
    }

    //---------------------------------------------------
    // calculate overall percentage of category
    //---------------------------------------------------
    static private float calculateOverallPercentage(float _CategorySum, Integer _PersonId)
    {
        float Sum = 0.0f;
        
        ArrayList<Outgoing> Outgoings = DatabaseManager.getDatabaseManager().getOutgoingByPersonID(_PersonId);

        for (Outgoing CurrentOutgoing : Outgoings)
        {
            Sum += CurrentOutgoing.getAmount();
        }
        
        return 100.0f / Sum * _CategorySum; 
    }
    
}