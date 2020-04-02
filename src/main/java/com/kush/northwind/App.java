package com.kush.northwind;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("unchecked")
	public static void main( String[] args )
    {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Customer.class).
        													 addAnnotatedClass(Employees.class).addAnnotatedClass(Suppliers.class);
        ServiceRegistry srv = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf = conf.buildSessionFactory(srv);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Criteria cr = session.createCriteria(Customer.class);
        List<Customer> results = cr.list();
        
        for(Customer customer : results ) {
        	System.out.println(customer.getCutomer_id()+","+
        			customer.getCompanyName()+","+
        			customer.getContactName()+","+
        			customer.getContactTitle()+","+
        			customer.getAddress()+","+
        			customer.getCity()+","+
        			customer.getPostalcode()+","+
        			customer.getPhone()+","+
        			customer.getFax()+","+
        			customer.getCountry()+",");
        }
        System.out.println(" Size:  "+ results.size());
//        
////        Customer customer = (Customer)session.get(Customer.class, "ALFKI");
////        System.out.println(customer.toString());
        Criteria cr2 = session.createCriteria(Employees.class);
        List<Employees> employees = cr2.list();
        
        System.out.println("\n \n"+" Employee List Size:  "+ employees.size());
        for(Employees employee : employees) {
        	System.out.println(employee.getEmployeeid()+","+
        			employee.getLast_name()+","+
        			employee.getFirst_name()+","+
        			employee.getTitle()+","+
        			employee.getTitleOfCourtsey()+","+
        			employee.getBirthDate()+","+
        			employee.getHireDate()+","+
        			employee.getAddress()+","+
        			employee.getCity()+","+
        			employee.getRegion()+","+
        			employee.getPincode()+","+
        			employee.getCountry()+","+
        			employee.getHomephone()+","+
        			employee.getExtention()+",##"+
        			employee.getPhoto()+",-##"+
        			employee.getNotes()+","+
        			//employee.getReportsto()+","+
        			employee.getPhotopath());
        }
//        
        Criteria cr3 = session.createCriteria(Employees.class);
        cr3.setProjection(Projections.property("first_name"));
//        //In case of multiple filters we use projection list
////        Projections.projectionList()
////        .add(Projections.property("id"), "id")
////        .add(Projections.property("Name"), "Name")
//        
//       // cr3.setResultTransformer(Transformers.aliasToBean(Employees.class));
        List<String> employees_projection = cr3.list();
        
        for(String name : employees_projection) {
        	System.out.println("Employee  Name "+ name); 
        }
        
        //Suppliers
        
        Criteria supplierCritera = session.createCriteria(Suppliers.class)
        		.setProjection(
        				Projections.projectionList()
        				      .add(Projections.property("city"),"city")
        				      .add(Projections.property("country"),"country")
        				      .add(
        				    		  Projections.property("companyName"),"companyName"));
        supplierCritera.setResultTransformer(Transformers.aliasToBean(SupplierDTO.class));
        
        List<SupplierDTO> dto = supplierCritera.list();
        System.out.println("supplier:- "+ dto.size());
        
        for (int i = 0; i < dto.size(); i++) {
			//System.out.println(dto.get(i).getCity()+","+dto.get(i).getCounty()+","+dto.get(i).getCompanyName());
        		System.out.println(dto.get(i).toString()); 
        }
          
        tx.commit();
        session.close();
    }
}
