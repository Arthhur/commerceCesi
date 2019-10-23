package fr.cesi.commerce.dao;

import java.util.List;

import fr.cesi.commerce.entity.Product;

public interface ProductDao {
	
	public Product addProduct(Product p) ;
	public void editProduct(Product p) ;
	public List<Product> getAllProducts() ;
	public Product findProductById(Long id) ;
	public void removeProduct(Product p) ;
		
}
