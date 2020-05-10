package com.niit.DAO;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;

@Repository("categoryDAO")
@Transactional

public class CategoryDAOImpl implements CategoryDAO {
@Autowired
SessionFactory sessionFactory;

public boolean addCategory(Category category) 
{
// TODO Auto-generated method stub
try {
sessionFactory.getCurrentSession().save(category);
return true;
}
catch(Exception e) {
return false;
}
}


public boolean deleteCategory(Category category) {
// TODO Auto-generated method stub
try {
sessionFactory.getCurrentSession().delete(category);
return true;
}
catch(Exception e) {
return false;
}
}


public boolean updateCategory(Category category) {
// TODO Auto-generated method stub
try {
sessionFactory.getCurrentSession().update(category);
return true;
}
catch(Exception e) {
return false;
}
}



public List<Category> listCategories() {
// TODO Auto-generated method stub
Session session=sessionFactory.openSession();
Query query=session.createQuery("from Category");
List<Category> listCategories=query.list();
session.close();
return listCategories;
}


public Category getCategory(int CategoryId) {
// TODO Auto-generated method stub
Session session=sessionFactory.openSession();
Category category=(Category)session.get(Category.class,CategoryId);
session.close();
return category;
}

}
