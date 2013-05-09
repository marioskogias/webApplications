import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import org.w3c.dom.*;

public class ReadXMLFile {

	public static StringBuffer parseXML() {

		try {

			StringBuffer buf = new StringBuffer();

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder
					.parse("/Users/Marios/Documents/ntua/8o/webApplications/WebContent/WEB-INF/Cars.xml");

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
				buf.append("th" + map.item(j).getNodeName() + "/th");
				System.out.println(map.item(j).getNodeName());
			}

			NodeList firstList = temp.getChildNodes();
			System.out.println("the titles are");
			for (int j = 0; j < firstList.getLength(); j++) { // tags as titles
				if (firstList.item(j).getNodeType() == Node.ELEMENT_NODE) {
					buf.append("th" + firstList.item(j).getNodeName() + "/th");
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

					NamedNodeMap mapList = temp.getAttributes();

					for (int j = 0; j < mapList.getLength(); j++) { // attributes
																	// as fields
						buf.append("td" + map.item(j).getTextContent() + "/td");
						System.out.println(map.item(j).getTextContent());
					}

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
			return buf;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}