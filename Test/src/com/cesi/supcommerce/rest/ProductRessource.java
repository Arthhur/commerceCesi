package com.cesi.supcommerce.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.cesi.commerce.dao.jpa.DaoFactory;
import fr.cesi.commerce.dao.jpa.JpaProductDao;
import fr.cesi.commerce.entity.Product;

public class ProductRessource {
	
	
	
	@GET @Path("/products") @Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProductsInJson() {
		JpaProductDao productDao = (JpaProductDao)DaoFactory.getProductDao() ;
		return productDao.getAllProducts() ;
	}
	/*getProductInXml(Long productId)
	getProductInJson(Long productId)
	removeProduct(Long productId)
	getAllProductsInXml()*/

}
