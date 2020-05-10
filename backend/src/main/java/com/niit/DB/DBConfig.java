package com.niit.DB;

import java.util.Properties;

import javax.sql.DataSource;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.DAO.CategoryDAOImpl;
import com.niit.DAO.ProductDAOImpl;
import com.niit.DAO.SupplierDAOImpl;
import com.niit.DAO.UserDAOImpl;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {
	
	@Bean(name="DataSource")
	public DataSource getH2DataSource(){
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasource.setUsername("sa");
		datasource.setPassword("");
		System.out.println("Data Source");
		return datasource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(){
		
		Properties hproperties = new Properties();
		hproperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hproperties.setProperty("hibernate.hbm2ddl.auto", "update");//if create is used tables will be created newly everytime
		
		LocalSessionFactoryBuilder localsession = new LocalSessionFactoryBuilder(getH2DataSource());
		localsession.addProperties(hproperties);
		localsession.addAnnotatedClass(Category.class);
		localsession.addAnnotatedClass(Supplier.class);
		localsession.addAnnotatedClass(Product.class);
		localsession.addAnnotatedClass(User.class);
		
		SessionFactory sessionfactory = localsession.buildSessionFactory();
		System.out.println("Session Factory");

		return sessionfactory;
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionfactory){

System.out.println("Transaction Manager");
		return new HibernateTransactionManager(sessionfactory);
	}
	
	@Bean(name="categoryDAO")
	public CategoryDAOImpl getCategoryDAOImplementation(){
		return new CategoryDAOImpl();
	}
	
	@Bean(name="supplierDAO")
	public SupplierDAOImpl getSupplierDAOImplementation(){
		return new SupplierDAOImpl();
	}
	
	@Bean(name="productDAO")
	public ProductDAOImpl getProductDAOImplementation(){
		return new ProductDAOImpl();
	}
	
	@Bean(name="userDAO")
	public UserDAOImpl getUserDAOImplementation(){
		return new UserDAOImpl();
	}

}