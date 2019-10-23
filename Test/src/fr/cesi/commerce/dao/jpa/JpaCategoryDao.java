package fr.cesi.commerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.commerce.dao.CategoryDao;
import fr.cesi.commerce.entity.Category;

public class JpaCategoryDao implements CategoryDao{
	private EntityManagerFactory emf ;
	
	public JpaCategoryDao(EntityManagerFactory emf) {
		this.emf = emf ;
	}
	
	public Category addCategory(Category c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.persist(em.contains(c) ? c : em.merge(c)); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
		return c ;
	}
	public void editCategory(Category c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.merge(c); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}
	public List<Category> getAllCategories() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Category C ");
		return query.getResultList();
	}
	public Category findCategoryById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Category C WHERE C.id = ?1");
		query.setParameter(1, id) ;
		return (Category)query.getSingleResult() ;
	}
	public void removeCategory(Category c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.remove(em.contains(c) ? c : em.merge(c));
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}

}
