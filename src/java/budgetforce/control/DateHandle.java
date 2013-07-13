/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.control;

import budgetforce.model.EPeriod;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.joda.time.Interval;

/**
 *
 * @author Soi Fon
 */
public class DateHandle 
{

    static Calendar c;
      
    static GregorianCalendar greg;
    
    public static void Initialize()
    {
        c = Calendar.getInstance();
        greg = new GregorianCalendar();
    }
    
    public static boolean TimeStampIntersectsCurrentDate(Timestamp start, Timestamp end, EPeriod period)
    {
        boolean intersect = false;
        
        int day   = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year  = c.get(Calendar.YEAR);
        
        
        if(start.getYear() == year)
        {
            //period starts before and ends after this month
            if(start.getMonth() < month && end.getMonth() > month)
            {
                
            }
            //Period ends this month
            if(start.getMonth() < month && end.getMonth() == month)
            {
                
            }
            //Period starts this month
            if(start.getMonth() == month && end.getMonth() > month)
            {
                
            }
            //Period starts and ends this month
            if(start.getMonth() == month && end.getMonth() == month)
            {
                
            }            
        }
       
        
        switch(period)
        {
            case DAY    :  break;
            case WEEK   :  break;
            case MONTH  :  break;
            case QUARTER:  break;
            case YEAR   :  break;
        }
        
        
        return intersect;   
    }
    
    /**
     * gets the amount of days of a specific month
     * @param year needet to proof is february could be 29 days in a leap year
     * @param month
     * @return returns -1 by uncorrect input parameters
     */
    public static int GetDaysOfMonth(int year, int month)
    {
        switch(month)
        {
            case  0: return 31;
            case  1: return greg.isLeapYear(year) ? 29 : 28;                
            case  2: return 31;
            case  3: return 30;
            case  4: return 31;
            case  5: return 30;
            case  6: return 31;
            case  7: return 31;
            case  8: return 30;
            case  9: return 31;
            case 10: return 30;
            case 11: return 31;           
        }
        return -1;   
    }
    
}
