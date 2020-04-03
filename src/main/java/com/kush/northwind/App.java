package com.kush.northwind;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Distinct;
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
        													 addAnnotatedClass(Employees.class).
        													 addAnnotatedClass(Suppliers.class).
        													 addAnnotatedClass(Categories.class);
        ServiceRegistry srv = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf = conf.buildSessionFactory(srv);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        
        /**
         * SELECT * FROM Customers
         */
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
       
        
        /**
         * SELECT * FROM employees;
         */

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
        
        /**
         * SELECT first_name from employees;
         */
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
        
        
        /**
         * Suppliers
         * SELECT city, country FROM suppliers;
         */
        
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
        
        /**
         * SELECT categoryName,description from categories;
         */
        Criteria criteria4 = session.createCriteria(Categories.class)
        		                    .setProjection(
        		                    		Projections.projectionList()
        		                    		       .add(Projections.property("categoryName"),"categoryName")
        		                    		       .add(Projections.property("description"),"description"));
        criteria4.setResultTransformer(Transformers.aliasToBean(CategoriesDTO.class));
        List<CategoriesDTO> d = criteria4.list();
        System.out.println("Categories:- "+ d.size());
        
        for (int i = 0; i < d.size(); i++) {
			//System.out.println(dto.get(i).getCity()+","+dto.get(i).getCounty()+","+dto.get(i).getCompanyName());
        		System.out.println(d.get(i).toString()); 
        }
        
        /**
         * SELECT DISTINCT country FROM customers;
         */
        Criteria c5 = session.createCriteria(Customer.class) 
        		              .setProjection(Projections.distinct(Projections.property("country")));
        List<String> distinctCountries = c5.list();
        
        System.out.println("Countries Distinct:- "+ distinctCountries.size());
        for(String country : distinctCountries ) {
        	System.out.println(country);
        }
        
        /**
         * SELECT DISTINCT city,country FROM customers;
         */
        Criteria c6 = session.createCriteria(Customer.class) 
	              .setProjection(Projections.distinct(Projections.projectionList()
	            		      .add(Projections.property("country"),"country")
	            		      .add(Projections.property("city"),"city")));
        c6.setResultTransformer(Transformers.aliasToBean(CountryCityDTO.class));
			List<CountryCityDTO> countryCityDTO = (List<CountryCityDTO>)c6.list();
			
			System.out.println("CountryCityDTO Distinct:- "+ countryCityDTO.size());
			for(CountryCityDTO country : countryCityDTO ) {
			System.out.println(country);
			}
			
			
		/**
		 * SELECT DISTINCT region FROM suppliers;
		 */
			 Criteria c7 = session.createCriteria(Suppliers.class) 
		              .setProjection(Projections.distinct(Projections.property("region")));
			List<String> distinctRegions = c7.list();
			
			System.out.println("distinctRegions Distinct:- "+ distinctRegions.size());
			for(String region : distinctRegions ) {
				System.out.println(region);
}
			/**
			 * HOW MANY CITIES are our Suppliers in
			 * SELECT DISTINCT COUNT(city) FROM suppliers;
			 */
			
			Criteria c8 = session.createCriteria(Suppliers.class) 
		              .setProjection(Projections.distinct(Projections.countDistinct("city")));
			List count = c8.list();
			
			System.out.println("Suppliers Region count:- "+ count.get(0));
//			for(String c : count ) {
//				System.out.println(c); 
//			}
          
        tx.commit();
        session.close();
    }
}
