package com.cesi.supcommerce.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.cesi.commerce.dao.jpa.DaoFactory;
import fr.cesi.commerce.dao.jpa.JpaProductDao;
import fr.cesi.commerce.entity.Product;

@Path("/products") 
public class ProductRessource {
		
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProductsInJson() {
		JpaProductDao productDao = (JpaProductDao)DaoFactory.getProductDao() ;
		return productDao.getAllProducts() ;
	}
	
	@GET 
	@Path("/search/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductInJson(@PathParam("id") Long productId) {
		JpaProductDao productDao = (JpaProductDao)DaoFactory.getProductDao() ;
		return productDao.findProductById(productId) ;
	}
	
	@DELETE 
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product removeProduct(@PathParam("id") Long productId) {
		JpaProductDao productDao = (JpaProductDao)DaoFactory.getProductDao() ;
		Product p = productDao.findProductById(productId) ;
		productDao.removeProduct(p);
		return p ;
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public void addProduct(Product product) {
		JpaProductDao productDao = (JpaProductDao)DaoFactory.getProductDao() ;
		productDao.addProduct(product) ;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editProduct(@PathParam("id") Long productId, Product p) {
		JpaProductDao productDao = (JpaProductDao)DaoFactory.getProductDao() ;
		productDao.editProduct(p);
	}
	
	/*@GET 
	@Produces(MediaType.APPLICATION_XML)
	public List<Product> getAllProductsInXml() {
		JpaProductDao productDao = (JpaProductDao)DaoFactory.getProductDao() ;
		return productDao.getAllProducts() ;
	}
	/*getProductInXml(Long productId)
	removeProduct(Long productId)
	*/

}
