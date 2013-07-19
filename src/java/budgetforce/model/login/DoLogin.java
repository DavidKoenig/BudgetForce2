/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.model.login;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kinske
 */
public class DoLogin 
{
    public String getLoginToken() {
        return m_LoginToken;
    }
    
    @XmlElement(name="logintoken")
    public void setLoginToken(String m_LoginToken) {
        this.m_LoginToken = m_LoginToken;
    }

    public String getAuthToken() {
        return m_AuthToken;
    }
    
    @XmlElement(name="authtoken")
    public void setAuthToken(String m_AuthToken) {
        this.m_AuthToken = m_AuthToken;
    }

    public String getUsername() {
        return m_Username;
    }

    @XmlElement(name="username")
    public void setUsername(String m_Username) {
        this.m_Username = m_Username;
    }
    
    private String m_LoginToken;
    private String m_AuthToken;
    private String m_Username;
}
