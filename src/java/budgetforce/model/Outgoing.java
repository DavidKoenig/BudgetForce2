/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;

import java.sql.Timestamp;
import java.sql.Date;

/**
 *
 * @author David
 */
public class Outgoing {

    //---------------------------------------------------
    // Get and set functions
    //---------------------------------------------------
    public int getId() {
        return m_Id;
    }

    public void setId(int _Id) {
        this.m_Id = _Id;
    }

    public float getAmount() {
        return m_Amount;
    }

    public void setAmount(float _Amount) {
        this.m_Amount = _Amount;
    }

    public String getPeriod() {
        return m_Period;
    }

    public void setPeriod(String _Period) {
        this.m_Period = _Period;
    }

    public Timestamp getStart() {
        return m_Start;
    }

    public void setStart(Timestamp _Start) {
        this.m_Start = _Start;
    }

    public Timestamp getEnd() {
        return m_End;
    }

    public void setEnd(Timestamp _End) {
        this.m_End = _End;
    }

    public Timestamp getTimeStamp() {
        return m_TimeStamp;
    }

    public void setTimeStamp(Timestamp _TimeStamp) {
        this.m_TimeStamp = _TimeStamp;
    }

    public int getBudgetId() {
        return m_BudgetId;
    }

    public void setBudgetId(int _BudgetId) {
        this.m_BudgetId = _BudgetId;
    }

    public int getCategoryId() {
        return m_CategoryId;
    }

    public void setCategoryId(int _CategoryId) {
        this.m_CategoryId = _CategoryId;
    } 
   
    //---------------------------------------------------
    // Private variables
    //---------------------------------------------------
    private int             m_Id;
    private float           m_Amount;
    private String          m_Period;
    private Timestamp       m_Start;
    private Timestamp       m_End;
    private Timestamp       m_TimeStamp;
    private int             m_BudgetId;
    private int             m_CategoryId;
}