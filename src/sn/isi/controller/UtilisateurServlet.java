package sn.isi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.isi.dao.IUser;
import sn.isi.dao.UserImpl;
import sn.isi.entities.User;

/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet({ "/utilisateur", "/utilisateur-add", "/utilisateur-update" })
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUser userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	userDao= new UserImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url=request.getRequestURI();
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null) {
			if(url.endsWith("utilisateur")) {
				request.setAttribute("listeUser",userDao.getAll());
				request.getRequestDispatcher("/view/utilisateur/liste.jsp").forward(request, response);
			}
			else if(url.endsWith("utilisateur-add")) {
				request.getRequestDispatcher("view/utilisateur/addUtilisateur.jsp").forward(request, response);
			}
			else if(url.endsWith("utilisateur-update")) {
				request.getRequestDispatcher("view/utilisateur/updateUtilisateur.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("view/autres/404.jsp").forward(request, response);
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
		User user= new User();
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null) {
			if(url.endsWith("utilisateur")) {
				request.getRequestDispatcher("/view/utilisateur/liste.jsp").forward(request, response);
			}
			else if(url.endsWith("utilisateur-add")) {
				if(nom.equals("")) {
					request.setAttribute("error", "Veuillez remplir tous les champs");
					request.getRequestDispatcher("view/utilisateur/addUtilisateur.jsp").forward(request, response);
				}
				else {
					user.setNom(nom);
					user.setPrenom(prenom);
					user.setEmail(email);
					user.setPassword(password);
					int ok=userDao.add(user);
					request.setAttribute("ok",ok);
				request.getRequestDispatcher("view/utilisateur/addUtilisateur.jsp").forward(request, response);
				}
			}
			else if(url.endsWith("utilisateur-update")) {
				request.getRequestDispatcher("view/utilisateur/updateUtilisateur.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("view/autres/404.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("log", "veuillez vous identifier!!");
       	 	request.getRequestDispatcher("login").forward(request, response);
		}

	}

}
