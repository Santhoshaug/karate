package com.api.test.helper;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.intuit.karate.Logger;

public abstract class XmlParser {

	private DocumentBuilderFactory docBuilderFactory;
	private DocumentBuilder documentBuilder;
	private Document document = null;
	private Logger logger = new Logger();

	public XmlParser() {
		docBuilderFactory = DocumentBuilderFactory.newInstance();
	}

	private Document getDocument() {
		try {
			documentBuilder = docBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(new InputSource(new StringReader(getXmlContent())));
			document.getDocumentElement().normalize();
			return document;
		} catch (ParserConfigurationException e) {
			logger.error("Not able to crete the Document Builder {}", e.getMessage());
			throw new RuntimeException(e);
		} catch (IOException e) {
			logger.error("Not able to load the xml content {}", e.getMessage());
			throw new RuntimeException(e);
		} catch (SAXException e) {
			logger.error("Not able to parse the given xml content {}", e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public Document getDocumentInstance() {
		if (document == null)
			document = getDocument();
		return document;
	}

	public abstract String getXmlContent();

	public abstract boolean isTagPresent(String xPath);

	public abstract boolean isValuePresent(String xPath, String value);

}