package sn.isi.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.isi.dao.FormationImpl;
import sn.isi.dao.IFormation;
import sn.isi.entities.Formation;

/**
 * Servlet implementation class FormationServlet
 */
@WebServlet({"/formation","/formation-add","/formation-update"})
public class FormationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IFormation formationDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		formationDao= new FormationImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
                 String titre="";
                 request.setAttribute("titre", titre);
                 HttpSession session=request.getSession();
                 if(session.getAttribute("user")!=null) {
                	 String url=request.getRequestURI();
                     if(url.endsWith("formation")) {
                  	   titre="liste des Formations";
                  	   request.getRequestDispatcher("/view/formation/liste.jsp").forward(request, response);
                     }
                     else if(url.endsWith("formation-add")) {
                  	   titre="Ajout Formation";
                  	   request.getRequestDispatcher("/view/formation/addformation.jsp").forward(request, response);
                     }
                     else {
                  	   titre="modification de Formation";
                  	   request.getRequestDispatcher("/view/formation/updateformation.jsp").forward(request, response);
                     }
      		
                 }
                 else {
                	 request.setAttribute("log", "veuillez vous identifier!!");
                	 request.getRequestDispatcher("login").forward(request, response);
                 }
               
              
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDate=new SimpleDateFormat("");
		HttpSession session=request.getSession();
		String nom=request.getParameter("nom");
		int duree=Integer.parseInt(request.getParameter("duree"));
		String dt=request.getParameter("dateDebut");
		 String titre="";
         request.setAttribute("titre", titre);
        if(session.getAttribute("user")!=null) {
       	 String url=request.getRequestURI();
            if(url.endsWith("formation")) {
         	   titre="liste des Formations";
         	   request.getRequestDispatcher("/view/formation/liste.jsp").forward(request, response);
            }
            else if(url.endsWith("formation-add")) {
         	   titre="Ajout Formation";
         	 Formation formation= new Formation();
         	 formation.setNom(nom);
         	 formation.setDuree(duree);
         	// formation.setDateDebut(dateDebut);
         	   request.getRequestDispatcher("/view/formation/addformation.jsp").forward(request, response);
            }
            else {
         	   titre="modification de Formation";
         	   request.getRequestDispatcher("/view/formation/updateformation.jsp").forward(request, response);
            }
		
        }
        else {
       	 request.setAttribute("log", "veuillez vous identifier!!");
       	 request.getRequestDispatcher("login").forward(request, response);
        }
	}

}
