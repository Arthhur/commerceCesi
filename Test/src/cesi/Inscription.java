package cesi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inscription_test")
public class Inscription extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
    }
	
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* R�cup�ration des champs du formulaire. */
        String email = request.getParameter("input1");

        try {
        	System.out.println(email) ;
        } catch (Exception e) {
            /* G�rer les erreurs de validation ici. */
        }
    }
    
    @Override
    public void init() throws ServletException{
        System.out.println("Appel de la m�thode init");
    }

    @Override
    public void destroy(){
        System.out.println("Appel de la m�thode destroy");
        super.destroy();
    }
}