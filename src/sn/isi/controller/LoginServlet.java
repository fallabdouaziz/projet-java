package sn.isi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.isi.dao.IUser;
import sn.isi.dao.LoginDao;
import sn.isi.dao.UserImpl;
import sn.isi.entities.Roles;
import sn.isi.entities.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IUser userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		userDao= new UserImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                        //request.setAttribute("ok", 1);
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null) {
			request.getRequestDispatcher("/view/accueil/accueil.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub         
				HttpSession session=request.getSession();
				if(request.getParameter("login")!=null) {
                String login=request.getParameter("login");
                String password=request.getParameter("password");
                User user= new User();
                user=userDao.verification(login, password);
                if(user!=null) {
                	request.getSession().setAttribute("user_roles",0);
                	request.getSession().setAttribute("admin_roles",0);
                	List<Roles> roles=user.getRole();
                	if(roles.size()==0) {
                		request.getRequestDispatcher("index.jsp").forward(request, response);
                	}
                	else {
                	for (Roles r : roles) {
						if(r.getId()==1) {
							request.getSession().setAttribute("user_roles",1);
						}
						if(r.getId()==2) {
							request.getSession().setAttribute("admin_roles",2);
						}
					}
                	}
                	request.getSession().setAttribute("user",user);
        			response.sendRedirect("accueil");
                	
        		}
        		else {
        			request.setAttribute("erreur", "Identifiant incorrect");
        			response.sendRedirect("login");
        			
        		}
				}
				else {
					response.sendRedirect("login");
				}

	}

}
