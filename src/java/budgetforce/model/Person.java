/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;

/**
 *
 * @author David
 */
public class Person {
    
    //---------------------------------------------------
    // Get and Set Functions
    //--------------------------------------------------- 
    public int getId() {
        return m_Id;
    }

    public void setId(int _Id) {
        this.m_Id = _Id;
    }

    public String getFirstName() {
        return m_FirstName;
    }

    public void setFirstName(String _FirstName) {
        this.m_FirstName = _FirstName;
    }

    public String getLastName() {
        return m_LastName;
    }

    public void setLastName(String _LastName) {
        this.m_LastName = _LastName;
    }

    public String getM_Email() {
        return m_Email;
    }

    public void setM_Email(String m_Email) {
        this.m_Email = m_Email;
    }

    public String getM_Phone1() {
        return m_Phone1;
    }

    public void setM_Phone1(String m_Phone1) {
        this.m_Phone1 = m_Phone1;
    }

    public String getM_Phone2() {
        return m_Phone2;
    }

    public void setM_Phone2(String m_Phone2) {
        this.m_Phone2 = m_Phone2;
    }

    
    //---------------------------------------------------
    // Private variables
    //---------------------------------------------------
    private int     m_Id;
    private String  m_FirstName;
    private String  m_LastName;
    private String  m_Email;
    private String  m_Phone1;
    private String  m_Phone2;

}