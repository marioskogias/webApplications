package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AcceptServlet
 */
public class AcceptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookies[];
		cookies = request.getCookies(); // get client's cookies
		int i;
		HashMap<String,String> cookieMap = new HashMap<String,String>(3);
		for (i=0;i<cookies.length;i++) 
			cookieMap.put(cookies[i].getName(),cookies[i].getValue());
		
		PrintWriter output;
		output = response.getWriter();
		output.println("<!DOCTYPE html><HEAD>");
		output.println("<link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\">");

		output.println("<TITLE>");
		output.println("Accept!");
		output.println("</TITLE></HEAD><BODY>");
		output.println("<h3>We received an order from mr "+ cookieMap.get("surname") + " with overall cost " + request.getParameter("cost"));
		output.println("</h3><h3>Thank you</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
