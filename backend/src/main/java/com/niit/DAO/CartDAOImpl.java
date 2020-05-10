package com.niit.DAO;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cartitem;
import com.niit.model.Category;
@Repository
@Transactional
public class CartDAOImpl implements CartDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public User getUser(String email) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, email);
		return user;
	}

	public void saveOrUpdateCartItem(Cartitem cartItem) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
	}

	public List<Cartitem> getCartItem(String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from CartItem where user.email=?");
		query.setString(0, email);
		List<Cartitem> cartItems=query.list();
		return cartItems;
	}

	public void removeCartItem(int itemId) {
		Session session=sessionFactory.getCurrentSession();
		Cartitem cartItem=(Cartitem)session.get(Cartitem.class, itemId);
		session.delete(cartItem);
	}

	public Cartitem getCartitemId(int itemId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("From CartItem where id="+itemId);
		Cartitem cartItem=(Cartitem) session.get(Cartitem.class, itemId);
		return cartItem;
	}

}
