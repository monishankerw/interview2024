package com.crudExample.corejava.microservices;

/**
 * Microservices vs Monolithic Architecture Explanation
 *   In a monolithic architecture, the entire application is built as a single, unified codebase.
 *            All components are tightly integrated, meaning any change or failure in one part often affects the entire system. Scaling requires scaling the entire application, not just the parts that need it.
 *           In contrast, microservices.md allow modularity and independence. Each service can be developed, deployed, and scaled independently, which makes the system more flexible, scalable, and maintainable, especially for large and complex applications.
 */
public class Articture {

    public static void main(String[] args) {
        MonoliticArtic m=new MonoliticArtic();
        m.monoartic();

        MicroService serviceA=new  MicroService("UserService");
        MicroService serviceB=new  MicroService("OrderService");
        MicroService serviceC=new  MicroService("PaymentService");
        serviceA.execute();
        serviceB.execute();
        serviceC.execute();
    }



}

class MonoliticArtic{
    public void monoartic() {
        System.out.println("In a monolithic architecture, the entire application is built as a single, unified codebase.\n"
                + " *  All components are tightly integrated, "
                + "meaning any change or failure in one part often affects the entire system."
                + " Scaling requires scaling the entire application, not just the parts that need it. ");
    }
}

class MicroService{
    private String service;

    public MicroService(String service) {
        this.service = service;
    }

    public void execute() {
        System.out.println("In contrast, microservices.md allow modularity and independence. "
                + "Each service can be developed, deployed, and scaled independently,"
                + " which makes the system more flexible, scalable, and maintainable, especially for large and complex applications.\n"
                + "");
    }
}

