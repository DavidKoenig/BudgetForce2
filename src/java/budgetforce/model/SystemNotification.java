/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;

/**
 *
 * @author David
 */
public class SystemNotification {
    //---------------------------------------------------
    // Enum for describing type of notification
    //---------------------------------------------------  
    public static enum ENotificationType {
        SUCCESS,
        NEUTRAL,
        ERROR
    }
    
    //---------------------------------------------------
    // Get and set functions
    //---------------------------------------------------
    public int getId() {
        return m_Id;
    }

    public void setId(int _Id) {
        this.m_Id = _Id;
    }

    public ENotificationType getType() {
        return m_Type;
    }

    public void setType(ENotificationType _Type) {
        this.m_Type = _Type;
    }

    public String getMessage() {
        return m_Message;
    }

    public void setMessage(String _Message) {
        this.m_Message = _Message;
    }
    
    
    //---------------------------------------------------
    // Private variables
    //---------------------------------------------------
    private int                 m_Id;
    private ENotificationType   m_Type;
    private String              m_Message;
}