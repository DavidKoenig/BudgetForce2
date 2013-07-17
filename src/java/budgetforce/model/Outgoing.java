/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;

import java.sql.Timestamp;

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
    public Timestamp getStart() {
        return m_Start;
    }

    @XmlElement(name="start")
    public void setStart(Timestamp _Start) {
        this.m_Start = _Start;
    }

    @XmlElement(name="end")
    public Timestamp getEnd() {
        return m_End;
    }

    @XmlElement(name="end")
    public void setEnd(Timestamp _End) {
        this.m_End = _End;
    }

    @XmlElement(name="timestamp")
    public Timestamp getTimeStamp() {
        return m_TimeStamp;
    }

    @XmlElement(name="timestamp")
    public void setTimeStamp(Timestamp _TimeStamp) {
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
    
    @XmlElement(name="period")
    public EPeriod getPeriod() {
        return this.m_Period;
    }
    
    @XmlElement(name="period")
    public void setPeriod(EPeriod _Period) {
        this.m_Period = _Period;
    }
    
    @XmlElement(name="personid")
    public int getPersonId() {
        return this.m_PersonId;
    }
    
    @XmlElement(name="personid")
    public void setPersonId(int _PersonId) {
        this.m_PersonId = _PersonId;
    }
   
    //---------------------------------------------------
    // Private variables
    //---------------------------------------------------
    private int             m_Id;
    private float           m_Amount;
    private Timestamp       m_Start;
    private Timestamp       m_End;
    private Timestamp       m_TimeStamp;
    private int             m_BudgetId;
    private int             m_CategoryId;
    private EPeriod         m_Period;
    private int             m_PersonId;
}