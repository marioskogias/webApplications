package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import java.io.PrintWriter;

/**
 * Servlet implementation class JavaParseXML
 */
public class JavaParseXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JavaParseXML() {
		super();
		// TODO Auto-generated constructor stub
	}

	String path;

	public void init(ServletConfig config) throws UnavailableException {
		System.out.println("Init start");
		try {
			path = config.getServletContext().getRealPath("/WEB-INF/Cars.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Init end");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output;
		response.setContentType("text/html");
		output = response.getWriter();
		StringBuffer buf = new StringBuffer();
		buf.append("<HTML><HEAD><TITLE>\n"); // write here line-by-line the html
												// for the desired page
		buf.append("Java parses XML\n");
		buf.append("</TITLE></HEAD><BODY>\n");
		buf.append("<h1> the results are </h1>");
		output.println(buf.toString());
		output.println(parseXML().toString());
		output.print("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public StringBuffer parseXML() {

		try {

			StringBuffer buf = new StringBuffer();

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(path);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getDocumentElement().getChildNodes();

			System.out.println("----------------------------");

			Node temp = nList.item(1);
			System.out.println(temp.getNodeName());
			NamedNodeMap map = temp.getAttributes();

			buf.append("<table align='center' border='2'><tr>");

			for (int j = 0; j < map.getLength(); j++) { // attributes as titles
				buf.append("<th>" + map.item(j).getNodeName() + "</th>");
				System.out.println(map.item(j).getNodeName());
			}

			NodeList firstList = temp.getChildNodes();
			System.out.println("the titles are");
			for (int j = 0; j < firstList.getLength(); j++) { // tags as titles
				if (firstList.item(j).getNodeType() == Node.ELEMENT_NODE) {
					buf.append("<th>" + firstList.item(j).getNodeName()
							+ "</th>");
					System.out.println(firstList.item(j).getNodeName());
				}
			}

			buf.append("</tr>");

			for (int i = 0; i < nList.getLength(); i++) {
				// System.out.println(i+" " + nList.item(i).getTextContent());
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					NodeList children = nNode.getChildNodes();
					buf.append("<tr>");

					NamedNodeMap mapList = nNode.getAttributes();
					System.out.println("the attribute fields are");
					for (int j = 0; j < mapList.getLength(); j++) { // attributes
																	// as fields
						buf.append("<td>" + mapList.item(j).getTextContent()
								+ "</td>");
						System.out.println(mapList.item(j).getTextContent());
					}
					System.out.println("the tags fields are");
					for (int j = 0; j < children.getLength(); j++) {
						if (children.item(j).getNodeType() == Node.ELEMENT_NODE) { // tags
																					// as
																					// fileds
							System.out.println(children.item(j)
									.getTextContent());
							buf.append("<td>"
									+ children.item(j).getTextContent()
									+ "</td>");
						}
					}
					buf.append("</tr>");
				}
			}
			buf.append("</table>");
			return buf;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
