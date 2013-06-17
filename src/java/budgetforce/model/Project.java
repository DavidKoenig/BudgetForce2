/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;

/**
 *
 * @author David
 */
public class Project {

    //---------------------------------------------------
    // Get and set functions
    //--------------------------------------------------
    public int getId() {
        return m_Id;
    }

    public void setId(int _Id) {
        this.m_Id = _Id;
    }

    public String getName() {
        return m_Name;
    }

    public void setName(String _Name) {
        this.m_Name = _Name;
    }

        
    //---------------------------------------------------
    // Private variables
    //--------------------------------------------------- 
    private int     m_Id;
    private String  m_Name;
}