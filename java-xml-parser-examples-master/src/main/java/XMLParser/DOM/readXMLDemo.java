package XMLParser.DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * DOM Parser read XML Demo
 * 
 *
 */
public class readXMLDemo 
{
	public static void main(String[] args) 
	{
		try
		{
			File xmlFile=new File("src//main//java//XMLParser//DOM//student.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
			NodeList nodeList = document.getElementsByTagName("student");
			System.out.println(nodeList.getLength());
			for (int i = 0; i < nodeList.getLength(); i++) 
			{
				Node node=nodeList.item(i);
				if(node.getNodeType()==Node.ELEMENT_NODE)
				{
					Element element=(Element) node;
					System.out.println(element.getElementsByTagName("studentName").item(0).getTextContent());

				}
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
