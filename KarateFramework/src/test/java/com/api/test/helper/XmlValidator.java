package com.api.test.helper;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.jupiter.api.Assertions;
import org.opentest4j.AssertionFailedError;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.intuit.karate.Logger;

public class XmlValidator extends XmlParser {
	private String content;
	private XPath path;
	private Logger logger = new Logger();

	public XmlValidator(String content) {
		this.content = content;
		logger.debug("XML content in XmlValidator {}", content);
		path = XPathFactory.newInstance().newXPath();
	}

	@Override
	public String getXmlContent() {
		logger.debug("XML content after parsing response {}", content);
		return content;
	}

	@Override
	public boolean isTagPresent(String xPath) {
		Document document = getDocumentInstance();
		try {
			Node node = (Node) path.compile(xPath).evaluate(document, XPathConstants.NODE);
			Assertions.assertNotNull(node);
		} catch (IllegalArgumentException | XPathExpressionException e) {
			logger.error("Unable to compile the expression {}", e.getMessage());
			return false;
		} catch (AssertionFailedError e) {
			logger.error("Not able to locate node with give {} - {}", xPath, e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean isValuePresent(String xPath, String value) {
		Document document = getDocumentInstance();
		try {
			Node node = (Node) path.compile(xPath).evaluate(document, XPathConstants.NODE);
			Assertions.assertEquals(value, node.getTextContent());
		} catch (IllegalArgumentException | XPathExpressionException e) {
			logger.error("Unable to compile the expression {}", e.getMessage());
			return false;
		} catch (AssertionFailedError e) {
			logger.error("Not able to locate node with give {} - {}", xPath, e.getMessage());
			return false;
		}
		return true;
	}

}