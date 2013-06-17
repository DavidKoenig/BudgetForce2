/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;

/**
 *
 * @author David
 */
public class Tax {

    //---------------------------------------------------
    // Get and set functions
    //---------------------------------------------------
    public int getId() {
        return m_Id;
    }

    public void setId(int _Id) {
        this.m_Id = _Id;
    }

    public float getAmount() {
        return m_Amount;
    }

    public void setAmount(float _Amount) {
        this.m_Amount = _Amount;
    }

    public String getType() {
        return m_Type;
    }

    public void setType(String _Type) {
        this.m_Type = _Type;
    }

    public boolean isSystemFlag() {
        return m_SystemFlag;
    }

    public void setSystemFlag(boolean _SystemFlag) {
        this.m_SystemFlag = _SystemFlag;
    }

    //---------------------------------------------------
    // Private variables
    //---------------------------------------------------
    private int     m_Id;
    private float   m_Amount;
    private String  m_Type;
    private boolean m_SystemFlag;
}