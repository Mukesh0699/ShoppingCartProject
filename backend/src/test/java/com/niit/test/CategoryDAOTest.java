package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOTest {
static CategoryDAO categoryDAO;

@BeforeClass
public static void initialize()
{
AnnotationConfigApplicationContext contex=new AnnotationConfigApplicationContext();
contex.scan("com.niit");
contex.refresh();
categoryDAO=(CategoryDAO)contex.getBean("categoryDAO");

}
@Test
public void addCategory() 
{
Category category=new Category();
category.setCategoryName("Mr.Cardgvhbjer");
category.setCategoryDesc("serious buyers DM me");
assertTrue("problem in adding category",categoryDAO.addCategory(category));
}
@Ignore
@Test
public void updateCategory()
{
	Category category=categoryDAO.getCategory(1);
	category.setCategoryDesc("16 gb ram");
	category.setCategoryName("RAM");
	assertTrue("problem in updating category",categoryDAO.updateCategory(category));
	
}
@Ignore
@Test
public void deleteCategoryTest()
{
	Category category=categoryDAO.getCategory(1);
	assertTrue("problem in deleting category",categoryDAO.deleteCategory(category));
	
}
@Ignore
@Test
public void listCategoriesTest()
{
	List<Category> listCategories=categoryDAO.listCategories();
	assertNotNull("problem in list category",categoryDAO.listCategories());
	for(Category category:listCategories)
	{
		System.out.println("Category ID:"+category.getCategoryId());
		System.out.println("Category Name:"+category.getCategoryName());
		System.out.println("Category Desc:"+category.getCategoryDesc());
	}
}
}
