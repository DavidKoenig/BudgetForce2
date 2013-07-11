
package budgetforce.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Soi Fon
 */
@XmlRootElement
public class Receipt 
{  
    
    //---------------------------------------------------
    // Get and set functions
    //-------------------------------------------------- 
    @XmlTransient
    public int getID() {
        return m_ID;
    }

    @XmlTransient
    public void setID(int _ID) {
        this.m_ID = _ID;
    }

    @XmlElement(name="path")
    public String getPath() {
        return m_Path;
    }

    @XmlElement(name="path")
    public void setPath(String _Path) {
        this.m_Path = _Path;
    }

    @XmlElement(name="file")
    public String getFilename() {
        return m_Filename;
    }

    @XmlElement(name="file")
    public void setFilename(String _Filename) {
        this.m_Filename = _Filename;
    }

    @XmlElement(name="outgoingID")
    public int getOutgoingID() {
        return m_OutgoingID;
    }

    @XmlElement(name="outgoingID")
    public void setOutgoingID(int _OutgoingID) {
        this.m_OutgoingID = _OutgoingID;
    }

    @XmlElement(name="personID")
    public int getPersonID() {
        return m_PersonID;
    }

    @XmlElement(name="personID")
    public void setPersonID(int _PersonID) {
        this.m_PersonID = _PersonID;
    }
   
    //---------------------------------------------------
    // class Methods
    //---------------------------------------------------     
    @XmlTransient
    public static int NewReceiptID()
    {
        return ++s_ReceiptCount;
    }
    
    @XmlTransient
    public static void SetReceiptCount(int value)
    {
        s_ReceiptCount = value;
    }
    
    //---------------------------------------------------
    // Private variables
    //--------------------------------------------------- 
    private int     m_ID;
    private String  m_Path;
    private String  m_Filename;
    private int     m_OutgoingID;
    private int     m_PersonID;
    
    private static int s_ReceiptCount = 0; 
}
