package test.tecsinfo.testbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import test.tecsinfo.testbackend.dao.ProductDAO;
import test.tecsinfo.testbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO; 
	private Product product;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("test.tecsinfo.testbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	/*
	@Test
	public void testCRUDProduct(){
		product = new Product();
		
		product.setId(5);
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(2);
		
		assertEquals("Something went wrong while inserting a new Product", true, productDAO.add(product));
		
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		
		assertEquals("Actualizando registro existente", true, productDAO.update(product));
		
		assertEquals("Eliminando registro existente", true, productDAO.delete(product));
		
		assertEquals("Lista registro existente", 3, productDAO.list().size());
	}
	*/
	
	@Test
	public void testListActiveProducts(){
		assertEquals("Lista registro existente", 2, productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory(){
		assertEquals("Lista registro existente", 1, productDAO.listActiveProductsByCategory(2).size());
	}
	
	@Test
	public void testGetLatestActiveProduct(){
		assertEquals("Lista registro existente", 1, productDAO.getLatestActiveProducts(1).size());
	}
	
	
}
