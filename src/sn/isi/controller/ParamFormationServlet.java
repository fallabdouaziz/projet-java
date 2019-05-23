package sn.isi.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ParamFormationServlet
 */
@WebServlet("/paramFormation")
public class ParamFormationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParamFormationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
        if(session.getAttribute("user")!=null) {
        	request.setAttribute("user_roles", request.getSession().getAttribute("user_roles"));
        	request.setAttribute("admin_roles", request.getSession().getAttribute("admin_roles"));
        	String titre="Parametrage";
            request.setAttribute("titre", titre);
            request.getRequestDispatcher("/view/formation/parametrage.jsp").forward(request, response);
        }
        else {
        	//response.sendRedirect("login");
        	request.setAttribute("log", "veuillez vous identifier!!");
        	  // request.getRequestDispatcher("login").forward(request, response);
        	response.sendRedirect("login");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
