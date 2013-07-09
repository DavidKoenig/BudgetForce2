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
public class Category {

    //---------------------------------------------------
    // Get and set functions
    //---------------------------------------------------
    @XmlTransient
    public int getId() {
        return m_Id;
    }

    @XmlTransient
    public void setId(int m_Id) {
        this.m_Id = m_Id;
    }

    @XmlElement(name="name")
    public String getName() {
        return m_Name;
    }

    @XmlElement(name="name")
    public void setName(String m_Name) {
        this.m_Name = m_Name;
    }

    //---------------------------------------------------
    // Private variables
    //--------------------------------------------------- 
    private int     m_Id;
    private String  m_Name;
}