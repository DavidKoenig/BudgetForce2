/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.model;
import java.sql.Date;

/**
 *
 * @author kinske
 */
public class Income {
  
    //---------------------------------------------------
    // Get and Set Functions
    //--------------------------------------------------- 
    public int getId() {
        return m_Id;
    }

    public void setId(int _Id) {
        this.m_Id = _Id;
    }

    public String getName() {
        return m_Name;
    }

    public void setName(String _Name) {
        this.m_Name = _Name;
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

    public Date getTimestamp() {
        return m_Timestamp;
    }

    public void setTimestamp(Date _Timestamp) {
        this.m_Timestamp = _Timestamp;
    }

    public int getPersonID() {
        return m_PersonID;
    }

    public void setPersonID(int _PersonID) {
        this.m_PersonID = _PersonID;
    }

    public int getIncomeID() {
        return m_IncomeID;
    }

    public void setIncomeID(int _IncomeID) {
        this.m_IncomeID = _IncomeID;
    }
    
    //---------------------------------------------------
    // Private variables
    //--------------------------------------------------- 
    private int     m_Id;
    private String  m_Name;
    private float   m_Amount;
    private String  m_Period;
    private Date    m_Start;
    private Date    m_End;
    private Date    m_Timestamp;
    private int     m_PersonID;
    private int     m_IncomeID;    
}