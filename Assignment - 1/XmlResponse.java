import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XmlResponse {
    public static void getXMLDealerResponse(String errorDealerMsg) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();
        Element root = document.createElement("order");
        document.appendChild(root);

        Element result = document.createElement("result");

        result.appendChild(document.createTextNode("failure"));
        root.appendChild(result);

        Element error = document.createElement("error");
        error.appendChild(document.createTextNode(errorDealerMsg));
        root.appendChild(error);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult result1 = new StreamResult(System.out);
        transformer.transform(domSource, result1);
    }
    public static void getXMLErrorResponse(String errorMsg)throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();
        Element root = document.createElement("order");
        document.appendChild(root);

        Element result = document.createElement("result");
        result.appendChild(document.createTextNode("failure"));
        root.appendChild(result);

        Element error = document.createElement("error");
        error.appendChild(document.createTextNode("Invalid order"));
        root.appendChild(error);

        Element errormessage = document.createElement("errormessage");
        errormessage.appendChild(document.createTextNode(errorMsg));
        root.appendChild(errormessage);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult result1 = new StreamResult(System.out);
        transformer.transform(domSource, result1);
    }
}




