package fr.cesi.commerce.dao.jpa;

import fr.cesi.commerce.dao.CategoryDao;
import fr.cesi.commerce.dao.ProductDao;
import fr.cesi.commerce.util.PersistenceManager;

public class DaoFactory {
	
	private DaoFactory() {
		
	}
	
	public static ProductDao getProductDao() {
		return new JpaProductDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static CategoryDao getCategoryDao() {
		return new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
	}

}
