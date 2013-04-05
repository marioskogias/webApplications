package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class firstServlet
 */
public class firstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String names[] = { "Europe", "Asia", "America", "Africa" };
	private String cities[] = { "Athens and Rome", "Peking and Amman",
			"New York", "Cairo" };

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public firstServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, // reaction to the reception
													// of GET
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output;
		Cookie cookies[];
		cookies = request.getCookies(); // get client's cookies
		response.setContentType("text/html");
		output = response.getWriter();
		output.println("<HTML><HEAD><TITLE>");
		output.println("Cookie with cities has been read !");
		output.println("</TITLE></HEAD><BODY>");
		if (cookies != null ) { // many cookies !!
			output.println("<H1>Recommended Destinations</H1>");
			// get the name of each cookie
			for (int i = 0; i < cookies.length; i++)
				output.println("In " + cookies[i].getName()
						+ " we recommend to visit " + cookies[i].getValue()
						+ "<BR>");
		} else {
			output.println("<H1>Sorry, no recommendation possible !</H1>");
			output.println("You did not select a continent or ");
			output.println("the cookies have expired.");
		}
		output.println("</BODY></HTML>");
		output.close(); // close stream
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, // reaction to the reception
													// of POST
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output;
		String conti = request.getParameter("continent"); // choice made will be
															// sent back to
															// client
		Cookie c = new Cookie(conti, getCities(conti)); // to be stored theree
														// as a cookie
		c.setMaxAge(120); // seconds until cookie removed
		response.addCookie(c); // must preceede getWriter
		response.setContentType("text/html");
		output = response.getWriter();
		// send HTML page to client
		output.println("<HTML><HEAD><TITLE>");
		output.println("Cookies");
		output.println("</TITLE></HEAD><BODY>");
		output.println("<P>Welcome to Cookies!<BR>");
		output.println("<P>");
		output.println(conti);
		output.println(" is an interesting continent !");
		output.println("</BODY></HTML>");
		output.close(); // close stream
	}

	private String getCities(String conString) {
		for (int i = 0; i < names.length; ++i)

			if (conString.equals(names[i]))
				return cities[i];
		return ""; // no matching string found
	}
}
