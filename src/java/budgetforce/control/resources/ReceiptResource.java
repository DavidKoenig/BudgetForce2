/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.control.resources;

import budgetforce.model.DatabaseManager;
import budgetforce.model.Receipt;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Soi Fon
 */
@Path("/receipt")
public class ReceiptResource 
{

    public ReceiptResource() 
    {
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Receipt getReceiptById(@PathParam("id") Integer _Id) 
    {
        //return DatabaseManager.getDatabaseManager().getReceiptByID(_Id);
        return new Receipt();
    }

    //post for creating a new entry
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postReceipt(Receipt _Receipt) 
    {     
        //int id = DatabaseManager.getDatabaseManager().insertReceipt(_Receipt);
        
        return Response.status(201).entity(_Receipt).build();
    }
    
    //put for updating an entry
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response putReceipt(@PathParam("id") Integer _Id, Receipt _Receipt) 
    {
        boolean successful = true;//DatabaseManager.getDatabaseManager().updateReceipt(_Receipt);
        
        return Response.status(201).entity(successful).build();
    }
    
    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteReceipt(@PathParam("id") Integer _Id) 
    {
        boolean successful = true;//DatabaseManager.getDatabaseManager().deleteReceipt(_Id);
        
        return Response.status(201).entity(successful).build();
    }
}
