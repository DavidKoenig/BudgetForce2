
package budgetforce.control.resources;

// <editor-fold defaultstate="collapsed" desc="imports">
import budgetforce.model.Login;
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
@Path("/login")
public class LoginResource {

    public LoginResource() 
    {
    }

    @GET
    @Path("{user}/{password}")
    @Produces("application/json")
    public int login(@PathParam("user") String _Username, @PathParam("password") String _Password) 
    {
        Login login = DatabaseManager.getDatabaseManager().getLoginByUsername(_Username);
        
        if (login.getPassword().equals(_Password))  return login.getPersondId();
        else                                        return 0;
    }

    //post for creating a new entry
    @POST
    @Path("/create")
    @Consumes("application/json")
    @Produces("application/json")
    public Response postLogin(Login _Login) 
    {     
        int id = DatabaseManager.getDatabaseManager().insertLogin(_Login);
        
        _Login.setId(id);
        
        return Response.status(201).entity(_Login).build();
    }
    
    //put for updating an entry
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response putLogin(@PathParam("id") Integer _Id, Login _Login) 
    {
        _Login.setId(_Id);
        boolean successful = DatabaseManager.getDatabaseManager().updateLogin(_Login);
        
        return Response.status(201).entity(successful).build();
    }
    
    @DELETE
    @Path("{username}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteLogin(@PathParam("id") String _Username) 
    {
        boolean successful = DatabaseManager.getDatabaseManager().deleteLogin(_Username);
        
        return Response.status(201).entity(successful).build();
    }
}
