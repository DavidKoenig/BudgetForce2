
package budgetforce.control.statistics;

import java.util.Iterator;

import budgetforce.model.DatabaseManager;
import budgetforce.model.statistics.StatisticOutgoingCategory;
import budgetforce.model.Outgoing;

/**
 *
 * @author David
 */
public class StatisticOutgoingCategoryController 
{
    public StatisticOutgoingCategoryController()
    {
    }
    
    public static StatisticOutgoingCategory getStatistic(Integer _CategoryId)
    {
        StatisticOutgoingCategory Statistic = new StatisticOutgoingCategory();
        
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
        
        
        return Statistic;
    }
    
}