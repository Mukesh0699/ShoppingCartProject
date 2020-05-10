package com.niit.DAO;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Product;

@Repository("productDAO")
@Transactional

public class ProductDAOImpl implements ProductDAO {
@Autowired
SessionFactory sessionFactory;

public boolean addProduct(Product product)
{
// TODO Auto-generated method stub
try {
sessionFactory.getCurrentSession().save(product);
return true;
}
catch(Exception e) {
return false;
}
}


public boolean deleteProduct(Product product) {
// TODO Auto-generated method stub
try {
sessionFactory.getCurrentSession().delete(product);
return true;
}
catch(Exception e) {
return false;
}
}

public boolean updateProduct(Product product) {
	try {
		sessionFactory.getCurrentSession().update(product);
		return true;
		}
		catch(Exception e) {
		return false;
		}
}


public List<Product> listProducts() 
{
// TODO Auto-generated method stub
Session session=sessionFactory.openSession();
Query query=session.createQuery("from Product");
List<Product> listProducts=query.list();
session.close();
return listProducts;
}


public Product getProduct(int ProductId)
{
// TODO Auto-generated method stub
Session session=sessionFactory.openSession();
Product product=(Product)session.get(Product.class,ProductId);
session.close();
return product;
}
}



