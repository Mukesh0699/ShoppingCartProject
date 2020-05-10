package com.niit.DAO;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;

@Repository("userDAO")
@Transactional

public class UserDAOImpl implements UserDAO {
@Autowired
SessionFactory sessionFactory;

public boolean addUser(User user) {
// TODO Auto-generated method stub
try {
sessionFactory.getCurrentSession().save(user);
return true;
}
catch(Exception e) {
return false;
}
}
public boolean deleteUser(User user) {
// TODO Auto-generated method stub
try {
sessionFactory.getCurrentSession().delete(user);
return true;
}
catch(Exception e) {
return false;
}
}

public boolean updateUser(User user) {
// TODO Auto-generated method stub
try {
sessionFactory.getCurrentSession().update(user);
return true;
}
catch(Exception e) {
return false;
}
}

public List<User> listUsers() {
// TODO Auto-generated method stub
Session session=sessionFactory.openSession();
Query query=session.createQuery("from User");
List<User> listUsers=query.list();
session.close();
return listUsers;
}

public User getUser(int UserId) {
// TODO Auto-generated method stub
Session session=sessionFactory.openSession();
User user=(User)session.get(User.class,UserId);
session.close();
return user;
}

}