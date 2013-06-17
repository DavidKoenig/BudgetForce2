/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;

/**
 *
 * @author David
 */
public class Budget {

    //---------------------------------------------------
    // Get and set functions
    //--------------------------------------------------
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

    public String getCurrency() {
        return m_Currency;
    }

    public void setCurrency(String _Currency) {
        this.m_Currency = _Currency;
    }

    public int getPersonId() {
        return m_PersonId;
    }

    public void setPersonId(int _PersonId) {
        this.m_PersonId = _PersonId;
    }

    public int getProjectId() {
        return m_ProjectId;
    }

    public void setProjectId(int _ProjectId) {
        this.m_ProjectId = _ProjectId;
    }

    public int getBudgetId() {
        return m_BudgetId;
    }

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