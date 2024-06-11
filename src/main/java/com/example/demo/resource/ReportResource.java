package com.example.demo.resource;

import com.example.demo.model.Report;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/reports")
public class ReportResource {

    private static List<Report> reports = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Report> getReports() {
        return reports;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addReport(Report report) {
        reports.add(report);
        return Response.status(Response.Status.CREATED).build();
    }
}
