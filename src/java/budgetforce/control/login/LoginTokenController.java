/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.control.login;

import budgetforce.model.DatabaseManager;
import budgetforce.model.login.LoginToken;

import java.sql.Timestamp;

/**
 *
 * @author kinske
 */
public class LoginTokenController 
{
    /* 
    private LoginTokenController()
    {
    }
    
    public static LoginTokenController getInstance()
    {
        if (m_LoginTokenController == null)   m_LoginTokenController = new LoginTokenController();
                               
        return m_LoginTokenController;
    }
    */
    
    //synchronized, because same timestamp would cause same login token --> must be unique
    public synchronized String getLoginToken()
    {
         m_LoginToken.setTimestamp(new Timestamp(System.currentTimeMillis() / 1000)); 
         m_LoginToken.setToken(SecretMaker.getInstance().makeSecretSHA512(m_LoginToken.getTimestamp().toString()));
         
         DatabaseManager.getDatabaseManager().insertLoginToken(m_LoginToken);
         
         return m_LoginToken.getToken();
    }
    
    boolean isLoginTokenValid(String _LoginToken)
    {
        m_LoginToken = DatabaseManager.getDatabaseManager().getLoginTokenByString(_LoginToken);
        
        if(m_LoginToken == null)
        {
            return false;
        }
        
        else
        {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis() / 1000);
            long difference = (timestamp.getTime() - m_LoginToken.getTimestamp().getTime()) / 1000;
            
            if(difference <= 120)    return true; 
            
            else return false;
        }
    }
    
    private LoginToken                  m_LoginToken;
    //private static LoginTokenController m_LoginTokenController = null;
}
