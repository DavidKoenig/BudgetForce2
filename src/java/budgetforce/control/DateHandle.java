
package budgetforce.control;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Soi Fon
 */
public class DateHandle 
{

    public static Calendar c;
      
    public static GregorianCalendar greg;
    
    public static void Initialize()
    {
        c = Calendar.getInstance();
        greg = new GregorianCalendar();
    }
    
    public static int Compare(Timestamp t1, Timestamp t2)
    {
        return Compare(t1, t2.getYear(),t2.getMonth(), t2.getDate());
    }
    
    public static int Compare(Timestamp t, int year)
    {
        return Compare(t, year, t.getMonth(), t.getDate());
    }
    
    public static int Compare(Timestamp t, int year, int month)
    {
        return Compare(t, year, month, t.getDate());
    }            
    
    public static int Compare(Timestamp t, int year, int month, int day)
    {
        year -= 1900;
        
        if(t.getYear() < year)
        {
            return -1;
        }
        else 
        {
            if(t.getYear() > year)
            {
                return 1;
            }
        }
        
        if(t.getMonth() < month)
        {
            return -1;
        }
        else 
        {
            if(t.getMonth() > month)
            {
                return 1;
            }
        }
    
        if(t.getDate() < day)
        {
            return -1;
        }
        else 
        {
            if(t.getDate() > day)
            {
                return 1;
            }
        } 
        
        return 0;
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
