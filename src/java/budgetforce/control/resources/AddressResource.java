
package budgetforce.control.resources;

// <editor-fold defaultstate="collapsed" desc="imports">
import budgetforce.model.Address;
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

import java.util.ArrayList;
// </editor-fold>

/**
 * REST Web Service
 *
 * @author David König
 */
@Path("/address")
public class AddressResource {

    public AddressResource() 
    {
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Address getAddressById(@PathParam("id") Integer _Id) 
    {
        return DatabaseManager.getDatabaseManager().getAddressByID(_Id);
    }

    @GET
    @Path("/person/{id}")
    @Produces("application/json")
    public ArrayList<Address> getAddressByPersonId(@PathParam("id") Integer _Id) 
    {
        return DatabaseManager.getDatabaseManager().getAddressByPersonID(_Id);
    }
    
    //post for creating a new entry
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postAddress(Address _Address) 
    {     
        int id = DatabaseManager.getDatabaseManager().insertAddress(_Address);
        
        _Address.setId(id);
        
        return Response.status(201).entity(_Address).build();
    }
    
    //put for updating an entry
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response putAddress(@PathParam("id") Integer _Id, Address _Address) 
    {
        _Address.setId(_Id);
        boolean successful = DatabaseManager.getDatabaseManager().updateAddress(_Address);
        
        return Response.status(201).entity(successful).build();
    }
    
    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteAddress(@PathParam("id") Integer _Id) 
    {
        boolean successful = DatabaseManager.getDatabaseManager().deleteAddress(_Id);
        
        return Response.status(201).entity(successful).build();
    }
}
