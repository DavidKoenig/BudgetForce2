/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.model.login;

import java.sql.Timestamp;

/**
 *
 * @author kinske
 */
public class LoginToken 
{

    public int getId() {
        return m_Id;
    }

    public void setId(int _Id) {
        this.m_Id = _Id;
    }

    public String getToken() {
        return m_Token;
    }

    public void setToken(String _Token) {
        this.m_Token = _Token;
    }

    public Timestamp getTimestamp() {
        return m_Timestamp;
    }

    public void setTimestamp(Timestamp _Timestamp) {
        this.m_Timestamp = _Timestamp;
    }
    
    
    private int         m_Id;
    private String      m_Token;
    private Timestamp   m_Timestamp;
}
