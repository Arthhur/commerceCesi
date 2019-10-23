package fr.cesi.commerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.commerce.dao.jpa.DaoFactory;
import fr.cesi.commerce.dao.jpa.JpaCategoryDao;
import fr.cesi.commerce.dao.jpa.JpaProductDao;
import fr.cesi.commerce.doa.ProductDao;
import fr.cesi.commerce.entity.Category;
import fr.cesi.commerce.entity.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		JpaCategoryDao categoryDao = (JpaCategoryDao)DaoFactory.getCategoryDao() ;
		Long idCategory = Long.parseLong(request.getParameter("category")) ;
		Category category = categoryDao.findCategoryById(idCategory) ;
		String nom = request.getParameter("nom") ;
		String contenu = request.getParameter("contenu") ;
		float prix = Float.parseFloat(request.getParameter("prix")) ;
		//Category category = 
		
		Product product = new Product() ;
		product.setNom(nom) ;
		product.setContenu(contenu);
		product.setPrix(prix);
		product.setCategory(category) ;
		
		JpaProductDao productDao = (JpaProductDao)DaoFactory.getProductDao() ;
		productDao.addProduct(product) ;
		
		 ServletContext context = getServletContext();
		 RequestDispatcher dispatcher = context.getRequestDispatcher("/listProduct");
		 dispatcher.forward(request, response);
		
		
	}

}
