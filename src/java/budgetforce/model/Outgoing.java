/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author David
 */
@XmlRootElement
public class Outgoing {

    //---------------------------------------------------
    // Get and set functions
    //---------------------------------------------------
    @XmlTransient
    public int getId() {
        return m_Id;
    }
    
    @XmlTransient
    public void setId(int _Id) {
        this.m_Id = _Id;
    }

    @XmlElement(name="amount")
    public float getAmount() {
        return m_Amount;
    }

    @XmlElement(name="amount")
    public void setAmount(float _Amount) {
        this.m_Amount = _Amount;
    }

    @XmlElement(name="start")
    public Date getStart() {
        return m_Start;
    }

    @XmlElement(name="start")
    public void setStart(Date _Start) {
        this.m_Start = _Start;
    }

    @XmlElement(name="end")
    public Date getEnd() {
        return m_End;
    }

    @XmlElement(name="end")
    public void setEnd(Date _End) {
        this.m_End = _End;
    }

    @XmlElement(name="timestamp")
    public Date getTimeStamp() {
        return m_TimeStamp;
    }

    @XmlElement(name="timestamp")
    public void setTimeStamp(Date _TimeStamp) {
        this.m_TimeStamp = _TimeStamp;
    }

    @XmlElement(name="budgetid")
    public int getBudgetId() {
        return m_BudgetId;
    }

    @XmlElement(name="budgetid")
    public void setBudgetId(int _BudgetId) {
        this.m_BudgetId = _BudgetId;
    }

    @XmlElement(name="categoryid")
    public int getCategoryId() {
        return m_CategoryId;
    }

    @XmlElement(name="categoryid")
    public void setCategoryId(int _CategoryId) {
        this.m_CategoryId = _CategoryId;
    }
    
    @XmlElement(name="periodid")
    public int getPeriodId() {
        return this.m_PeriodId;
    }
    
    @XmlElement(name="periodid")
    public void setPeriodId(int _PeriodId) {
        this.m_PeriodId = _PeriodId;
    }
   
    //---------------------------------------------------
    // Private variables
    //---------------------------------------------------
    private int             m_Id;
    private float           m_Amount;
    private Date            m_Start;
    private Date            m_End;
    private Date            m_TimeStamp;
    private int             m_BudgetId;
    private int             m_CategoryId;
    private int             m_PeriodId;
}