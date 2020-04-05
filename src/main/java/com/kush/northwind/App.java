package com.kush.northwind;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.OrderBy;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Distinct;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;

import dto.CategoriesDTO;
import dto.CompanyOrderDTO;
import dto.CompanyOrderDateShipCountryDTO;
import dto.CountryCityDTO;
import dto.CustomerContactDTO;
import dto.FirstLastOrderDTO;
import dto.MultipleTableDTO;
import dto.OrdersDateDifferenceDTO;
import dto.ProductNameOrderIdDTO;
import dto.ProductNameSupplierDetailsDTO;
import dto.SupplierDTO;
import entities.Categories;
import entities.Customer;
import entities.Employees;
import entities.OrderDetails;
import entities.Orders;
import entities.Products;
import entities.Suppliers;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("unchecked")
	public static void main( String[] args ) throws ParseException
    {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Customer.class).  
        													 addAnnotatedClass(Employees.class).
        													 addAnnotatedClass(Suppliers.class).
        													 addAnnotatedClass(Categories.class)
															.addAnnotatedClass(Products.class)
															.addAnnotatedClass(Orders.class)
															.addAnnotatedClass(OrderDetails.class);
        
        
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
		              .setProjection(Projections.countDistinct("city"));
			List count = c8.list();
			
			System.out.println("Suppliers Region count:- "+ count.get(0));
//			for(String c : count ) {
//				System.out.println(c); 
//			}
			
			/**
			 * SELECT COUNT(*) FROM products
			 */
			Criteria productsCount = session.createCriteria(Products.class).setProjection(Projections.rowCount());
			List countRows =  productsCount.list();
			System.out.println("Product Rows"+ countRows.get(0));
			
			/**
			 * SELECT COUNT(*) FROM ORDERS
			 */
			
			Criteria ordersCriteria = session.createCriteria(Orders.class)
										.setProjection( Projections.rowCount());
			List orderCount = ordersCriteria.list();
			System.out.println("Order Count"+ orderCount);
			
			/**
			 * How many Distinct Products have been ordered
			 * SELECT DISTINCT COUNT(productid) FROM order_details;
			 */
			Criteria distinctProductsOrdered = session.createCriteria(OrderDetails.class)
													  .setProjection(Projections.countDistinct("productid"));
			List countProductsDistinct = distinctProductsOrdered.list();
			System.out.println("countProductsDistinct "+ countProductsDistinct);
			
			
			/**
			 * List aor customerid and difference between ship date and order date for all our orders
			 * SELECT customerid,  shippeddate - orderdate from orders 
			 */
			
			Criteria differenceDates = session.createCriteria(Orders.class)
					                          .setProjection(Projections.projectionList()
					                        		            .add(Projections.property("customerid"),"customerid")
					                        		            .add(Projections.property("differenceDates"),"differenceDates"))
					                          					.add(Restrictions.isNotNull("differenceDates"));
			
			
			differenceDates.setResultTransformer(Transformers.aliasToBean(OrdersDateDifferenceDTO.class));
				List<OrdersDateDifferenceDTO> ordersDateDifferenceDTO = (List<OrdersDateDifferenceDTO>)differenceDates.list();
				
				System.out.println("OrdersDateDifferenceDTO :- "+ ordersDateDifferenceDTO.size());
				int i = 1;
				for(OrdersDateDifferenceDTO diff : ordersDateDifferenceDTO ) {
				System.out.println(i+" " +diff.getCustomerid() +","+ diff.getDifferenceDates());
				i++;
				}
				
				/**
				 * SELECT companyname from Suppliers WHERE city = 'Berlin';
				 */
				Criteria res_one = session.createCriteria(Suppliers.class)
										  .setProjection(Projections.property("companyName"))
										  .add(Restrictions.eq("city", "Berlin"));
				List<String> data = res_one.list();
				System.out.println("Data Size: "+data.size());
				for(String s : data) {
					System.out.println("Data:- "+s);
				}
				
				/**
				 * Find all customer names and Contacts that we have in Mexico from customers
				 * 
				 */
				Criteria cj = session.createCriteria(Customer.class) 
						             .setProjection(Projections.projectionList()   
						            		 .add(Projections.property("companyName"),"companyName")  
						            		 .add(Projections.property("contactName"),"contactName")) 
						             		 .add(Restrictions.eq("country", "Mexico"));
				cj.setResultTransformer(Transformers.aliasToBean(CustomerContactDTO.class));
				List<CustomerContactDTO> dto_ = (List<CustomerContactDTO>)cj.list();
				System.out.println(dto_.size());
				for(CustomerContactDTO datax : dto_) {
					System.out.println(datax.getCompanyName() +" "+ datax.getContactName());
				}
				
				/**
				 * Find Orders ordered by employee ID 3
				 */
				Criteria qw = session.createCriteria(Orders.class) 
													.add(Restrictions.eq("employeeid",3));
				List<Orders> orderByCustomer = qw.list();
				System.out.println(orderByCustomer.size());
				for(Orders x : orderByCustomer) {
					System.out.println(x.toString());
				}
				
				/**
				 * SeLECT COUNT(*) FROM order_details WHERE quantity>20;
				 */
				 
					Criteria qas = session.createCriteria(OrderDetails.class) 
														.add(Restrictions.gt("quantity",20));
					List<OrderDetails> orderDetails = qas.list();
					System.out.println(orderDetails.size());
					for(OrderDetails  x : orderDetails) {
						System.out.println(x.toString());
					}
					
					/**
					 * freight
					 * How many orders had a  freight cost equals to or greater than 250
					 */
					Criteria qq = session.createCriteria(Orders.class) 
							.add(Restrictions.ge("freight", (float)250));
							List<Orders> od = qq.list();
							System.out.println(od.size());
							for(Orders  x : od) {
							System.out.println(x.toString());
							}
						

							/**
							 * No of Order that were ordered on or after January 01, 1998
							 */
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							 Date date = formatter.parse("1998-01-01");
							Criteria qqorferdate = session.createCriteria(Orders.class) .add(Restrictions.ge("orderdate", date));  //1996-07-04
									List<Orders> dateorder = qqorferdate.list();
									System.out.println(dateorder.size());
//									for(Orders  x : dateorder) {
//									System.out.println(x.toString());
//									}
						
									
				/**
				 * How many orders were shipped to Germany and the freight costs more than 100
				 */
				Criteria operatorAnd = session.createCriteria(Orders.class) 
											  .add(Restrictions.eq("shipcountry", "Germany"))
											  .add(Restrictions.gt("freight", (float)100));
				List<Orders> total = operatorAnd.list();
				System.out.println("And Size:- " + total.size());
				
				
				/**
				 * We want the distinc customers where orders were shipped shipped via united packaa id =2 and
				 * the ship country is brazil
				 */
				Criteria operatorAndtwo = session.createCriteria(Orders.class)
						  .setProjection(Projections.distinct(Projections.property("customerid")))
						  .add(Restrictions.eq("shipcountry", "Brazil"))
						  .add(Restrictions.gt("shipvia", 2));
					List<Orders> totalTwo = operatorAndtwo.list();
					System.out.println("And Two Size:- " + totalTwo.size());
				
				/**
				 * Logical OR
				 * criteria.add(Restrictions.disjunction()
                        .add(Restrictions.eq("bill.stateCd", null))
                        .add(Restrictions.eq("bill.stateCd", ""))
                        .add(Restrictions.ilike("bill.stateCd","%"+stateCd+"%")));
                        How may Suppliers do we have in Germany and Spain
				 */
				Criteria or = session.createCriteria(Suppliers.class) 
						             .add(Restrictions.disjunction()
						            		 .add(Restrictions.eq("country", "Spain"))
						            		 .add(Restrictions.eq("country", "Germany"))
						            		 );
				List<Suppliers>listOr = or.list();
				System.out.println("OR Size "+listOr.size());
				
				
				/**
				 * Logical not Operators
				 * add(Restrictions.ne("description","Mouse")); not equal to
				 * Restrictions.between("DATE(auditDate)", sDate, eDate)); between
				 * How many orders are shipped to Germany and fright charges less than 50 and greater than 175
				 */
				Criteria mix = session.createCriteria(Orders.class) 
						              .add(Restrictions.eq("shipcountry", "Germany"))
						              .add(Restrictions.disjunction()
						            		  .add(Restrictions.lt("freight", (float)50))
						            		  .add(Restrictions.ge("freight", (float)175)) 
						            		  );
						             		 
				List<Orders> misOrders = mix.list();
				System.out.println("Mix results: "+misOrders.size());
				
				
				/**
				 * In Clause using array
				 * String[] employeeNames = { "test", "test2" };
					List<Survey> surveys = getSession().createCriteria(Survey.class).add(
					        Restrictions.and
					        (
					            Restrictions.eq("surveyNumber", 1),
					            Restrictions.in("employeeName", employeeNames)
					        )
					    ).list();
				 */
				
				/**
				 * SELECT country FROM suppliers ORDER BY country ASC/DESC
				 * SELECT country, city FROM suppliers ORDER BY country ASC, city DESC
				 * GET a list of product names and unit prices order by price highest to lowest and product name (a to Z ) asc
				 * SELECT productname, unitprices from products ORDER BY price DESC , productname  asc
				 * 
				 * Criteria crit = session.createCriteria(Product.class);
								crit.add(Restrictions.gt("price",10.0));
								crit.addOrder(Order.desc("price"));
								List<Product> results = crit.list();
				 */
				Criteria asc = session.createCriteria(Suppliers.class).setProjection(Projections.distinct(Projections.property("country")))
																	  .addOrder(Order.asc("country"));
				List<String> ascDate = asc.list();
				for(String datas : ascDate) {
					System.out.println(datas);
				}
				
				Criteria asc2 = session.createCriteria(Suppliers.class)
												.setProjection( 
															Projections.distinct(
																	Projections.projectionList()
																	.add(Projections.property("country"),"country")
																	.add(Projections.property("city"),"city")))
																	.addOrder(Order.asc("country"))
																	.addOrder(Order.desc("city"))
																	.setMaxResults(100);
				asc2.setResultTransformer(Transformers.aliasToBean(CountryCityDTO.class));
																	
				List<CountryCityDTO> ascDate2 = asc2.list();
				System.out.println(ascDate2.size());
				for(CountryCityDTO datas : ascDate2) {
					System.out.println(datas.getCountry()+","+datas.getCity());
				}
								
				
				
				
				/**
				 * Min and Max 
				 * SEelct min(orderdate) from orders Where country = 'Italy';
				 * SELECT MAX(orderdate) from orders Where counrty = 'Canada';
				 * SELECT MAX(shipdate - orderdate) as lowest from orders where country = france 
				 * 
				 * 
				 */
				
				
				/**
				 * Average and Sum
				 * SELECT AVG(freight) from orders WHERE shipcountry= 'Brazil';
				 * Criteria crit = session.createCriteria(Product.class);
					ProjectionList projList = Projections.projectionList();
					projList.add(Projections.max("price"));
					projList.add(Projections.min("price"));
					projList.add(Projections.avg("price"));
					projList.add(Projections.countDistinct("description"));
					crit.setProjection(projList);
					List<object[]> results = crit.list();
				 */
				
				
				/**
				 *  'a%' == starts with a
				 *  '%e' == ends with a
				 *  'a%e' == starts with a and ends with e
				 *  '%bob%'  == all string which contains bob
				 *  '_a%'  == has a has a second character
				 *  'E_%_%' ==Starts with E and has atleast two other letters 
				 *  What customers have a contact whode firt name start with D
				 */
				
				/**
				 * limit = setMax results
				 */
				
				
				/**
				 * -- Bring Back Company Name, Order name and Ship Country
						SELECT companyname, orderdate,shipcountry
						FROM customers
						INNER JOIN orders
						ON orders.customerid = customers.customerid;
				 */
				
				Criteria joinTest = session.createCriteria(Customer.class) 
						                   .createAlias("orders", "orders")
						                   .setProjection(Projections.projectionList() 						                		   					 
						                		   .add(Projections.property("companyName"),"companyname")
					                		   					 .add(Projections.property("orders.orderdate"),"orderdate") 
						                		   				 .add(Projections.property("orders.shipcountry"),"shipcountry"));
				joinTest.setResultTransformer(Transformers.aliasToBean(CompanyOrderDateShipCountryDTO.class));
				List<Customer> joindata = joinTest.list();
				
				
				System.out.println(" Join Data " +joindata.size());
				
				/**
				 * Connect Employees to Orders and Pull back first name, last name and order date for all orders
				 * SELECT companyname, orderdate,shipcountry
						FROM customers
						INNER JOIN orders
						ON orders.customerid = customers.custome
				 */
				Criteria joinTest2 = session.createCriteria(Employees.class)
						                    .createAlias("orders_employees", "oe")
						                    .setProjection(
						                    		Projections.projectionList().
						                    		add(Projections.property("first_name"),"firstName").
						                    		add(Projections.property("last_name"),"lastName").
						                    		add(Projections.property("oe.orderdate"),"orderDate"));
				joinTest2.setResultTransformer(Transformers.aliasToBean(FirstLastOrderDTO.class));
				List<FirstLastOrderDTO> joinTestData = joinTest2.list();
				System.out.println("Second One"+joinTestData.size());
				
				for(FirstLastOrderDTO datas : joinTestData) {
					System.out.println(datas.getFirstName()+","+datas.getLastName()+","+datas.getOrderDate());
				}
				
				
				/**
				 * -- Connect Products to Suppliers and Pull back Company Name , Unit Stock and Units in Stock
						SELECT companyname,productname,unitsinstock,unitprice
						FROM products as pro
						INNER JOIN suppliers as sup
						ON pro.supplierid = sup.supplierid;
				 */
				//ProductNameSupplierDetailsDTO
				Criteria joinLearn = session.createCriteria(Products.class) 
						                    .createAlias("suppliers_", "suppliers")
						                    .setProjection( 
						                    		Projections.projectionList()
						                    		.add(Projections.property("unitsinstock"),"unitsinstock")
						                    		.add(Projections.property("unitprice"),"unitprice")
						                    		.add(Projections.property("suppliers.companyName"),"companyname")
						                    		
						                    		);
				joinLearn.setResultTransformer(Transformers.aliasToBean(ProductNameSupplierDetailsDTO.class));
				List<ProductNameSupplierDetailsDTO> jd = joinLearn.list();
				System.out.println("Third Join One"+jd.size());
				
				for(ProductNameSupplierDetailsDTO datas : jd) {
					System.out.println(datas.getCompanyname()+","+datas.getUnitprice()+","+datas.getUnitsinstock());
				}
						                    
				/**
				 * 
				 * --Inner Joins For Multiple Tables
					--Connect Customers,Orders,OrderDetails
					-- Bring back company name , order date, product id, unit price ,  Quantity 
					
					SELECT companyname , orderdate, productid, unitprice , quantity
					FROM customers c 
					INNER JOIN orders o ON c.customerid = o.customerid 
					INNER JOIN order_details od ON o.orderid = od.orderid;
				 */
				Criteria threetables = session.createCriteria(Customer.class) 
						                      .createAlias("orders", "order")  
						                      .createAlias("order.order_details", "order_details") 
						                      .createAlias("order_details.products", "products") 
						                      .setProjection(  
						                    		  Projections.projectionList()
						                    		  .add(Projections.property("companyName"),"companyName")  
						                    		  .add(Projections.property("order.orderdate"),"orderdate")
						                    		  .add(Projections.property("order_details.unitprice"),"unitprice")
						                    		  .add(Projections.property("order_details.productid"),"productid")
						                    		  .add(Projections.property("order_details.quantity"),"quantity")
						                    		  .add(Projections.property("products.productname"),"productname")
						                    		  );
						                     
						                      //.setMaxResults(10);
				threetables.setResultTransformer(Transformers.aliasToBean(MultipleTableDTO.class));
				List<MultipleTableDTO> mul = threetables.list();
				System.out.println("MultipleTableDTO"+mul.size());
				
				for(MultipleTableDTO datas : mul) {
					System.out.println(datas.getCompanyName()+","+datas.getOrderdate()+","+datas.getUnitprice()+","+datas.getProductid()+","+datas.getProductname()+","+datas.getQuantity());
				}	     
				
				/**
				 * Left Join
				 * SELECT companyname , orderid
					FROM customers as cs
					LEFT JOIN orders od ON od.customerid = cs.customerid;
				 */
				
				Criteria leftJoin = session.createCriteria(Customer.class) 
											.createAlias("orders", "order", JoinType.LEFT_OUTER_JOIN) 
											.setProjection(Projections.projectionList()  
																	  .add(Projections.property("companyName"),"companyName") 
																	  .add(Projections.property("order.orderid"),"orderid")
													);
				leftJoin.setResultTransformer(Transformers.aliasToBean(CompanyOrderDTO.class));
				List<CompanyOrderDTO> mulx = leftJoin.list();
				System.out.println("leftJoin @!@!"+mulx.size()); 
				
				for(CompanyOrderDTO datas : mulx) {
					System.out.println(datas.getCompanyName()+","+datas.getOrderid());
				}	  
				
				/**
				 * Do a Left Join between Products and Orger_details  order_details
				 */
				Criteria secondLeft = session.createCriteria(Products.class) 
											 .createAlias("order_details", "od", JoinType.LEFT_OUTER_JOIN)
											 .setProjection(Projections.projectionList() 
													 					.add(Projections.property("productname"),"productname") 
													 					.add(Projections.property("od.orderid"),"orderid") 
													 					)
											 .add(Restrictions.isNull("od.orderid"));
				
				secondLeft.setResultTransformer(Transformers.aliasToBean(ProductNameOrderIdDTO.class));
				List<ProductNameOrderIdDTO> mulxx = secondLeft.list();
				System.out.println("leftJoin  @!@!"+mulxx.size()); 
				
				for(ProductNameOrderIdDTO datas : mulxx) {
					System.out.println(datas.getProductname()+","+datas.getOrderid());
				}	 
				
			
				/**
				 * Right Joins
				 * ----Right Joins
					--Pulls back matching records in the first table and all records in second table
					--Bring back Companyname, orderid using reverse table orederfrom last session
					
					SELECT companyname , orderid
					FROM orders as od 
					RIGHT JOIN customers as cs ON od.customerid = cs.customerid
					WHERE od.orderid IS NULL;
					
					--Do a Rigt Join Between Customer Demo and Customers
					SELECT companyname, cd.customerid FROM 
					customercustomerdemo as cd
					RIGHT JOIN customers as cs  
					ON cs.customerid = cd.customerid;
				 */
				Criteria rightJoin = session.createCriteria(Orders.class) 
						.createAlias("cname", "c",JoinType.RIGHT_OUTER_JOIN)
						.setProjection(Projections.projectionList()  
												  .add(Projections.property("orderid"))
												 // .add(Projections.property("customerid"))
												  .add(Projections.property("c.companyName"),"companyName")
												  
								);
				rightJoin.setResultTransformer(Transformers.aliasToBean(CompanyOrderDTO.class));
				List<CompanyOrderDTO> mulxr = rightJoin.list();
				System.out.println("Right Join @!@!"+mulxr.size()); 
//				
//				for(CompanyOrderDTO datas : mulxr) {
//				System.out.println(datas.getCompanyName()+","+datas.getOrderid());
//						}	  
				
				
          
        tx.commit();	
        session.close();
    }
}
