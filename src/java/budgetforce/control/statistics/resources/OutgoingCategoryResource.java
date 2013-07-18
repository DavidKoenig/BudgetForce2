/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce.control.statistics.resources;

import budgetforce.model.statistics.StatisticOutgoingCategory;
import budgetforce.control.statistics.StatisticOutgoingCategoryController;

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
@Path("statistics/outgoingCategory/")
public class OutgoingCategoryResource {

    public OutgoingCategoryResource() 
    {
        
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public StatisticOutgoingCategory getOutgoingCategory(@PathParam("id") Integer _CategoryId) {
      
        return StatisticOutgoingCategoryController.getStatistic(_CategoryId);
        
    }

}
