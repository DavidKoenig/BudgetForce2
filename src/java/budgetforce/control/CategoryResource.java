
package budgetforce.control;

// <editor-fold defaultstate="collapsed" desc="imports">
import budgetforce.model.Category;
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
@Path("/category")
public class CategoryResource {

    public CategoryResource() 
    {
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Category getCategoryById(@PathParam("id") Integer _Id) 
    {
        Category category = new Category();
        
        category = DatabaseManager.getDatabaseManager().getCategoryByID(_Id);
    
        return category;
    }

    //post for creating a new entry
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postCategory(Category _Category) 
    {     
        int id = DatabaseManager.getDatabaseManager().insertCategory(_Category);
        
        _Category.setId(id);
        
        return Response.status(201).entity(_Category).build();
    }
    
    //put for updating an entry
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response putCategory(@PathParam("id") Integer _Id, Category _Category) 
    {
        _Category.setId(_Id);
        boolean successful = DatabaseManager.getDatabaseManager().updateCategory(_Category);
        
        return Response.status(201).entity(successful).build();
    }
    
    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteCategory(@PathParam("id") Integer _Id) 
    {
        boolean successful = DatabaseManager.getDatabaseManager().deleteCategory(_Id);
        
        return Response.status(201).entity(successful).build();
    }
}
