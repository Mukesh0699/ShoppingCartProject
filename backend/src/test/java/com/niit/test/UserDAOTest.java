package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

public class UserDAOTest {
static UserDAO userDAO;

@BeforeClass
public static void initialize()
{
AnnotationConfigApplicationContext contex=new AnnotationConfigApplicationContext();
contex.scan("com.niit");
contex.refresh();
userDAO=(UserDAO)contex.getBean("userDAO");

}
@Test
public void addUser() {
User user=new User();
user.setCustomerName("mukesh");
user.setEmail("mukesh0699@gmail.com");
assertTrue("problem in adding User",userDAO.addUser(user));
}
@Ignore
@Test
public void updateUser()
{
	User user=userDAO.getUser(69);
	assertTrue("problem in updating user",userDAO.updateUser(user));
	
}
@Ignore
@Test
public void deleteProductTest()
{
	User user=userDAO.getUser(66);
	assertTrue("problem in deleting user",userDAO.deleteUser(user));
	
}
@Ignore
@Test
public void listUsersTest()
{
	List<User> listUsers=userDAO.listUsers();
	assertNotNull("problem in list user",userDAO.listUsers());
	for(User user:listUsers)
	{
		System.out.println("Product ID:"+user.getEmail());
		System.out.println("Customer Name:"+user.getCustomerName());
		System.out.println("MOBILE NO:"+user.getMobileNo());
		System.out.println("PASSWORD:"+user.getPassword());
		System.out.println("USER NAME:"+user.getUserName());
	}
}


}

