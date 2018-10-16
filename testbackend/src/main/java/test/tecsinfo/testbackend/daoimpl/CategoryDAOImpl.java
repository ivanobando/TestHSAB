package test.tecsinfo.testbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import test.tecsinfo.testbackend.dao.CategoryDAO;
import test.tecsinfo.testbackend.dto.Category;

@Repository("categoriaDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	
	private static List<Category> categories = new ArrayList<Category>();
	
	static{
		
		Category category = new Category();
		
		category.setId(1);
		category.setName("Television");
		category.setDescription("Esto es una Descripcion para El Televisor");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		category = new Category();
		
		category.setId(2);
		category.setName("mobil");
		category.setDescription("Esto es una Descripcion para El mobil");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		category = new Category();
		
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Esto es una Descripcion para la laptop");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);
	}

	@Override
	public Category get(int id) {
		
		for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
