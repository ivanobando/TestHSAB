package test.tecsinfo.testbackend.dao;

import java.util.List;

import test.tecsinfo.testbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	
	Category get(int id);
}