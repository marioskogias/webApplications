package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter output;
		output = response.getWriter();
		output.println("<!DOCTYPE html><HEAD>");
		output.println("<link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\">");
		
		
		output.println("<TITLE>");
		output.println("Welcome to our main page!");
		output.println("</TITLE></HEAD><BODY>");
		
		Cookie cookies[];
		cookies = request.getCookies(); // get client's cookies
		if (cookies == null) {
			output.println("New user");
			output.println("<fieldset><legend>Please give the following information</legend></fieldset>");
			output.println("<div class = 'hero-unit'>");
			output.println("<form>");
			output.println("<div class='control-group'> <label class='control-label' for='Name'>Name</label>");
			output.println("<div class='controls'> <input type='text' name='name' placeholder='Name'></div></div>");
			output.println("<div class='control-group'> <label class='control-label' for='Surname'>Surname</label>");
			output.println("<div class='controls'> <input type='text' name='surname' placeholder='Surname'></div></div>");
			output.println("<div class='control-group'> <label class='control-label' for='Company'>Company</label>");
			output.println("<div class='controls'> <input type='text' name='company' placeholder='Company'></div></div>");
			output.println("</form>");
			output.println("</div>");
			
			
			
			
		} else 
			output.println("Old user");
		
		output.println("<button style = 'margin-left : 45%' class='btn btn-large btn-primary' type='button'>Large button</button>");
		output.println("<script src = 'http://code.jquery.com/jquery.js'></script>");
		output.println("<script src = 'bootstrap/js/bootstrap.js'></script>");
		output.println("</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
