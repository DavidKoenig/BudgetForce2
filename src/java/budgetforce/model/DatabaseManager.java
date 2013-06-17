
package budgetforce.model;

import budgetforce.model.Budget;
import budgetforce.model.Income;
import budgetforce.model.Login;
import budgetforce.model.Outgoing;
import budgetforce.model.OutgoingHasTax;
import budgetforce.model.Tax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Date;

/**
 * @author David König
 */
/*
 * @sources
 *  http://ohdevon.wordpress.com/2011/09/19/postgresql-to-netbeans-2/
 */


public class DatabaseManager {
    
    private Connection connection   = null;
    private String databaseUser     = "postgres";
    private String databasePw       = "pgr4";
    private String url              = "jdbc:postgresql://localhost:5432/BudgetForce";
    private String driver           = "org.postgresql.Driver";
    
    
    private void establishConnection()
    {
        if (connection != null)
            return;
      
        try
        {
           Class.forName(driver);
          
           connection = DriverManager.getConnection(url, databaseUser, databasePw);
           
           if (connection != null) {
               System.out.println("Connecting to database...");
           }
        } 
        catch(Exception e)
        {
            System.out.println("Problem when connecting to the database");
        }
    }
    
    private void closeConnection()
    {
        try
        {
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println("Problem to close the connection to the database");
        }
    }
    
    
    //Address stuff
    public Address getAddressByID(int _id)
    {establishConnection();
        
        ResultSet rs = null;
        
        Address address = new Address();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM address WHERE id = ?");
            st.setInt(1, _id);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                address.setId(rs.getInt("id"));
                address.setStreetNmbr(rs.getString("streetNmbr"));
                address.setCity(rs.getString("city"));
                address.setZipCode(rs.getString("zipcode"));
                address.setCountry(rs.getString("country"));
                address.setEmail(rs.getString("email"));
                address.setPhone1(rs.getString("phone1"));
                address.setPhone2(rs.getString("phone2"));
                
                String type = rs.getString("type");
                type.toUpperCase();
                
                if(type.equals(address.getType().ADDITIONAL))
                {
                    address.setType(Address.EAddressType.ADDITIONAL);
                }
                else if(type.equals(address.getType().BILLING))
                {
                    address.setType(Address.EAddressType.BILLING);
                }
                else if(type.equals(address.getType().COMPANY))
                {
                    address.setType(Address.EAddressType.COMPANY);
                }
                else if(type.equals(address.getType().PRIVATE))
                {
                    address.setType(Address.EAddressType.PRIVATE);
                }
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return address;
    }
    
    
    public ArrayList<Address> getAddressByPersonID(int _personID)
    {
        establishConnection();
        
        ArrayList addressArray = new ArrayList<Address>();
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM address WHERE \"personID\" = ?");
            st.setInt(1, _personID);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                Address address = new Address();
                
                address.setId(rs.getInt("id"));
                address.setStreetNmbr(rs.getString("streetNmbr"));
                address.setCity(rs.getString("city"));
                address.setZipCode(rs.getString("zipcode"));
                address.setCountry(rs.getString("country"));
                address.setEmail(rs.getString("email"));
                address.setPhone1(rs.getString("phone1"));
                address.setPhone2(rs.getString("phone2"));
                address.setPersondId(rs.getInt("personID"));
                address.setAddressAddition(rs.getString("addressAddition"));
                
                String type = rs.getString("type");
                type.toUpperCase();
                
                if(type.equals(address.getType().ADDITIONAL))
                {
                    address.setType(Address.EAddressType.ADDITIONAL);
                }
                else if(type.equals(address.getType().BILLING))
                {
                    address.setType(Address.EAddressType.BILLING);
                }
                else if(type.equals(address.getType().COMPANY))
                {
                    address.setType(Address.EAddressType.COMPANY);
                }
                else if(type.equals(address.getType().PRIVATE))
                {
                    address.setType(Address.EAddressType.PRIVATE);
                }
                
                addressArray.add(address);
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return addressArray;
    }
    
    
    public boolean insertAddress(Address _address)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("INSERT INTO address(\"streetNmbr\", "
                    + "city, zipcode, country, email, phone1, phone2, type, \"personID\", \"addressAddition\")"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, _address.getStreetNmbr());
            st.setString(2, _address.getCity());
            st.setString(3, _address.getZipCode());
            st.setString(4, _address.getCountry());
            st.setString(5, _address.getEmail());
            st.setString(6, _address.getPhone1());
            st.setString(7, _address.getPhone2());
            st.setString(8, _address.getType().toString().toLowerCase()); 
            st.setInt(9, _address.getPersondId());
            st.setString(10, _address.getAddressAddition());
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    public boolean updateAddress(Address _address)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("UPDATE address SET "
                    + "\"streetNmbr\" = ?, city = ?, zipcode = ?, country = ?, email = ?, phone1 = ?, "
                    + "phone2 = ?, type = ?, \"personID\" = ?, \"addressAddition\" = ?)"
                    + "WHERE id = ? ");
            st.setString(1, _address.getStreetNmbr());
            st.setString(2, _address.getCity());
            st.setString(3, _address.getZipCode());
            st.setString(4, _address.getCountry());
            st.setString(5, _address.getEmail());
            st.setString(6, _address.getPhone1());
            st.setString(7, _address.getPhone2());
            st.setString(8, _address.getType().toString().toLowerCase()); 
            st.setInt(9, _address.getPersondId());
            st.setString(10, _address.getAddressAddition());
            st.setInt(11, _address.getId());
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    public boolean deleteAddress(Address _address)
    {
        establishConnection();

        try
        {
            PreparedStatement st = connection.prepareStatement("DELETE FROM address WHERE id = ?");
            
            st.setInt(1, _address.getId());
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    //Budget stuff
    public Budget getBudgetByID(int _id)
    {
        establishConnection();
        
        Budget budget = new Budget();
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM budget WHERE id = ?");
            
            st.setInt(1, _id);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                budget.setBudgetId(rs.getInt("id"));
                budget.setCurrency(rs.getString("currency"));
                budget.setName(rs.getString("name"));
                budget.setPersonId(rs.getInt("personID"));
                budget.setProjectId(rs.getInt("projectID"));
                budget.setBudgetId(rs.getInt("budgetID"));
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return budget;
    }
    
        
    public ArrayList<Budget> getBudgetByPersonID(int _personID)
    {
        ArrayList arrayBudget = new ArrayList<Budget>();
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM budget WHERE \"personID = ?");
            
            st.setInt(1, _personID);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                Budget budget         = new Budget();
                
                budget.setBudgetId(rs.getInt("id"));
                budget.setCurrency(rs.getString("currency"));
                budget.setName(rs.getString("name"));
                budget.setPersonId(rs.getInt("personID"));
                budget.setProjectId(rs.getInt("projectID"));
                budget.setBudgetId(rs.getInt("budgetID"));
                
                arrayBudget.add(budget);
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return arrayBudget;
    }
    
        
    public ArrayList<Budget> getBudgetByProjectID(int _projectID)
    {
        ArrayList arrayBudget = new ArrayList<Budget>();
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM budget WHERE \"projectID = ?");
            
            st.setInt(1, _projectID);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                Budget budget         = new Budget();
                
                budget.setBudgetId(rs.getInt("id"));
                budget.setCurrency(rs.getString("currency"));
                budget.setName(rs.getString("name"));
                budget.setPersonId(rs.getInt("personID"));
                budget.setProjectId(rs.getInt("projectID"));
                budget.setBudgetId(rs.getInt("budgetID"));
                
                arrayBudget.add(budget);
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return arrayBudget;
    }
    
    
    public ArrayList<Budget> getBudgetByBudgetID(int _budgetID)
    {
        ArrayList arrayBudget = new ArrayList<Budget>();
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM budget WHERE \"budgetID = ?");
            
            st.setInt(1, _budgetID);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                Budget budget         = new Budget();
                
                budget.setBudgetId(rs.getInt("id"));
                budget.setCurrency(rs.getString("currency"));
                budget.setName(rs.getString("name"));
                budget.setPersonId(rs.getInt("personID"));
                budget.setProjectId(rs.getInt("projectID"));
                budget.setBudgetId(rs.getInt("budgetID"));
                
                arrayBudget.add(budget);
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return arrayBudget;
    }
    
    
    public boolean insertBudget(Budget _budget)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("INSERT INTO budget(name, "
                    + "currency, \"personID\", \"projectID\", \"budgetID\")"
                    + "VALUES(?, ?, ?, ?, ?)");
            
            st.setString(1, _budget.getName());
            st.setString(2, _budget.getCurrency());
            st.setInt(3, _budget.getPersonId());
            st.setInt(4, _budget.getProjectId());
            st.setInt(5, _budget.getBudgetId());
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    public boolean updateBudget(Budget _budget)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("UPDATE budget SET"
                    + "name = ?, currency = ?, \"personID\" = ?, \"projectID\" = ?,"
                    + " \"budgetID\" = ? "
                    + "WHERE id = ?");
            
            st.setString(1, _budget.getName());
            st.setString(2, _budget.getCurrency());
            st.setInt(3, _budget.getPersonId());
            st.setInt(4, _budget.getProjectId());
            st.setInt(5, _budget.getBudgetId());
            st.setInt(6, _budget.getId());
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    public boolean deleteBudget(int _id)
    {
        establishConnection();

        try
        {
            PreparedStatement st = connection.prepareStatement("DELETE FROM budget WHERE id = ?");
            
            st.setInt(1, _id);
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    //Category stuff
    public Category getCategoryByID(int _id)
    {
        establishConnection();
        
        ResultSet rs = null;
        
        Category category = new Category();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM category WHERE id = ?");
            st.setInt(1, _id);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try {
            while(rs.next())
            {  
                category.setM_Id(rs.getInt("id"));
                category.setM_Name(rs.getString("name"));
            }
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        
        return category;
    }
    
    public boolean insertCategory(Category _category)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("INSERT INTO category(name)"
                    + "VALUES(?)");
            
            st.setString(1, _category.getM_Name());
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    public boolean updateCategory(Category _category)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("UPDATE budget SET"
                    + "name = ? WHERE id = ?");
            
            st.setString(1, _category.getM_Name());
            st.setInt(2, _category.getM_Id());
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    public boolean deleteCategory(int _id)
    {
        establishConnection();

        try
        {
            PreparedStatement st = connection.prepareStatement("DELETE FROM category WHERE id = ?");
            
            st.setInt(1, _id);
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    //Income stuff
    public Income getIncomeByID(int _id)
    {
        establishConnection();
        
        ResultSet rs = null;
        
        Income income = new Income();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM income WHERE id = ?");
            st.setInt(1, _id);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try {
            while(rs.next())
            {  
                income.setId(rs.getInt("id"));
                income.setName(rs.getString("name"));
                income.setAmount(rs.getFloat("amount"));
                income.setPeriod(rs.getString("period"));
                income.setStart(rs.getDate("start"));
                income.setEnd(rs.getDate("end"));
                income.setTimestamp(rs.getDate("timestamp"));
                income.setPersonID(rs.getInt("personID"));
                income.setIncomeID(rs.getInt("incomeID"));
            }
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        
        return income;
    }
    
    
    public ArrayList<Income> getIncomeByPersonID(int _personID)
    {
        establishConnection();
        
        ResultSet rs = null;
        
        ArrayList incomeArray = new ArrayList<Income>();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM income WHERE \"personID\" =  ?");
            st.setInt(1, _personID);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem when searching in the database");
        }
        
        try {
            while(rs.next())
            {         
                Income tmpIncome       = new Income();
                
                tmpIncome.setId(rs.getInt("id"));
                tmpIncome.setName(rs.getString("name"));
                tmpIncome.setAmount(rs.getFloat("amount"));
                tmpIncome.setPeriod(rs.getString("period"));
                tmpIncome.setStart(rs.getDate("start"));
                tmpIncome.setEnd(rs.getDate("end"));
                tmpIncome.setTimestamp(rs.getDate("timestamp"));
                tmpIncome.setPersonID(rs.getInt("personID"));
                tmpIncome.setIncomeID(rs.getInt("incomeID"));
       
                incomeArray.add(tmpIncome);       
            }  
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
         
        finally {closeConnection();}
        return incomeArray;
    }
    
    
    public ArrayList<Income> getIncomeByIncomeID(int _incomeID)
    {
        establishConnection();
        
        ResultSet rs = null;
        
        ArrayList incomeArray = new ArrayList<Income>();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM income WHERE \"incomeID\" =  ?");
            st.setInt(1, _incomeID);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem when searching in the database");
        }
        
        try {
            while(rs.next())
            {         
                Income tmpIncome       = new Income();
                
                tmpIncome.setId(rs.getInt("id"));
                tmpIncome.setName(rs.getString("name"));
                tmpIncome.setAmount(rs.getFloat("amount"));
                tmpIncome.setPeriod(rs.getString("period"));
                tmpIncome.setStart(rs.getDate("start"));
                tmpIncome.setEnd(rs.getDate("end"));
                tmpIncome.setTimestamp(rs.getDate("timestamp"));
                tmpIncome.setPersonID(rs.getInt("personID"));
                tmpIncome.setIncomeID(rs.getInt("incomeID"));
       
                incomeArray.add(tmpIncome);       
            }  
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
         
        finally {closeConnection();}
        return incomeArray;
    }
    
    public boolean insertIncome(Income _income)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("INSERT INTO income(name, "
                    + "amount, timestamp, period, start, end, \"personID\", \"incomeID\")"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            
            st.setString(1, _income.getName());
            st.setFloat(2, _income.getAmount());
            st.setDate(3, _income.getTimestamp());
            st.setString(4, _income.getPeriod());
            st.setDate(5, _income.getStart());
            st.setDate(6, _income.getEnd());
            st.setInt(7, _income.getPersonID());
            st.setInt(8, _income.getIncomeID());
            st.setInt(9, _income.getId());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    public boolean updateIncome(Income _income)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("UPDATE income"
                    + " SET name = ?, amount = ?, timestamp = ?, period = ?, start = ?,"
                    + " end = ?, \"personID\" = ?, \"incomeID\" = ?  WHERE id = ?");
           
            st.setString(1, _income.getName());
            st.setFloat(2, _income.getAmount());
            st.setDate(3, _income.getTimestamp());
            st.setString(4, _income.getPeriod());
            st.setDate(5, _income.getStart());
            st.setDate(6, _income.getEnd());
            st.setInt(7, _income.getPersonID());
            st.setInt(8, _income.getIncomeID());
            st.setInt(9, _income.getId());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    public boolean deleteIncome(int _id)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("DELETE FROM income"
                    + "WHERE id = ?");
            
            st.setInt(1, _id);
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
            
    //Login stuff
    public Login getLoginByUsername(String _username)
    {
        establishConnection();
        
        Login login = new Login();
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM login WHERE username = ?");
            
            st.setString(1, _username);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
                login.setSecurityQuestion(rs.getString("securityQuestion"));
                login.setPersondId(rs.getInt("personID"));
                
                String type = rs.getString("type");
                type.toUpperCase();
                
                if(type.equals(Login.ELoginType.COMPANY))
                {
                    login.setType(Login.ELoginType.COMPANY);
                }
                else if(type.equals(Login.ELoginType.PRIVATE))
                {
                    login.setType(Login.ELoginType.PRIVATE);
                }
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return login;
    }
    
    
    public Login getLoginByPersonID(int _personID)
    {
        establishConnection();
        
        Login login = new Login();
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM login WHERE \"personID\" = ?");
            
            st.setInt(1, _personID);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
                login.setSecurityQuestion(rs.getString("securityQuestion"));
                login.setPersondId(rs.getInt("personID"));
                
                String type = rs.getString("type");
                type.toUpperCase();
                
                if(type.equals(Login.ELoginType.COMPANY))
                {
                    login.setType(Login.ELoginType.COMPANY);
                }
                else if(type.equals(Login.ELoginType.PRIVATE))
                {
                    login.setType(Login.ELoginType.PRIVATE);
                }
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return login;
    }
    
    
    public boolean insertLogin(Login _login)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("INSERT INTO login(username, "
                    + "password, \"securityQuestion\", \"personID\", type)"
                    + "VALUES(?, ?, ?, ?, ?)");
            st.setString(1, _login.getUsername());
            st.setString(2, _login.getPassword());
            st.setString(3, _login.getSecurityQuestion());
            st.setInt(4, _login.getPersondId());
            st.setString(5, _login.getType().toString().toLowerCase());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    public boolean updateLogin(Login _login) //username can not be changed 
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("UPDATE login"
                    + "SET password = ?, \"securityQuestion\" = ?, \"personID\" = ?, type = ?"
                    + "WHERE username = ?");
        
            st.setString(1, _login.getPassword());
            st.setString(2, _login.getSecurityQuestion());
            st.setInt(3, _login.getPersondId());
            st.setString(4, _login.getType().toString().toLowerCase());
            st.setString(5, _login.getUsername());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    public boolean updateLoginPassword(String _username, String _password)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("UPDATE login"
                    + "SET password = ? WHERE username = ?");
            
            st.setString(1, _password);
            st.setString(2, _username);
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    public boolean updateLoginSecurityQuestion(String _username, String _securityQuestion)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("UPDATE login"
                    + "SET \"securityQuestion\" = ? WHERE username = ?");
            
            st.setString(1, _securityQuestion);
            st.setString(2, _username);
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    public boolean deleteLogin(String _username)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("DELETE FROM login"
                    + "WHERE username = ?");
            
            st.setString(1, _username);
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    //Outgoing Stuff
    public Outgoing getOutgoingByID(int _id)
    {
        establishConnection();
        
        Outgoing outgoing = new Outgoing();
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM outgoing WHERE id = ?");
            
            st.setInt(1, _id);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                outgoing.setId(rs.getInt("id"));
                outgoing.setAmount(rs.getFloat("amount"));
                outgoing.setPeriod(rs.getString("period"));
                outgoing.setStart(rs.getDate("start"));
                outgoing.setEnd(rs.getDate("end"));
                outgoing.setTimeStamp(rs.getDate("timestamp"));
                outgoing.setBudgetId(rs.getInt("budgetID"));
                outgoing.setCategoryId(rs.getInt("categoryID"));
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return outgoing;
    }
    
    public ArrayList<Outgoing> getOutgoingByBudgetID(int _budgetID)
    {
        establishConnection();
        
        ArrayList arrayOutgoing = new ArrayList<Outgoing>();
        
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM outgoing WHERE id = ?");
            
            st.setInt(1, _budgetID);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                Outgoing outgoing = new Outgoing();
                
                outgoing.setId(rs.getInt("id"));
                outgoing.setAmount(rs.getFloat("amount"));
                outgoing.setPeriod(rs.getString("period"));
                outgoing.setStart(rs.getDate("start"));
                outgoing.setEnd(rs.getDate("end"));
                outgoing.setTimeStamp(rs.getDate("timestamp"));
                outgoing.setBudgetId(rs.getInt("budgetID"));
                outgoing.setCategoryId(rs.getInt("categoryID"));
                
                arrayOutgoing.add(outgoing);
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return arrayOutgoing;
    }
    
    public ArrayList<Outgoing> getOutgoingByCategoryID(int _categoryID)
    {
        establishConnection();
        
        ArrayList arrayOutgoing = new ArrayList<Outgoing>();
        
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM outgoing WHERE id = ?");
            
            st.setInt(1, _categoryID);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                Outgoing outgoing = new Outgoing();
                
                outgoing.setId(rs.getInt("id"));
                outgoing.setAmount(rs.getFloat("amount"));
                outgoing.setPeriod(rs.getString("period"));
                outgoing.setStart(rs.getDate("start"));
                outgoing.setEnd(rs.getDate("end"));
                outgoing.setTimeStamp(rs.getDate("timestamp"));
                outgoing.setBudgetId(rs.getInt("budgetID"));
                outgoing.setCategoryId(rs.getInt("categoryID"));
                
                arrayOutgoing.add(outgoing);
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return arrayOutgoing;
    }
    
    public boolean insertOutgoing(Outgoing _outgoing)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("INSERT INTO outgoing(amount, "
                    + " period, start, end, timestamp, \"budgetID\", \"categoryID\") "
                    + "VALUES(?, ?, ?, ?, ?, ?)");
           
            st.setFloat(1, _outgoing.getAmount());
            st.setString(2, _outgoing.getPeriod());
            st.setDate(3, _outgoing.getStart());
            st.setDate(4, _outgoing.getEnd());
            st.setDate(5, _outgoing.getTimeStamp());
            st.setInt(6, _outgoing.getBudgetId());
            st.setInt(7, _outgoing.getCategoryId());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    public boolean updateOutgoing(Outgoing _outgoing)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("UPDATE outgoing SET amount = ?, "
                    + " period = ?, start = ?, end = ?, timestamp = ?, \"budgetID\" = ?,"
                    + " \"categoryID\" = ? WHERE id = ?");
           
            st.setFloat(1, _outgoing.getAmount());
            st.setString(2, _outgoing.getPeriod());
            st.setDate(3, _outgoing.getStart());
            st.setDate(4, _outgoing.getEnd());
            st.setDate(5, _outgoing.getTimeStamp());
            st.setInt(6, _outgoing.getBudgetId());
            st.setInt(7, _outgoing.getCategoryId());
            st.setInt(8, _outgoing.getId());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    public boolean deleteOutgoing(int _id)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("DELETE FROM outgoing"
                    + "WHERE id = ?");
            
            st.setInt(1, _id);
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    //OutgoingHasTax stuff
    public OutgoingHasTax getOutgoingHasTaxByID(int _outgoingID, int _taxID)
    {
        establishConnection();
        
        OutgoingHasTax oht = new OutgoingHasTax();
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM outgoing_has_tax WHERE \"outgoingID\" = ?"
                    + "and \"taxID\" = ? ");
            
            st.setInt(1, _outgoingID);
            st.setInt(2, _taxID);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                oht.setOutgoingId(rs.getInt("outoginID"));
                oht.setTaxId(rs.getInt("taxID"));
                oht.setWriteOff(rs.getBoolean("write-off"));
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return oht;
    }
    
    
    public ArrayList<OutgoingHasTax> getOutgoingHasTaxByOutgoingID(int _outgoingID)
    {
        establishConnection();
        
        ArrayList arrayOht = new ArrayList<OutgoingHasTax>();
        
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM outgoing_has_tax WHERE \"outgoingID\" = ?");
            
            st.setInt(1, _outgoingID);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                OutgoingHasTax oht = new OutgoingHasTax();
                
                oht.setOutgoingId(rs.getInt("outoginID"));
                oht.setTaxId(rs.getInt("taxID"));
                oht.setWriteOff(rs.getBoolean("write-off"));
                
                arrayOht.add(oht);
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return arrayOht;
    }
    
    
    public boolean insertOutgoingHasTaxByID(OutgoingHasTax _outgoingHasTax)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("INSERT INTO outgoing_has_tax"
                    + "(\"outgoingID\", \"taxID\", write-off) "
                    + "VALUES(?, ?, ?)");
           
            st.setInt(1, _outgoingHasTax.getOutgoingId());
            st.setInt(2, _outgoingHasTax.getTaxId());
            st.setBoolean(3, _outgoingHasTax.isWriteOff());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    public boolean updateOutgoingHasTax(OutgoingHasTax _outgoingHasTax)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("UPDATE outgoing_has_tax "
                    + "SET write-off = ? WHERE \"outgoingID\" = ? AND \"taxID\" = ?");
           
            st.setBoolean(1, _outgoingHasTax.isWriteOff());
            st.setInt(2, _outgoingHasTax.getOutgoingId());
            st.setInt(3, _outgoingHasTax.getTaxId());
            
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    public boolean deleteOutgoingHasTaxByID(int _outgoingID, int _taxID)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("DELETE FROM person"
                    + "WHERE \"outgoingID\" = ? AND \"taxID\" = ?");
            
            st.setInt(2, _outgoingID);
            st.setInt(3, _taxID);
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    //Person stuff
    public Person getPersonByID(int _id)
    {
        establishConnection();
        
        Person person = new Person();
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
            
            st.setInt(1, _id);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                person.setId(rs.getInt("id"));
                person.setFirstName(rs.getString("firstName"));
                person.setLastName(rs.getString("lastName"));
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return person;
    }
    
    
    public int insertPerson(Person _person)     //returns the id of the inserted person
    {
        establishConnection();
        
        ResultSet rs = null;
        int id = 0;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("INSERT INTO person(\"firstName\", "
                    + "\"lastName\") VALUES(?, ?)");
           
            st.setString(1, _person.getFirstName());
            st.setString(2, _person.getLastName());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        
        //get ID
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT MAX(id) FROM person");
           
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                id = rs.getInt("id");
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        
        finally {closeConnection();}
        return id;
    }
    
    
    public boolean updatePerson(Person _person)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("UPDATE person SET \"firstName\" = ?, "
                    + " \"lastName\" = ? WHERE id = ?");
           
            st.setInt(1, _person.getId());
            st.setString(2, _person.getFirstName());
            st.setString(3, _person.getLastName());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
                 
    public boolean deletePerson(int _id)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("DELETE FROM person"
                    + "WHERE id = ?");
            
            st.setInt(1, _id);
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    //Project stuff
    public Project getProjectByID(int _id)
    {
        establishConnection();
        
        Project project = new Project();
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM project WHERE id = ?");
            
            st.setInt(1, _id);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return project;
    }
    
    
    public boolean insertProject(Project _project)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("INSERT INTO project(name, "
                    + ") VALUES(?)");
           
            st.setString(1, _project.getName());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    public boolean updateProject(Project _project)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("UPDATE project SET name = ?, "
                    + " WHERE id = ?");
           
            st.setString(1, _project.getName());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    public boolean deleteProject(int _id)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("DELETE FROM project"
                    + "WHERE id = ?");
            
            st.setInt(1, _id);
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    //SystemNotification stuff
    public SystemNotification getSystemNotificationByID(int _id)
    {
        establishConnection();
        
        SystemNotification notification = new SystemNotification();
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM system_notification WHERE id = ?");
            
            st.setInt(1, _id);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                notification.setMessage(rs.getString("message"));
                
                String type = rs.getString("type");
                type.toUpperCase();
                
                if(type.equals(SystemNotification.ENotificationType.ERROR))
                {
                    notification.setType(SystemNotification.ENotificationType.ERROR);
                }
                
                else if(type.equals(SystemNotification.ENotificationType.NEUTRAL))
                {
                    notification.setType(SystemNotification.ENotificationType.NEUTRAL);
                }
                
                else if(type.equals(SystemNotification.ENotificationType.SUCCESS))
                {
                    notification.setType(SystemNotification.ENotificationType.SUCCESS);
                }
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return notification;
    }
    
    public boolean insertSystemNotification(SystemNotification _systemNotification)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("INSERT INTO system_notification"
                    + "(message, type) VALUES(?, ?)");
           
            st.setString(1, _systemNotification.getMessage());
            st.setString(2, _systemNotification.getType().toString().toUpperCase());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    public boolean updateSystemNotification(SystemNotification _systemNotification)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("UPDATE system_notification"
                    + " SET message = ?, type = ? WHERE id = ?");
           
            st.setString(1, _systemNotification.getMessage());
            st.setString(2, _systemNotification.getType().toString().toLowerCase());
            st.setInt(3, _systemNotification.getId());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    public boolean deleteSystemNotification(int _id)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("DELETE FROM system_notification"
                    + "WHERE id = ?");
            
            st.setInt(1, _id);
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    
    //Tax stuff
    public Tax getTaxByID(int _id)
    {
        establishConnection();
        
        Tax tax = new Tax();
        ResultSet rs = null;
        
        try
        {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM tax WHERE id = ?");
            
            st.setInt(1, _id);
            rs = st.executeQuery();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try 
        {
            while(rs.next())
            {  
                tax.setAmount(rs.getFloat("amount"));
                tax.setType(rs.getString("type"));
                tax.setSystemFlag(rs.getBoolean("systemFlag"));
            }
            rs.close();
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        finally {closeConnection();}
        return tax;
    }
    
    public boolean insertTax(Tax _tax)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("INSERT INTO tax"
                    + "(amount, type, \"systemFlag\") VALUES(?, ?, ?)");
           
            st.setFloat(1, _tax.getAmount());
            st.setString(2, _tax.getType());
            st.setBoolean(3, _tax.isSystemFlag());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true; 
    }
    
    public boolean updateTax(Tax _tax)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("UPDATE tax"
                    + " SET amount = ?, type = ?, \"systemFlag\" = ? WHERE id = ?");
           
            st.setFloat(1, _tax.getAmount());
            st.setString(2, _tax.getType());
            st.setBoolean(3, _tax.isSystemFlag());
            st.setInt(4, _tax.getId());
           
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
    public boolean deleteTax(int _id)
    {
        establishConnection();
        
        try
        {
            PreparedStatement st = connection.prepareStatement("DELETE FROM tax"
                    + "WHERE id = ?");
            
            st.setInt(1, _id);
            
            st.executeUpdate();
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
            return false;
        }
        
        finally {closeConnection();}
        return true;
    }
    
}
