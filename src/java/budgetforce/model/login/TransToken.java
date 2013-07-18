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
public class TransToken 
{

    public int getPersonId() {
        return m_PersonId;
    }

    public void setPersonId(int m_PersonId) {
        this.m_PersonId = m_PersonId;
    }

    public Timestamp getTimestamp() {
        return m_Timestamp;
    }

    public void setTimestamp(Timestamp m_Timestamp) {
        this.m_Timestamp = m_Timestamp;
    }

    public String getToken() {
        return m_Token;
    }

    public void setToken(String m_Token) {
        this.m_Token = m_Token;
    }

    public int getId() {
        return m_Id;
    }

    public void setId(int m_Id) {
        this.m_Id = m_Id;
    }
    
    
    private int         m_PersonId;
    private Timestamp   m_Timestamp;
    private String      m_Token;
    private int         m_Id;
}
