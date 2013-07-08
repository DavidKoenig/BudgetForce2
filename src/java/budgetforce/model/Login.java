/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;

/**
 *
 * @author David
 */
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
    public String getPassword() {
        return m_Password;
    }

    public void setPassword(String _Password) {
        this.m_Password = _Password;
    }

    public String getUsername() {
        return m_Username;
    }

    public void setUsername(String _Username) {
        this.m_Username = _Username;
    }

    public ELoginType getType() {
        return m_Type;
    }

    public void setType(ELoginType _Type) {
        this.m_Type = _Type;
    }

    public String getSecurityQuestion() {
        return m_SecurityQuestion;
    }

    public void setSecurityQuestion(String _SecurityQuestion) {
        this.m_SecurityQuestion = _SecurityQuestion;
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
    private String      m_Password;
    private String      m_Username;
    private ELoginType  m_Type;
    private String      m_SecurityQuestion;
    private int         m_PersondId;    
}
