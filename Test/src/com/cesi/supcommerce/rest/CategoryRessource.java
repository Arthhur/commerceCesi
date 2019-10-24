package com.cesi.supcommerce.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.cesi.commerce.dao.jpa.DaoFactory;
import fr.cesi.commerce.dao.jpa.JpaCategoryDao;
import fr.cesi.commerce.dao.jpa.JpaProductDao;
import fr.cesi.commerce.entity.Category;
import fr.cesi.commerce.entity.Product;

@Path("/categories") 
public class CategoryRessource {
		
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAllCategoriesInJson() {
		JpaCategoryDao categoryDao = (JpaCategoryDao)DaoFactory.getCategoryDao() ;
		return categoryDao.getAllCategories() ;
	}
	
	@GET 
	@Path("/search/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Category getCategoryInJson(@PathParam("id") Long categoryId) {
		JpaCategoryDao categoryDao = (JpaCategoryDao)DaoFactory.getCategoryDao() ;
		return categoryDao.findCategoryById(categoryId) ;
	}
	
	@GET 
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Category removeCategory(@PathParam("id") Long categoryId) {
		JpaCategoryDao categoryDao = (JpaCategoryDao)DaoFactory.getCategoryDao() ;
		Category c = categoryDao.findCategoryById(categoryId) ;
		categoryDao.removeCategory(c);
		return c ;
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public void addCategory(Category category) {
		JpaCategoryDao categoryDao = (JpaCategoryDao)DaoFactory.getCategoryDao() ;
		categoryDao.addCategory(category) ;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editCategory(@PathParam("id") Long categorytId, Category c) {
		JpaCategoryDao categoryDao = (JpaCategoryDao)DaoFactory.getCategoryDao() ;
		categoryDao.editCategory(c);
	}
	
}
