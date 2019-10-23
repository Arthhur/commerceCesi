package fr.cesi.commerce.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.cesi.commerce.doa.ProductDao;
import fr.cesi.commerce.entity.Category;
import fr.cesi.commerce.entity.Product;

/**
 * Servlet implementation class InsertSomeProductServlet
 */
@WebServlet("/basicInsert")
public class InsertSomeProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSomeProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	 public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       /* Product p1 = new Product(new Long(1), "ballon de foot", "pour jouer au foot", 15.0) ;
        Product p2 = new Product(new Long(2), "raquette de tennis", "pour jouer au tennis", 50.0) ;
        Product p3 = new Product(new Long(1), "gants", "pour le ski", 75.0) ;

        ProductDao.addProduct(p1) ;
        ProductDao.addProduct(p2) ;
        ProductDao.addProduct(p3) ;*/
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibliotheque");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Category C WHERE C.nom = :nom");
		query.setParameter("nom", "Sport");
		Category category = (Category)query.getSingleResult();
		
		Product p1 = new Product() ;	
		p1.setNom("ballon de foot");
		p1.setContenu("pour jouer au foot");
		p1.setPrix(15.0);
		p1.setCategory(category);
		
		try {
			t.begin();
			em.persist(p1); 
			t.commit();
		} finally {
		if (t.isActive()) 
			t.rollback();
		em.close();
		}
		
		//Long id = Long.parseLong(request.getParameter("id")) ;
		
		emf.close();
        
        super.service(request, response);
	 }

}
