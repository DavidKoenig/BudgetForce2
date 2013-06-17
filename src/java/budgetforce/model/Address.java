/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;

/**
 *
 * @author David
 */
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
    public int getId() {
        return m_Id;
    }

    public void setId(int _Id) {
        this.m_Id = _Id;
    }

    public String getStreetNmbr() {
        return m_StreetNmbr;
    }

    public void setStreetNmbr(String _StreetNmbr) {
        this.m_StreetNmbr = _StreetNmbr;
    }

    public String getCity() {
        return m_City;
    }

    public void setCity(String _City) {
        this.m_City = _City;
    }

    public String getZipCode() {
        return m_ZipCode;
    }

    public void setZipCode(String _ZipCode) {
        this.m_ZipCode = _ZipCode;
    }

    public String getCountry() {
        return m_Country;
    }

    public void setCountry(String _Country) {
        this.m_Country = _Country;
    }

    public String getEmail() {
        return m_Email;
    }

    public void setEmail(String _Email) {
        this.m_Email = _Email;
    }

    public String getPhone1() {
        return m_Phone1;
    }

    public void setPhone1(String _Phone1) {
        this.m_Phone1 = _Phone1;
    }

    public String getPhone2() {
        return m_Phone2;
    }

    public void setPhone2(String _Phone2) {
        this.m_Phone2 = _Phone2;
    }

    public String getAddressAddition() {
        return m_AddressAddition;
    }

    public void setAddressAddition(String _AddressAddition) {
        this.m_AddressAddition = _AddressAddition;
    }

    public EAddressType getType() {
        return m_Type;
    }

    public void setType(EAddressType _Type) {
        this.m_Type = _Type;
    }

    public int getPersondId() {
        return m_PersondId;
    }

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
    private String          m_Email;
    private String          m_Phone1;
    private String          m_Phone2;
    private String          m_AddressAddition;
    private EAddressType    m_Type;
    private int             m_PersondId;
    
}