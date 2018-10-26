package test.tecsinfo.testbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import test.tecsinfo.testbackend.dao.CategoryDAO;
import test.tecsinfo.testbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("test.tecsinfo.testbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
//	@Test
//	public void testAddCategory(){
//		
//		category = new Category();
//		
//		category.setId(4);
//		category.setName("Television");
//		category.setDescription("Esto es una Descripcion para El Televisor");
//		category.setImageURL("CAT_1.png");
//		
//		assertEquals("Ingreso Exitoso..,", true, categoryDAO.add(category));
//	}
	
//	@Test
//	public void testGetCategory(){
//		
//		category = categoryDAO.get(1);
//		
//		assertEquals("Ingreso Exitoso..,", "Television", category.getName());
//		
//	}
	
//	@Test
//	public void testUpdateCategory(){
//		
//		category = categoryDAO.get(1);
//		category.setName("TV");
//		assertEquals("Actualizacion Exitoso..,", true , categoryDAO.update(category));
//		
//	}
	
//	@Test
//	public void testDeleteCategory(){
//		
//		category = categoryDAO.get(1);
//		category.setName("TV");
//		assertEquals("Eliminacion Exitoso..,", true , categoryDAO.delete(category));
//		
//	}
	
	@Test
	public void testListCategory(){
		
		
		assertEquals("Lista Categoria Exitoso..,",2, categoryDAO.list().size());
		
	}

}
