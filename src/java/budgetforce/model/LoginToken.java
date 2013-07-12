/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.model;

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

    public void setId(int m_Id) {
        this.m_Id = m_Id;
    }

    public String getToken() {
        return m_Token;
    }

    public void setToken(String m_Token) {
        this.m_Token = m_Token;
    }

    public Timestamp getTimestamp() {
        return m_Timestamp;
    }

    public void setTimestamp(Timestamp m_Timestamp) {
        this.m_Timestamp = m_Timestamp;
    }
    
    
    private int         m_Id;
    private String      m_Token;
    private Timestamp   m_Timestamp;
}
