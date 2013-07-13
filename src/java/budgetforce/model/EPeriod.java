/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.model;

/**
 *
 * @author kinske
 */
public enum EPeriod {
    ONCE,
    HOUR,
    DAY,
    WEEK,
    MONTH,
    QUARTER,
    YEAR;
    //UNKNOWN;
    
    /*
    public static EPeriod fromString(String value) {
        for (EPeriod period : values()) {
            if (period.name().equalsIgnoreCase(value)) {
                return period;
            }
        }

        return UNKNOWN;
    }
    * */
    
}
