/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;

/**
 *
 * @author David
 */
public class OutgoingHasTax {

    public int getOutgoingId() {
        return m_OutgoingId;
    }

    public void setOutgoingId(int _OutgoingId) {
        this.m_OutgoingId = _OutgoingId;
    }

    public int getTaxId() {
        return m_TaxId;
    }

    public void setTaxId(int _TaxId) {
        this.m_TaxId = _TaxId;
    }

    public boolean isWriteOff() {
        return m_WriteOff;
    }

    public void setWriteOff(boolean _WriteOff) {
        this.m_WriteOff = _WriteOff;
    }

    //---------------------------------------------------
    // Private variables
    //---------------------------------------------------
    private int     m_OutgoingId;
    private int     m_TaxId;
    private boolean m_WriteOff;
}