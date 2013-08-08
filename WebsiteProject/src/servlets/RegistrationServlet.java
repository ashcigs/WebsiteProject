package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.ws.Response;

import dao.UsersDAO;
import types.User;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		InitialContext ctx;
		try
		{
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/WebsiteProject");
			UsersDAO.printAllSchemas(ds);
			UsersDAO.checkTable(ds);
		}
		catch (NamingException e)
		{
			System.out.println("Naming exception in init");
			System.out.println(e);
			e.printStackTrace();
		}
		catch (SQLException e)
		{	
			System.out.println("SQL exception in init");
			System.out.println(e);
			e.printStackTrace();
		}
		
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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		try
		{
			UsersDAO.insertUser(ds, firstName, lastName, password);
//			String result = UsersDAO.selectAllUsers(ds);
//			response.getWriter().println("Users: "+result);
			ArrayList<User> usersList = UsersDAO.selectAllUsers(ds);
			for (User user : usersList)
			{
				response.getWriter().println("Name: "+user.getFirstName()+" "+user.getLastName()+"");
			}
		}
		catch (SQLException e)
		{
			response.getWriter().println("SQL problem, check your connection to the database.");
			e.printStackTrace();
		}
		
		
		response.getWriter().println("Wellcome!");
	}

}
