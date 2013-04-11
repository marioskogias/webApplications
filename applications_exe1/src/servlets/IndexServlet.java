package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
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
			output.println("<form method = 'post' action = 'IndexServlet'>");
			output.println("<div class='control-group'> <label class='control-label' for='Name'>Name</label>");
			output.println("<div class='controls'> <input type='text' name='name' placeholder='Name'></div></div>");
			output.println("<div class='control-group'> <label class='control-label' for='Surname'>Surname</label>");
			output.println("<div class='controls'> <input type='text' name='surname' placeholder='Surname'></div></div>");
			output.println("<div class='control-group'> <label class='control-label' for='Address'>Address</label>");
			output.println("<div class='controls'> <input type='text' name='Address' placeholder='Address'></div></div>");
			output.println("<button type='submit' class='btn'>Register</button>");
			output.println("</form>");
			output.println("</div>");
			

		} else {
			//create cookie dictionary
			int i;
			HashMap<String,String> cookieMap = new HashMap<String,String>(3);
			for (i=0;i<cookies.length;i++) 
				cookieMap.put(cookies[i].getName(),cookies[i].getValue());
				
				
			
			output.println("Old user");
			output.println("<fieldset><legend>Hello mr "+ cookieMap.get("name") +  "</legend></fieldset>");
			output.println("Your personal data are");
			output.println("<table class='table table-striped'> <tbody>");
			output.println("<tr><td><strong>Name</strong></td><td>"+cookieMap.get("name")+"</td></tr>");
			output.println("<tr><td><strong>Surname</strong></td><td>"+cookieMap.get("surname")+"</td></tr>");
			output.println("<tr><td><strong>Address</strong></td><td>"+cookieMap.get("Address")+"</td></tr>");
			
			 
			output.println("</tbody></table>");
			
			output.println("<a style = 'margin-left : 45%' class='btn btn-large btn-primary' type='button' href = 'form.html'>Make an order now</a>");
		}
			

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
		String val = request.getParameter("name"); 
		Cookie c = new Cookie("name",val); // to be stored there as a cookie
		c.setMaxAge(30); // seconds until cookie removed
		response.addCookie(c); // must preceede getWriter
		val = request.getParameter("surname"); 
		c = new Cookie("surname",val); // to be stored there as a cookie
		c.setMaxAge(30); // seconds until cookie removed
		response.addCookie(c); // must preceede getWriter
		val = request.getParameter("Address"); 
		c = new Cookie("Address",val); // to be stored there as a cookie
		c.setMaxAge(30); // seconds until cookie removed
		response.addCookie(c); // must preceede getWriter
		
		//PrintWriter output;
		//output = response.getWriter();
		//output.println("got the cooikies");
		response.sendRedirect("IndexServlet");
	}

}
