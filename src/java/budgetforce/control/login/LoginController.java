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
import budgetforce.model.login.DoLogin;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import java.sql.Timestamp;

    
/**
 *
 * @author kinske
 */
public class LoginController 
{    
    public LoginController()
    {
        m_TransToken = new TransToken();
        m_Login = new Login();
        m_LoginTokenController = new LoginTokenController();
    }
    
    public boolean loginSuccessful(String _LoginToken, String _AuthToken, String _Username)
    {
        if(m_LoginTokenController.isLoginTokenValid(_LoginToken))
        {
            System.out.println("Login Token Valide");
            m_Login = DatabaseManager.getDatabaseManager().getLoginByUsername(_Username);
            System.out.println("Login Daten: " + m_Login.getUsername() + " " + m_Login.getPassword());
            m_AuthToken = _LoginToken + _Username + m_Login.getPassword();
            
            try
            {
                m_AuthToken = SecretMaker2.SHA512(m_AuthToken);
                System.out.println("AuthTOken: " + m_AuthToken);
            }
            
            catch(NoSuchAlgorithmException ex)
            {
                System.out.println(ex.getMessage());
            }
            catch (UnsupportedEncodingException ex)
            {
               System.out.println(ex.getMessage());
            }
            
            if(m_AuthToken.equals(_AuthToken)) return true;
            
            else System.out.println("Auth Token stimmen nicht überein"); return false;
        }
 
        else return false;
    }
    
    public synchronized TransToken getTransToken() throws NoSuchAlgorithmException
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis() / 1000);
        
        String transToken = timestamp.toString() + m_Login.getPersondId() + m_Login.getUsername();
        
        try
        {
            m_TransToken.setToken(SecretMaker2.SHA512(transToken));
        }
        
        catch(NoSuchAlgorithmException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (UnsupportedEncodingException ex)
        {
           System.out.println(ex.getMessage());
        }
        
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
