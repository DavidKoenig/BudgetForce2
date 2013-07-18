/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model.statistics;

import java.util.Date;
import java.util.ArrayList;

import budgetforce.model.Outgoing;
import budgetforce.model.Category;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@XmlRootElement
public class StatisticOutgoingCategory {
    
    //---------------------------------------------------
    // Get and set functions
    //---------------------------------------------------
    @XmlElement(name="categoryname")
    public String getCategoryName() {
        return m_Category.getName();
    }
    
    @XmlElement(name="category")
    public void setCategory(Category _Category) {
        this.m_Category = _Category;
    }
    
    @XmlElement(name="outgoings")
    public ArrayList<Outgoing> getOutgoings() {
        return m_Outgoings;
    }
    
    @XmlElement(name="outgoings")
    public void setOutgoings(ArrayList<Outgoing> _Outgoing) {
        this.m_Outgoings = _Outgoing;
    }
    
    @XmlElement(name="outgoingscount")
    public int getOutgoingsCount() {
        return this.m_Outgoings.size();
    }
    
    @XmlElement(name="startdate")
    public Date getStartDate() {
        return m_Start;
    }
    
    @XmlElement(name="startdate")
    public void setStartDate(Date _Start) {
        this.m_Start = _Start;
    }
    
    @XmlElement(name="enddate")
    public Date getEndDate() {
        return m_End;
    }
    
    @XmlElement(name="enddate")
    public void setEndDate(Date _End) {
        this.m_End = _End;
    }
    
    @XmlElement(name="overallpercentage")
    public Float getOverallPercentage() {
        return m_OverallPercentage;
    }
    
    @XmlElement(name="overallpercentage")
    public void setOverallPercentage(Float _OverallPercentage) {
        this.m_OverallPercentage = _OverallPercentage;
    }
    
    @XmlElement(name="sum")
    public Float getSum() {
        return m_Sum;
    }
    
    @XmlElement(name="sum")
    public void setSum(Float _Sum) {
        this.m_Sum = _Sum;
    }
    
    @XmlElement(name="userid")
    public Integer getUserId() {
        return m_UserId;
    }
    
    @XmlElement(name="userid")
    public void setUserId(Integer _UserId) {
        this.m_UserId = _UserId;
    }
    
    public StatisticOutgoingCategory() 
    {
        this.m_OverallPercentage = 0.0f;
        this.m_Sum               = 0.0f;
    }
    
    //---------------------------------------------------
    // Private variables
    //---------------------------------------------------
    private Category                m_Category;
    private ArrayList<Outgoing>     m_Outgoings;
    private Date                    m_Start;
    private Date                    m_End;
    private Float                   m_OverallPercentage;
    private Float                   m_Sum;
    private Integer                 m_UserId;
    
}