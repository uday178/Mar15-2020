package XMLParser.DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class createXMLDemo 
{
	public static void main(String[] args) {
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root element
			Document document = docBuilder.newDocument();
			Element rootElement = document.createElement("company");
			document.appendChild(rootElement);

			// employee elements
			Element employee = document.createElement("employee");
			rootElement.appendChild(employee);

			// set attribute to employee element
			Attr attribute = document.createAttribute("id");
			attribute.setValue("101");
			employee.setAttributeNode(attribute);

			// firstname elements
			Element firstname = document.createElement("firstname");
			firstname.appendChild(document.createTextNode("John"));
			employee.appendChild(firstname);

			// lastname elements
			Element lastname = document.createElement("lastname");
			lastname.appendChild(document.createTextNode("cooper"));
			employee.appendChild(lastname);


			// salary elements
			Element salary = document.createElement("salary");
			salary.appendChild(document.createTextNode("200000"));
			employee.appendChild(salary);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("src//main//java//XMLParser//DOM//employee.xml"));
			
			transformer.transform(source, result);
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		} 
	}
}
