/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.control.resources;

import budgetforce.control.FileHandle;
import budgetforce.model.Budget;
import budgetforce.model.DatabaseManager;
import budgetforce.model.login.Login;
import budgetforce.model.Outgoing;
import budgetforce.model.Receipt;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Soi Fon
 */
@Path("/outgoing/{outgoingID}/receipt")
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
        return DatabaseManager.getDatabaseManager().getReceiptByID(_Id);
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")    
    public Response uploadFile(@FormDataParam("file") InputStream uploadedInputStream, 
                               @FormDataParam("file") FormDataContentDisposition fileDetail,
                               @PathParam("outgoingID") int outgoingID) 
    {
        String fileDestination[];
        
        Outgoing outgoing = DatabaseManager.getDatabaseManager().getOutgoingByID(outgoingID);
        Budget budget = DatabaseManager.getDatabaseManager().getBudgetByID(outgoing.getBudgetId());
        Login login = DatabaseManager.getDatabaseManager().getLoginByPersonID(budget.getPersonId());      
    
        try 
        {
            FileHandle.CreateUserDirectory(login.getUsername());
            FileHandle.CreateUserSubDirectory(login.getUsername());
            fileDestination = FileHandle.CreateFile(uploadedInputStream, fileDetail.getFileName(),login.getUsername(), Receipt.NewReceiptID());
        } 
        catch (IOException ex) 
        {
            return Response.status(Response.Status.BAD_REQUEST).entity(null).build();
        }
        
        Receipt r = new Receipt();
        r.setPersonID(login.getPersondId());
        r.setOutgoingID(outgoingID);     
        r.setPath(fileDestination[0]);
        r.setFilename(fileDestination[1]);
        
        DatabaseManager.getDatabaseManager().insertReceipt(r);
        return Response.status(201).entity(r).build();
    }
    
    //put for updating an entry
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response putReceipt(@PathParam("id") Integer _Id, Receipt _Receipt) 
    {
        boolean successful = DatabaseManager.getDatabaseManager().updateReceipt(_Receipt);
        
        return Response.status(201).entity(successful).build();
    }
    
    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteReceipt(@PathParam("id") Integer _Id) 
    {
        boolean successful = DatabaseManager.getDatabaseManager().deleteReceipt(_Id);
        
        return Response.status(201).entity(successful).build();
    }
}
