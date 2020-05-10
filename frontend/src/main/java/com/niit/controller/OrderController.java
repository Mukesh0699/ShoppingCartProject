package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.CartDAO;
import com.niit.DAO.OrderDAO;
import com.niit.model.Cartitem;
import com.niit.model.OrderDetail;

@Controller
public class OrderController 
{
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@RequestMapping(value="/payment")
	public String showPaymentPage()
	{
		return "Payment";
	}
	
	@RequestMapping(value="/paymentprocess",method=RequestMethod.POST)
	public String paymentProcess(@RequestParam("pmode")String pmode,HttpSession session,Model m)
	{
		String username = (String)session.getAttribute("username");
		
		List<Cartitem> listCartItem = cartDAO.listCartItem(username);
		m.addAttribute("cartItem", listCartItem);
		m.addAttribute("grandTotal", this.calcGrandTotalValue(listCartItem));
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setUsername(username);
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setPmode(pmode);
		orderDetail.setTotalShoppingAmount((int)this.calcGrandTotalValue(listCartItem));
		
		orderDAO.insertOrderDetail(orderDetail);
		
		return "ThankYou";
		
	}
	
	public long calcGrandTotalValue(List<Cartitem> listCartItem) 
	{
		int count=0;
		long grandTotalPrice = 0;
		while(count<listCartItem.size())
		{
			grandTotalPrice+=listCartItem.get(count).getQuantity()*listCartItem.get(count).getTotalPrice();
			count++;
		}
		return grandTotalPrice;
	}
}