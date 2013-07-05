/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.control;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import budgetforce.model.*;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author kinske
 */
@Path("/test2")
public class Test2Resource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Test2Resource
     */
    public Test2Resource() {
    }

    /**
     * Retrieves representation of an instance of budgetforce.control.Test2Resource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/get")
    @Produces("application/json")
    public Person getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        Person person = new Person();
        person.setEmail("test@test.de");
        person.setFirstName("hans");
        person.setLastName("wurst");
        person.setPhone1("01345");
        person.setPhone2("");
        
        return person;
    }

    /**
     * PUT method for updating or creating an instance of Test2Resource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Path("/post")
    @Consumes("application/json")
    public Response postJson(String _Person) {
        
        //Person person = new Person();
        //person = _Person;
        
        //DatabaseManager.getDatabaseManager().insertPerson(person);
        String result = "Person: " + _Person;
        return Response.status(201).entity(_Person).build();
    }
}
