package sn.isi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.isi.dao.IRoles;
import sn.isi.dao.RolesImpl;
import sn.isi.entities.Roles;

/**
 * Servlet implementation class RolesServlet
 */
@WebServlet({ "/role", "/role-add", "/role-update","/role-delete" })
public class RolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoles roledao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    	@Override
    	public void init() throws ServletException {
    		// TODO Auto-generated method stub
    		 roledao=new RolesImpl();
    	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url=request.getRequestURI();
		HttpSession session=request.getSession();
		IRoles rolesdoa= new RolesImpl();
		List<Roles> liste= new ArrayList<>();
		if(session.getAttribute("user")!=null) {
			if(url.endsWith("role")) {
				liste=rolesdoa.getAll();
				request.setAttribute("listeRoles",liste);
				request.getRequestDispatcher("/view/role/liste.jsp").forward(request, response);
			}
			else if(url.endsWith("role-add")) {
				request.getRequestDispatcher("view/role/addrole.jsp").forward(request, response);
			}
			else if(url.endsWith("role-update")) {
				String id=request.getParameter("id");
				request.setAttribute("id",id);
				Roles roles=rolesdoa.get(Integer.parseInt(id));
				if(roles!=null) {
				request.setAttribute("roles",roles);
				request.getRequestDispatcher("view/role/updaterole.jsp").forward(request, response);
				}
				else {
					//request.getRequestDispatcher("/view/role/liste.jsp").forward(request, response);
					response.sendRedirect("role");
				}
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
		HttpSession session=request.getSession();
		Roles roles=new Roles();
		String nomRole=request.getParameter("nom");
			if(url.endsWith("role")) {
				request.getRequestDispatcher("/view/role/liste.jsp").forward(request, response);
			}
			else if(url.endsWith("role-add")) {
				roles.setNom(nomRole);
				int ok=roledao.add(roles);
				request.setAttribute("ok", ok);
				request.getRequestDispatcher("view/role/addrole.jsp").forward(request, response);
			}
			else if(url.contains("role-update")) {
				//if(request.getAttribute("id")!=null) {
					String id=request.getParameter("id");
					String nom=request.getParameter("nom");
					roles.setId(Integer.parseInt(id));
					roles.setNom(nom);
					int ok=roledao.update(roles);
					request.setAttribute("ok", ok);
					System.out.println("iddddddddd"+request.getParameter("id"));
					//request.getRequestDispatcher("view/role/liste.jsp").forward(request, response);
					response.sendRedirect("role");
				//}
				System.out.println("iddddddddd"+request.getParameter("id"));
				System.out.println("dougouna si bir");
				//response.sendRedirect("role");
			}
			else {
				doGet(request, response);
			}
		
	}

}
