package com.example.demo.resource;

import com.example.demo.model.Machine;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/machines")
public class MachineResource {

    private static List<Machine> machines = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Machine> getMachines() {
        return machines;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMachine(Machine machine) {
        machines.add(machine);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMachine(@PathParam("id") int id, Machine updatedMachine) {
        for (Machine machine : machines) {
            if (machine.getId() == id) {
                machine.setName(updatedMachine.getName());
                machine.setStatus(updatedMachine.getStatus());
                return Response.ok().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMachine(@PathParam("id") int id) {
        machines.removeIf(machine -> machine.getId() == id);
        return Response.noContent().build();
    }
}
