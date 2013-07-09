/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author David
 */
@XmlRootElement
public class Budget {

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

    @XmlElement(name="name")
    public String getName() {
        return m_Name;
    }

    @XmlElement(name="name")
    public void setName(String _Name) {
        this.m_Name = _Name;
    }

    @XmlElement(name="currency")
    public String getCurrency() {
        return m_Currency;
    }

    @XmlElement(name="currency")
    public void setCurrency(String _Currency) {
        this.m_Currency = _Currency;
    }

    @XmlElement(name="personid")
    public int getPersonId() {
        return m_PersonId;
    }

    @XmlElement(name="personid")
    public void setPersonId(int _PersonId) {
        this.m_PersonId = _PersonId;
    }

    @XmlElement(name="projectid")
    public int getProjectId() {
        return m_ProjectId;
    }

    @XmlElement(name="projectid")
    public void setProjectId(int _ProjectId) {
        this.m_ProjectId = _ProjectId;
    }

    @XmlElement(name="budgetid")
    public int getBudgetId() {
        return m_BudgetId;
    }

    @XmlElement(name="budgetid")
    public void setBudgetId(int _BudgetId) {
        this.m_BudgetId = _BudgetId;
    }

    //---------------------------------------------------
    // Private variables
    //---------------------------------------------------
    private int     m_Id;
    private String  m_Name;
    private String  m_Currency;
    private int     m_PersonId;
    private int     m_ProjectId;
    private int     m_BudgetId;
}