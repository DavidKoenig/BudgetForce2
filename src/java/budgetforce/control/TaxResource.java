
package budgetforce.control;

// <editor-fold defaultstate="collapsed" desc="imports">
import budgetforce.model.Tax;
import budgetforce.model.DatabaseManager;

import javax.ws.rs.core.Response;

import javax.ws.rs.PathParam;
import javax.ws.rs.Path;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
// </editor-fold>

/**
 * REST Web Service
 *
 * @author David König
 */
@Path("/tax")
public class TaxResource {

    public TaxResource() 
    {
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Tax getTaxById(@PathParam("id") Integer _Id) 
    {
        Tax tax = new Tax();
        
        tax = DatabaseManager.getDatabaseManager().getTaxByID(_Id);
    
        return tax;
    }

    //post for creating a new entry
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postTax(Tax _Tax) 
    {     
        int id = DatabaseManager.getDatabaseManager().insertTax(_Tax);
        
        _Tax.setId(id);
        
        return Response.status(201).entity(_Tax).build();
    }
    
    //put for updating an entry
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response putTax(@PathParam("id") Integer _Id, Tax _Tax) 
    {
        _Tax.setId(_Id);
        DatabaseManager.getDatabaseManager().updateTax(_Tax);
        
        return Response.status(201).entity(_Tax).build();
    }
    
    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteTax(@PathParam("id") Integer _Id) 
    {
        boolean successful = DatabaseManager.getDatabaseManager().deleteTax(_Id);
        
        return Response.status(201).entity(successful).build();
    }
}
