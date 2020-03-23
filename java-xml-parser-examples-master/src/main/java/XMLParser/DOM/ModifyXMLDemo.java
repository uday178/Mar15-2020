package XMLParser.DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * DOM Parser Modify XML Demo
 * 
 *
 */
public class ModifyXMLDemo 
{
	public static void main(String[] args) 
	{
		try
		{
			File xmlFile=new File("src//main//java//XMLParser//DOM//student.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
	
			Node college = document.getFirstChild();
			
			Node student = document.getElementsByTagName("student").item(0);
			
			Element age = document.createElement("age");
			age.appendChild(document.createTextNode("12"));
			student.appendChild(age);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(xmlFile);
			transformer.transform(source, result);

			
			NodeList nodeList = document.getElementsByTagName("student");
			for (int i = 0; i < nodeList.getLength(); i++) 
			{
				Node node=nodeList.item(i);
				if(node.getNodeType()==Node.ELEMENT_NODE)
				{
					Element element=(Element) node;
					System.out.println("Name : "+element.getElementsByTagName("studentName").item(0).getTextContent());
				}
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
