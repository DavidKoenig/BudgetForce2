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
public class Tax {

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

    @XmlElement(name="type")
    public String getType() {
        return m_Type;
    }
    
    @XmlElement(name="type")
    public void setType(String _Type) {
        this.m_Type = _Type;
    }

    @XmlElement(name="systemflag")
    public boolean isSystemFlag() {
        return m_SystemFlag;
    }

    @XmlElement(name="systemflag")
    public void setSystemFlag(boolean _SystemFlag) {
        this.m_SystemFlag = _SystemFlag;
    }

    //---------------------------------------------------
    // Private variables
    //---------------------------------------------------
    private int     m_Id;
    private float   m_Amount;
    private String  m_Type;
    private boolean m_SystemFlag;
}