package sn.isi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.isi.dao.ILieu;
import sn.isi.dao.LieuImpl;
import sn.isi.entities.Lieu;
import sn.isi.entities.User;

/**
 * Servlet implementation class LieuServlet
 */
@WebServlet({"/lieu","/lieu-add", "/lieu-update" })
public class LieuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILieu lieuDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LieuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		lieuDao= new LieuImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				String url=request.getRequestURI();
				String titre="";
				HttpSession session=request.getSession();
				if(session.getAttribute("user")!=null) {
					if(url.endsWith("lieu")) {
						 //String titre="Liste des lieux";
						 titre="liste des lieux";
						 request.setAttribute("titre", titre);
						 	request.setAttribute("listeLieu", lieuDao.getAll());
			               request.getRequestDispatcher("view/lieu/liste.jsp").forward(request, response);
					}
					else if(url.endsWith("lieu-add")) {
						  titre="ajout";
						 request.setAttribute("titre", titre);
						request.getRequestDispatcher("/view/lieu/addlieu.jsp").forward(request, response);
					}
					else {
						 titre="update";
						 request.setAttribute("titre", titre);
						request.getRequestDispatcher("/view/lieu/updatelieu.jsp").forward(request, response);
						
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
		String url=request.getRequestURI();
		Lieu lieu=new Lieu();
		String titre="";
		String nom=request.getParameter("nom");
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null) {
			if(url.endsWith("lieu")) {
				 //String titre="Liste des lieux";
				 titre="liste des lieux";
				 request.setAttribute("titre", titre);
	                request.setAttribute("titre", titre);
	               request.getRequestDispatcher("view/lieu/liste.jsp").forward(request, response);
			}
			else if(url.endsWith("lieu-add")) {
				  titre="ajout";
				  
				 request.setAttribute("titre", titre);
				 lieu.setNom(request.getParameter("nom"));
				 lieu.setUser((User)session.getAttribute("user"));
				 int ok=lieuDao.add(lieu);
				request.getRequestDispatcher("/view/lieu/addlieu.jsp").forward(request, response);
			}
			else {
				 titre="update";
				 request.setAttribute("titre", titre);
				request.getRequestDispatcher("/view/lieu/updatelieu.jsp").forward(request, response);
				
			}
		}
		else {
			 request.setAttribute("log", "veuillez vous identifier!!");
        	 request.getRequestDispatcher("login").forward(request, response);
		}
		
	}

}
