package ffnjr.core.util.xml;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * @author fernandojr.ifcg@live.com, http://fjacademic.wordpress.com/
 * 
 */
public class SampleSolution {
	public static void main(String[] args) {

		try {

			XmlReader reader = new XmlReader(new File("file.xml"));

			// Getting the root element 'book' from the document
			Element rootElement = reader.getChild();

			// Getting the children of root element
			ArrayList<Element> persons = reader.getChildren(rootElement);

			// For each person in persons
			for (Element person : persons) {

				String firstName = reader.getChild(person, "first")
						.getTextContent();
				String lastName = reader.getChild(person, "last")
						.getTextContent();
				String age = reader.getChild(person, "age").getTextContent();

				System.out
						.println(firstName + " " + lastName + ", age: " + age);

			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
