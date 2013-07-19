/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.control.login;

import budgetforce.model.login.Login;
import budgetforce.model.login.TransToken;
import budgetforce.model.DatabaseManager;

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
        m_PersonId = 0;
    }
    
    
    public boolean loginSuccessful(String _LoginToken, String _AuthToken, String _Username)
    {
        //check if login token exists or is valid, if yes create auth token and compare it to the send auth token
        if(m_LoginTokenController.isLoginTokenValid(_LoginToken))
        {
            m_Login = DatabaseManager.getDatabaseManager().getLoginByUsername(_Username);
            m_AuthToken = _LoginToken + _Username + m_Login.getPassword();
            
            try
            {
                //encrypt auth token
                m_AuthToken = SecretMaker2.SHA512(m_AuthToken);
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
    
    //synchronized, because of timestamp
    public synchronized TransToken getTransToken() throws NoSuchAlgorithmException
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis() / 1000);
        
        //create trans token with timestamp + person id + username
        String transToken = timestamp.toString() + m_Login.getPersondId() + m_Login.getUsername();
        
        //encrypt trans token
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
        
        //set all things needed later for transactions, person id for access to the right budgets, outgoings, incomes, etc and timestamp for session expirering
        m_TransToken.setPersonId(m_Login.getPersondId());
        m_TransToken.setTimestamp(timestamp);
        
        m_PersonId = DatabaseManager.getDatabaseManager().insertTransToken(m_TransToken);
        
        return m_TransToken;
    } 
    
    private String                  m_AuthToken;
    private TransToken              m_TransToken;
    private Login                   m_Login;
    private LoginTokenController    m_LoginTokenController;
    private int                     m_PersonId;
}
