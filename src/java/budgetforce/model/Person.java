/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author David
 */
@XmlRootElement
public class Person {
    
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

    @XmlElement(name="firstname")
    public String getFirstName() {
        return m_FirstName;
    }

    @XmlElement(name="firstname")
    public void setFirstName(String _FirstName) {
        this.m_FirstName = _FirstName;
    }

    @XmlElement(name="lastname")
    public String getLastName() {
        return m_LastName;
    }

    @XmlElement(name="lastname")
    public void setLastName(String _LastName) {
        this.m_LastName = _LastName;
    }

    @XmlElement(name="email")
    public String getEmail() {
        return m_Email;
    }

    @XmlElement(name="email")
    public void setEmail(String m_Email) {
        this.m_Email = m_Email;
    }

    @XmlElement(name="phone1")
    public String getPhone1() {
        return m_Phone1;
    }

    @XmlElement(name="phone1")
    public void setPhone1(String m_Phone1) {
        this.m_Phone1 = m_Phone1;
    }

    @XmlElement(name="phone2")
    public String getPhone2() {
        return m_Phone2;
    }

    @XmlElement(name="phone2")
    public void setPhone2(String m_Phone2) {
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