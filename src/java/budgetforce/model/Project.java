
package budgetforce.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author David
 */
@XmlRootElement
public class Project {

    //---------------------------------------------------
    // Get and set functions
    //--------------------------------------------------
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

    //---------------------------------------------------
    // Private variables
    //--------------------------------------------------- 
    private int     m_Id;
    private String  m_Name;
}