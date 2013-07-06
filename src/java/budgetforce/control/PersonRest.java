/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.control;

import budgetforce.model.Person;
import budgetforce.model.DatabaseManager;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;

import javax.ws.rs.PathParam;
import javax.ws.rs.Path;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;


/**
 * REST Web Service
 *
 * @author David König
 */
@Path("/person")
public class PersonRest {

    public PersonRest() 
    {
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Person getPerson(@PathParam("id") Integer _Id) 
    {
        Person person = new Person();
        
        person = DatabaseManager.getDatabaseManager().getPersonByID(_Id);
    
        return person;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postPerson(Person _Person) 
    {
            
        DatabaseManager.getDatabaseManager().insertPerson(_Person);
        
        return Response.status(201).entity(_Person).build();
    }
    
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response putPerson(@PathParam("id") Integer _Id, Person _Person) {
        
        _Person.setId(_Id);
        DatabaseManager.getDatabaseManager().updatePerson(_Person);
        
        return Response.status(201).entity(_Person).build();
    }
    
    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response putPerson(@PathParam("id") Integer _Id) {
        
        
        boolean successful = DatabaseManager.getDatabaseManager().deletePerson(_Id);
        
        return Response.status(201).entity(successful).build();
    }
}
