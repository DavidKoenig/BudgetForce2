/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.control.login;

import budgetforce.model.DatabaseManager;
import budgetforce.model.login.LoginToken;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
    
    public LoginTokenController()
    {
        m_LoginToken = new LoginToken();
    }
    
    //synchronized, because same timestamp would cause same login token --> must be unique
    public synchronized String getLoginToken()
    {
         Timestamp timestamp = new Timestamp(System.currentTimeMillis());
         m_LoginToken.setTimestamp(timestamp); 
         
         try
         {
             m_LoginToken.setToken(SecretMaker2.SHA512(timestamp.toString()));
         }
         
         catch(NoSuchAlgorithmException ex)
         {
             System.out.println(ex.getMessage());
         }
         
         catch (UnsupportedEncodingException ex)
         {
            System.out.println(ex.getMessage());
         }
         
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
    
    private LoginToken m_LoginToken;
    //private static LoginTokenController m_LoginTokenController = null;
}
