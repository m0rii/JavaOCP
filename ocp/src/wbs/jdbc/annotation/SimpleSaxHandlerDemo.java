package wbs.jdbc.annotation;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleSaxHandlerDemo {

        public static void main(String[] args) throws IOException,
                        SAXException, ParserConfigurationException {

                String xmlFile = "resources/sql/myorm.xml";
                InputSource source = new InputSource(xmlFile);
                // warum hier der aufruf von newInstance() ?
                // warum nicht einfach new SAXParserFactory() ?
                // => loose coupling
                SAXParserFactory factory = SAXParserFactory.newInstance();
                // com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl
                // System.out.println(factory.getClass());
                factory.setValidating(true);
                factory.setNamespaceAware(false);

                SAXParser parser = factory.newSAXParser();
                // com.sun.org.apache.xerces.internal.jaxp.SAXParserImpl
                // System.out.println(parser.getClass());

                DefaultHandler handler = new SimpleSaxHandler();
                // was passiert beim aufruf der parse()- methode ?
                // => der parser wird gestartet
                // welches interface wird von DefaultHandler implementiert ?
                // => ContentHandler
                // welche methoden deklariert dieses interface ?
                // => startElement(), endElement(), startDocument(),...
                // wer ruft diese methoden auf ?
                // der parser
                // wer implementiert diese methoden ?
                // => wir
                // wie nennt man solche methoden, die einer definiert, und ein anderer aufruft ?
                // callback- methode
                
                // parse() von SAXParser mit ContentHandler <-> sort() von Collections mit Comparator 
                // => der parser ruft in der parse()- methode methoden des interfaces ContentHandler auf,
                // die w i r implementieren.
                // => die klasse Collections ruft in der sort()- methode eine methode des interfaces
                // Comparator auf (die methode compare()), die w i r implementieren
                parser.parse(source, handler);
        }
}
