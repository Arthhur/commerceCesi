package fr.cesi.commerce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.commerce.dao.jpa.DaoFactory;
import fr.cesi.commerce.dao.jpa.JpaProductDao;
import fr.cesi.commerce.doa.ProductDao;
import fr.cesi.commerce.entity.Product;
import fr.cesi.commerce.model.UnknownProductException;

/**
 * Servlet implementation class RemoveProductServlet
 */
@WebServlet("/auth/removeProduct")
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		
		JpaProductDao productDao = (JpaProductDao)DaoFactory.getProductDao() ;
		Product product = productDao.findProductById(id) ;
		System.out.println(product) ;
		productDao.removeProduct(product) ;
	    HttpServletRequest httpRequest = (HttpServletRequest) request ;
	    HttpServletResponse res = (HttpServletResponse) response;	
		res.sendRedirect( httpRequest.getContextPath() + "/listProduct" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response) ;
	}

}
