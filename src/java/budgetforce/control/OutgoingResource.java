/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.control;

import budgetforce.model.Outgoing;
import budgetforce.model.DatabaseManager;

import java.util.ArrayList;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author David
 */
@Path("/outgoing")
public class OutgoingResource {

    public OutgoingResource() 
    {
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Outgoing getOutgoingById(@PathParam("id") Integer _Id)
    {    
        return DatabaseManager.getDatabaseManager().getOutgoingByID(_Id);      
    }
    
    @GET
    @Path("/person/{id}")
    @Produces("application/json")
    public ArrayList<Outgoing> getOutgoingByPersonId(@PathParam("id") Integer _Id)
    {
        return DatabaseManager.getDatabaseManager().getOutgoingByPersonId(_Id);
    }
    
    @GET
    @Path("/category/{id}")
    @Produces("application/json")
    public ArrayList<Outgoing> getOutgoingByCategoryId(@PathParam("id") Integer _Id)
    {
        return DatabaseManager.getDatabaseManager().getOutgoingByCategoryID(_Id);
    }
    
    @GET
    @Path("/tax/{id}")
    @Produces("application/json")
    public ArrayList<Outgoing> getOutgoingByTaxId(@PathParam("id") Integer _Id)
    {
        return DatabaseManager.getDatabaseManager().getOutgoing
    }
    
}
