package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter output;
		output = response.getWriter();
		output.println("<HTML><HEAD>");
		output.println("<link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\">");
		output.println("<TITLE>");
		output.println("Welcome to our main page!");
		output.println("</TITLE></HEAD><BODY>");
		output.println("<H1>Sorry, no recommendation possible !</H1>");
		output.println("You did not select a continent or ");
		output.println("the cookies have expired.");
		output.println("<button class=\"btn btn-large btn-primary\" type=\"button\">Large button</button>");

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
