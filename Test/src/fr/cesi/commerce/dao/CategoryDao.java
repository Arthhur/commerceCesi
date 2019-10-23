package fr.cesi.commerce.dao;

import java.util.List;

import fr.cesi.commerce.entity.Category;

public interface CategoryDao {

	public Category addCategory(Category p) ;
	public void editCategory(Category p) ;
	public List<Category> getAllCategories() ;
	public Category findCategoryById(Long id) ;
	public void removeCategory(Category p) ;
}
