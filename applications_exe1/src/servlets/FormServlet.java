package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		PrintWriter output;
		output = response.getWriter();
		output.println("<!DOCTYPE html><HEAD>");
		output.println("<link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\">");

		output.println("<TITLE>");
		output.println("Order!");
		output.println("</TITLE></HEAD><BODY>");

		double over_all_cost = 0;
		output.println("<fieldset><legend>Your order is </legend></fieldset>");
		output.println("<table class='table table-striped'> <tbody>");
		output.println("<tr><th>Product</th><th>Amount</th><th>Price</th></tr>");
		String amount = request.getParameter("ps"); 
		double price;
		if (!amount.equals("0")) {
			price = Double.parseDouble(amount) * 1.5;
			output.println("<tr><td>Pork souvlaki</td><td>"+amount+"</td><td>"+price+"</td></tr>");
			over_all_cost = over_all_cost + price; 
		}
		
		amount = request.getParameter("cs"); 
		if (!amount.equals("0")) {
			price = Double.parseDouble(amount) * 1.7;
			output.println("<tr><td>Chicken souvlaki</td><td>"+amount+"</td><td>"+price+"</td></tr>");
			over_all_cost = over_all_cost + price; 
		}
		amount = request.getParameter("pg"); 
		if (!amount.equals("0")) {
			price = Double.parseDouble(amount) * 2;
			output.println("<tr><td>Pork gyro</td><td>"+amount+"</td><td>"+price+"</td></tr>");
			over_all_cost = over_all_cost + price; 
		}
		
		amount = request.getParameter("cg"); 
		if (!amount.equals("0")) {
			price = Double.parseDouble(amount) * 2.2;
			output.println("<tr><td>Chicken gyro</td><td>"+amount+"</td><td>"+price+"</td></tr>");
			over_all_cost = over_all_cost + price; 
		}
		amount = request.getParameter("ch"); 
		if (!amount.equals("0")) {
			price = Double.parseDouble(amount) * 1;
			output.println("<tr><td>Chips</td><td>"+amount+"</td><td>"+price+"</td></tr>");
			over_all_cost = over_all_cost + price; 
		}
		amount = request.getParameter("so"); 
		if (!amount.equals("0")) {
			price = Double.parseDouble(amount) * 1.5;
			output.println("<tr><td>Soda</td><td>"+amount+"</td><td>"+price+"</td></tr>");
			over_all_cost = over_all_cost + price; 
		}
		 
		output.println("</tbody></table>");
		output.println("<h3>Yout overall order costs "+ over_all_cost + " euros</h3>");
		
		output.println("</body></html>");
		
			
	}

}
