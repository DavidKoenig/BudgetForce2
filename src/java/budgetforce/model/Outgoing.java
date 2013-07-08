/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;
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

    public Date getStart() {
        return m_Start;
    }

    public void setStart(Date _Start) {
        this.m_Start = _Start;
    }

    public Date getEnd() {
        return m_End;
    }

    public void setEnd(Date _End) {
        this.m_End = _End;
    }

    public Date getTimeStamp() {
        return m_TimeStamp;
    }

    public void setTimeStamp(Date _TimeStamp) {
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
    private int     m_Id;
    private float   m_Amount;
    private String  m_Period;
    private Date    m_Start;
    private Date    m_End;
    private Date    m_TimeStamp;
    private int     m_BudgetId;
    private int     m_CategoryId;
}