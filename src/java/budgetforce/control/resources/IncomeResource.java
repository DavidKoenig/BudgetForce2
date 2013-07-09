
package budgetforce.control.resources;

// <editor-fold defaultstate="collapsed" desc="imports">
import budgetforce.model.Income;
import budgetforce.model.DatabaseManager;
import budgetforce.model.EPeriod;

import javax.ws.rs.core.Response;

import javax.ws.rs.PathParam;
import javax.ws.rs.Path;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import java.util.ArrayList;
import java.util.List;
// </editor-fold>

/**
 * REST Web Service
 *
 * @author David König
 * 
 * i could write some things in one row, or without creating new variables, but i do it for a clear view / for better understanding my code 
 */
@Path("/income")
public class IncomeResource 
{

    public IncomeResource() 
    {
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Income getIncomeById(@PathParam("id") Integer _Id) 
    {
        return DatabaseManager.getDatabaseManager().getIncomeByID(_Id);
    }
    
    @GET
    @Path("/person/{id}")
    @Produces("application/json")
    public ArrayList<Income> getIncomeByPersonId(@PathParam("id") Integer _Id) 
    {    
        return DatabaseManager.getDatabaseManager().getIncomeByPersonID(_Id);
    }
    
    @GET
    @Path("/subincome/{id}")
    @Produces("application/json")
    public ArrayList<Income> getIncomeByIncomeId(@PathParam("id") Integer _Id) 
    {  
        return DatabaseManager.getDatabaseManager().getIncomeByIncomeID(_Id);
    }

    //post for a new entry
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postIncome(Income _Income) 
    {    
        //insert and get ID
        int id = DatabaseManager.getDatabaseManager().insertIncome(_Income);
        
        //insert and set ID to the instance
        _Income.setId(id);
        
        return Response.status(201).entity(_Income).build();
    }
    
    //put for updating an entry
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response putIncome(@PathParam("id") Integer _Id, Income _Income) 
    {
        _Income.setId(_Id);
        
        DatabaseManager.getDatabaseManager().updateIncome(_Income);
        
        return Response.status(201).entity(_Income).build();
    }
    
    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteIncome(@PathParam("id") Integer _Id) 
    {
        boolean successful = DatabaseManager.getDatabaseManager().deleteIncome(_Id);
        
        return Response.status(201).entity(successful).build();
    }
}
