
package budgetforce.control;

// <editor-fold defaultstate="collapsed" desc="imports">
import budgetforce.model.Project;
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
@Path("/project")
public class ProjectResource {

    public ProjectResource() 
    {
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Project getProjectById(@PathParam("id") Integer _Id) 
    {
        Project project = new Project();
        
        project = DatabaseManager.getDatabaseManager().getProjectByID(_Id);
    
        return project;
    }

    //post to create a new entry
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postProject(Project _Project) 
    {       
        DatabaseManager.getDatabaseManager().insertProject(_Project);
        
        return Response.status(201).entity(_Project).build();
    }
    
    //put for updating an entry
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response putProject(@PathParam("id") Integer _Id, Project _Project) 
    {
        _Project.setId(_Id);
        DatabaseManager.getDatabaseManager().updateProject(_Project);
        
        return Response.status(201).entity(_Project).build();
    }
    
    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteProject(@PathParam("id") Integer _Id) 
    {
        boolean successful = DatabaseManager.getDatabaseManager().deleteProject(_Id);
        
        return Response.status(200).entity(successful).build();
    }
}