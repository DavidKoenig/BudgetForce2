
package budgetforce.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author David
 */

@XmlRootElement
public class Login {
    
    //---------------------------------------------------
    // Enum for describing type of login
    //---------------------------------------------------    
    public static enum ELoginType {
        COMPANY,
        PRIVATE
    }
    
    //---------------------------------------------------
    // Get and set functions
    //---------------------------------------------------

    @XmlElement(name="password")
    public String getPassword() {
        return m_Password;
    }

    @XmlElement(name="password")
    public void setPassword(String _Password) {
        this.m_Password = _Password;
    }

    @XmlElement(name="username")
    public String getUsername() {
        return m_Username;
    }

    @XmlElement(name="username")
    public void setUsername(String _Username) {
        this.m_Username = _Username;
    }

    @XmlElement(name="type")
    public ELoginType getType() {
        return m_Type;
    }

    @XmlElement(name="type")
    public void setType(ELoginType _Type) {
        this.m_Type = _Type;
    }

    @XmlElement(name="security_question")
    public String getSecurityQuestion() {
        return m_SecurityQuestion;
    }

    @XmlElement(name="security_question")
    public void setSecurityQuestion(String _SecurityQuestion) {
        this.m_SecurityQuestion = _SecurityQuestion;
    }

    @XmlElement(name="person_id")
    public int getPersondId() {
        return m_PersondId;
    }

    @XmlElement(name="person_id")
    public void setPersondId(int _PersondId) {
        this.m_PersondId = _PersondId;
    }

    @XmlTransient
    public int getId() {
        return m_Id;
    }

    @XmlTransient
    public void setId(int m_Id) {
        this.m_Id = m_Id;
    }
    
    
    //---------------------------------------------------
    // Private variables
    //---------------------------------------------------    
    private String      m_Password;
    private String      m_Username;
    private ELoginType  m_Type;
    private String      m_SecurityQuestion;
    private int         m_PersondId;   
    private int         m_Id;
}
