package com.example.demo.resource;

import com.example.demo.model.ProductionOrder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/orders")
public class ProductionOrderResource {

    private static List<ProductionOrder> orders = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductionOrder> getOrders() {
        return orders;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOrder(ProductionOrder order) {
        orders.add(order);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrder(@PathParam("id") int id, ProductionOrder updatedOrder) {
        for (ProductionOrder order : orders) {
            if (order.getId() == id) {
                order.setProduct(updatedOrder.getProduct());
                order.setQuantity(updatedOrder.getQuantity());
                order.setStartTime(updatedOrder.getStartTime());
                order.setEndTime(updatedOrder.getEndTime());
                order.setStatus(updatedOrder.getStatus());
                return Response.ok().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrder(@PathParam("id") int id) {
        orders.removeIf(order -> order.getId() == id);
        return Response.noContent().build();
    }
}
