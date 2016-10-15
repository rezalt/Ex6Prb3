/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Car;
import facade.carFacade;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author olls
 */
@Path("car")
public class CarResource
{

    
    carFacade fac = new carFacade(Persistence.createEntityManagerFactory("Ex6Prb3PU"));
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;
    /**
     * Creates a new instance of CarResource
     */
    public CarResource()
    {
      
    }

    /**
     * Retrieves representation of an instance of REST.CarResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCars()
    {
        
        List<Car> cars = fac.getCars();
        return gson.toJson(cars);
    }

    /**
     * PUT method for updating or creating an instance of CarResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content)
    {
    }
}
