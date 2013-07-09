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
public class Address {
    
    //---------------------------------------------------
    // Enum for describing type of address
    //---------------------------------------------------  
    public static enum EAddressType {
        COMPANY,
        PRIVATE,
        BILLING,
        ADDITIONAL
    }
    
    
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

    @XmlElement(name="streetnmbr")
    public String getStreetNmbr() {
        return m_StreetNmbr;
    }

    @XmlElement(name="streetnmbr")
    public void setStreetNmbr(String _StreetNmbr) {
        this.m_StreetNmbr = _StreetNmbr;
    }

    @XmlElement(name="city")
    public String getCity() {
        return m_City;
    }

    @XmlElement(name="city")
    public void setCity(String _City) {
        this.m_City = _City;
    }

    @XmlElement(name="zipcode")
    public String getZipCode() {
        return m_ZipCode;
    }

    @XmlElement(name="zipcode")
    public void setZipCode(String _ZipCode) {
        this.m_ZipCode = _ZipCode;
    }

    @XmlElement(name="country")
    public String getCountry() {
        return m_Country;
    }

    @XmlElement(name="country")
    public void setCountry(String _Country) {
        this.m_Country = _Country;
    }

    @XmlElement(name="addition")
    public String getAddressAddition() {
        return m_AddressAddition;
    }

    @XmlElement(name="addition")
    public void setAddressAddition(String _AddressAddition) {
        this.m_AddressAddition = _AddressAddition;
    }

    @XmlElement(name="type")
    public EAddressType getType() {
        return m_Type;
    }

    @XmlElement(name="type")
    public void setType(EAddressType _Type) {
        this.m_Type = _Type;
    }

    @XmlElement(name="personid")
    public int getPersondId() {
        return m_PersondId;
    }

    @XmlElement(name="personid")
    public void setPersondId(int _PersondId) {
        this.m_PersondId = _PersondId;
    }
    
    //---------------------------------------------------
    // Private variables
    //---------------------------------------------------  
    private int             m_Id;
    private String          m_StreetNmbr;
    private String          m_City;
    private String          m_ZipCode;
    private String          m_Country;
    private String          m_AddressAddition;
    private EAddressType    m_Type;
    private int             m_PersondId;
    
}