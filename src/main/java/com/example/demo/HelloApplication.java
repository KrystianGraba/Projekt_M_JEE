package com.example.demo;

import com.example.demo.resource.MachineResource;
import com.example.demo.resource.ProductionOrderResource;
import com.example.demo.resource.ReportResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class HelloApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(HelloResource.class);
        classes.add(MachineResource.class);
        classes.add(ProductionOrderResource.class);
        classes.add(ReportResource.class);
        return classes;
    }
}
