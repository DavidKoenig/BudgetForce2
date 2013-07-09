/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.control;

import budgetforce.model.Budget;
import budgetforce.model.DatabaseManager;

import java.util.ArrayList;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author David
 */
@Path("/budget")
public class BudgetResource {
    
    public BudgetResource() 
    {
    }
    
    // <editor-fold defaultstate="collapsed" desc="getBudgetById">
    
    //---------------------------------------------------
    // getBudgetById
    //---------------------------------------------------
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Budget getBudgetById(@PathParam("id") Integer _Id)
    {
        return DatabaseManager.getDatabaseManager().getBudgetByID(_Id);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="getBudgetByPersonId">
    
    //---------------------------------------------------
    // getBudgetByPersonId
    //---------------------------------------------------
    @GET
    @Path("/person/{id}")
    @Produces("application/json")
    public ArrayList<Budget> getBudgetByPersonId(@PathParam("id") Integer _Id)
    {
        return DatabaseManager.getDatabaseManager().getBudgetByPersonID(_Id);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="getBudgetByProjectId">
    
    //---------------------------------------------------
    // getBudgetByProjectId
    //---------------------------------------------------
    @GET
    @Path("/project/{id}")
    @Produces("application/json")
    public ArrayList<Budget> getBudgetByProjectId(@PathParam("id") Integer _Id)
    {
        return DatabaseManager.getDatabaseManager().getBudgetByProjectID(_Id);
    }
        
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="getBudgetByBudgetId">
    
    //---------------------------------------------------
    // getBudgetByBudgetId
    //---------------------------------------------------
    @GET
    @Path("/budget/{id}")
    @Produces("application/json")
    public ArrayList<Budget> getBudgetByBudgetId(@PathParam("id") Integer _Id)
    {
        return DatabaseManager.getDatabaseManager().getBudgetByBudgetID(_Id);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="postBudget">
    
    //---------------------------------------------------
    // postBudget
    //---------------------------------------------------
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postBudget(Budget _Budget)
    {
        int id = DatabaseManager.getDatabaseManager().insertBudget(_Budget);
        
        _Budget.setId(id);
        
        return Response.status(201).entity(_Budget).build();
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="putBudget">
    
    //---------------------------------------------------
    // putBudget
    //---------------------------------------------------
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response putBudget(@PathParam("id") Integer _Id, Budget _Budget)
    {
        _Budget.setId(_Id);
        
        DatabaseManager.getDatabaseManager().updateBudget(_Budget);
        
        return Response.status(201).entity(_Budget).build();
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="deleteBudget">
    
    //---------------------------------------------------
    // deleteBudget
    //---------------------------------------------------
    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteBudget(@PathParam("id") Integer _Id)
    {
        boolean successful = DatabaseManager.getDatabaseManager().deleteBudget(_Id);
        
        return Response.status(201).entity(successful).build();
    }
    
    // </editor-fold>
}
