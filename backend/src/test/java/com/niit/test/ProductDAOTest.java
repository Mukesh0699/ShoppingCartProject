package com.niit.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

public class ProductDAOTest {
static ProductDAO productDAO;

@BeforeClass
public static void initialize()
{
AnnotationConfigApplicationContext contex=new AnnotationConfigApplicationContext();
contex.scan("com.niit");
contex.refresh();
productDAO=(ProductDAO)contex.getBean("productDAO");

}
@Ignore
@Test
public void addProduct() {
Product product=new Product();
product.setProductName("Mr.Carder");
product.setProductDesc("serious buyers DM me");
assertTrue("problem in adding category",productDAO.addProduct(product));
}
@Test
public void updateProduct()
{
	Product product=productDAO.getProduct(69);
	product.setProductDesc("16 gb ram");
	product.setProductName("RAM");
	product.setPrice(567);
	product.setSupplierId(3);
	product.setCategoryId(4);
	product.setQuantity(5);
	assertTrue("problem in updating PRODUCT",productDAO.updateProduct(product));
	
}
@Ignore
@Test
public void deleteProductTest()
{
	Product product=productDAO.getProduct(66);
	assertTrue("problem in deleting category",productDAO.deleteProduct(product));
	
}
@Ignore
@Test
public void listProductsTest()
{
	List<Product> listProducts=productDAO.listProducts();
	assertNotNull("problem in list category",productDAO.listProducts());
	for(Product product:listProducts)
	{
		System.out.println("Product ID:"+product.getProductId());
		System.out.println("Product Name:"+product.getProductName());
		System.out.println("Product Desc:"+product.getProductDesc());
	}
}


}
