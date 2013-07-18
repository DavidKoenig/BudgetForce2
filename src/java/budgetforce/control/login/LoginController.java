/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.control.login;

import budgetforce.control.login.LoginTokenController;
import budgetforce.model.login.LoginToken;
import budgetforce.model.login.Login;
import budgetforce.model.login.TransToken;
import budgetforce.model.DatabaseManager;

import java.sql.Timestamp;

/**
 *
 * @author kinske
 */
public class LoginController 
{
    public boolean loginSuccessful(String _LoginToken, String _AuthToken, String _Username)
    {
        if(m_LoginTokenController.isLoginTokenValid(_LoginToken))
        {
            m_Login = DatabaseManager.getDatabaseManager().getLoginByUsername(_Username);
            
            m_AuthToken = _LoginToken + _Username + m_Login.getPassword();
            m_AuthToken = SecretMaker.getInstance().makeSecretSHA512(m_AuthToken);
            
            if(m_AuthToken.equals(_AuthToken)) return true;
            
            else return false;
        }
        
        else return false;
    }
    
    public synchronized TransToken getTransToken()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis() / 1000);
        
        String transToken = timestamp.toString() + m_Login.getPersondId() + m_Login.getUsername();
        
        m_TransToken.setToken(SecretMaker.getInstance().makeSecretSHA512(transToken));
        m_TransToken.setPersonId(m_Login.getPersondId());
        m_TransToken.setTimestamp(timestamp);
        
        DatabaseManager.getDatabaseManager().insertTransToken(m_TransToken);
        
        return m_TransToken;
    }
    
    private String                  m_AuthToken;
    private TransToken              m_TransToken;
    private Login                   m_Login;
    private LoginTokenController    m_LoginTokenController;
}
