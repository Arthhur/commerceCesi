package fr.cesi.commerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.commerce.dao.ProductDao;
import fr.cesi.commerce.entity.Product;

public class JpaProductDao implements ProductDao{
	private EntityManagerFactory emf ;
	
	public JpaProductDao(EntityManagerFactory emf) {
		this.emf = emf ;
	}
	
	public Product addProduct(Product p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.persist(em.contains(p) ? p : em.merge(p));
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
		return p ;
	}
	public void editProduct(Product p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		Product product ;
		try {
			t.begin();
			product = em.merge(p); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}		
	}
	public List<Product> getAllProducts() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Product P ");
		return query.getResultList();
	}
	public Product findProductById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Product P WHERE P.id = ?1");
		query.setParameter(1, id) ;
		return (Product)query.getSingleResult() ;
	}
	public void removeProduct(Product p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.remove(em.contains(p) ? p : em.merge(p));
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}
	
	public List<Product> getCheaperProducts() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Product P WHERE P.prix < ?1");
		query.setParameter(1, 100.0);
		return query.getResultList();
	}

}
