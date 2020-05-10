package com.niit.DAO;

import java.util.List;

import com.niit.model.Cartitem;

public interface CartDAO {
	
	public boolean addCartItem(Cartitem cartItem);
	public boolean deleteCartItem(Cartitem cartItem);
	public boolean updateCartItem(Cartitem cartItem);
	public List<Cartitem> listCartItem(String username);
	public Cartitem getCartItem(int cartItemId);

}