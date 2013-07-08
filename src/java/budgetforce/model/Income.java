/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.model;
import java.sql.Timestamp;
import java.sql.Date;

import org.joda.time.Period;  //for mapping to postgresql period format 

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kinske
 */
@XmlRootElement
public class Income {
  
    //---------------------------------------------------
    // Get and Set Functions
    //--------------------------------------------------- 
    @XmlTransient
    public int getId() {
        return m_Id;
    }
    
    @XmlTransient
    public void setId(int _Id) {
        this.m_Id = _Id;
    }

    @XmlElement(name="name")
    public String getName() {
        return m_Name;
    }

    @XmlElement(name="name")
    public void setName(String _Name) {
        this.m_Name = _Name;
    }

    @XmlElement(name="amount")
    public float getAmount() {
        return m_Amount;
    }

    @XmlElement(name="amount")
    public void setAmount(float _Amount) {
        this.m_Amount = _Amount;
    }

    @XmlElement(name="period")
    public Period getPeriod() {
        return m_Period;
    }

    @XmlElement(name="period")
    public void setPeriod(Period _Period) {
        this.m_Period = _Period;
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
    public Timestamp getTimestamp() {
        return m_Timestamp;
    }

    @XmlElement(name="timestamp")
    public void setTimestamp(Timestamp _Timestamp) {
        this.m_Timestamp = _Timestamp;
    }

    @XmlElement(name="personid")
    public int getPersonID() {
        return m_PersonID;
    }

    @XmlElement(name="personid")
    public void setPersonID(int _PersonID) {
        this.m_PersonID = _PersonID;
    }

    @XmlElement(name="incomeid")
    public int getIncomeID() {
        return m_IncomeID;
    }

    @XmlElement(name="incomeid")
    public void setIncomeID(int _IncomeID) {
        this.m_IncomeID = _IncomeID;
    }
    
    //---------------------------------------------------
    // Private variables
    //--------------------------------------------------- 
    private int             m_Id;
    private String          m_Name;
    private float           m_Amount;
    private Period          m_Period;
    private Timestamp       m_Start;
    private Timestamp       m_End;
    private Timestamp       m_Timestamp;
    private int             m_PersonID;
    private int             m_IncomeID;
}