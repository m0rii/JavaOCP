package wbs.jdbc.annotation;


import java.io.IOException;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SQLUtilHandlerDemo {

        public static void main(String[] args)
                        throws ParserConfigurationException, SAXException, IOException {

                String path = "resources/sql/myorm.xml";
                SQLUtilConfig config;

                SAXParserFactory factory = SAXParserFactory.newInstance();
                factory.setValidating(true);
                factory.setNamespaceAware(false);

                SAXParser parser = factory.newSAXParser();
                
                
                XMLReader reader = parser.getXMLReader();
                
                InputSource source = new InputSource(path);

                SQLUtilHandler handler = new SQLUtilHandler();
                reader.setContentHandler(handler);
                reader.parse(source);
                                
                config = handler.getConfig();
                
                System.out.println(config.getDriver());
                System.out.println(config.getUrl());
                System.out.println(config.getUser());
                System.out.println(config.getPassword());
                System.out.println(config.getTableMappings());
                System.out.println(config.getTypeMappings());
        }
}
