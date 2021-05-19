package wbs.jdbc.annotation;

//sax-api: low level, transformation xml -> java muss der entwickler machen (vgl. jdbc)
//jaxb-api: high level, transformation xml -> java automatisch (vgl. jpa)

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleSaxHandler extends DefaultHandler {

     @Override
     public void startElement(String uri, String localName, String qName,
                     Attributes attributes) throws SAXException {
             System.out.println(qName);
             for (int i = 0; i < attributes.getLength(); i++) {
                     System.out.println(
                                     attributes.getQName(i) + ":" + attributes.getValue(i));
             }
             System.out.println();
     }

}
