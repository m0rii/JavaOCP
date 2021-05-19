package wbs.jdbc.annotation;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SQLUtilHandler extends DefaultHandler {

        // config ist am anfang noch nicht mit dem inhalt eines xml-descriptors bestückt.
        // wenn der parser den inhalt des xml-descriptors komplett abgearbeitet hat, ist
        // config mit dem inhalt des descriptors initialisiert.
        // wir haben dann ein java-objekt, das ein abbild des xml-descriptors ist.
        
        private SQLUtilConfig config = new SQLUtilConfig();

        public SQLUtilConfig getConfig() {
                return config;
        }

        // der parser arbeitet den xml- descriptor sequentiell ab.
        // der parser ruft die methode startElement() immer dann auf, wenn er
        // beim sequentiellen abarbeiten erkennt, dass im xml- descriptor 
        // ein neues element beginnt.
        // wenn der parser die methode startElement() aufruft, übergibt
        // er einige informationen als parameter (name des elements, attribute).
        
        @Override
        public void startElement(String uri, String localName, String qName,
                        Attributes attributes) throws SAXException {
                if (qName.equals("connection")) {
                        handleConnection(attributes);
                } else if (qName.equals("tableMapping")) {
                        handleTableMapping(attributes);
                } else if (qName.equals("typeMapping")) {
                        handleTypeMapping(attributes);
                }
        }
        
        private void handleConnection(Attributes attributes) {
                config.setDriver(attributes.getValue("driver"));
                config.setUrl(attributes.getValue("url"));
                config.setUser(attributes.getValue("user"));
                config.setPassword(attributes.getValue("password"));
        }

        private void handleTableMapping(Attributes attributes) {
                String className = attributes.getValue("className");
                String tableName = attributes.getValue("tableName");
                config.putTableMapping(className, tableName);
        }

        private void handleTypeMapping(Attributes attributes) {
                String javaType = attributes.getValue("javaType");
                String sqlType = attributes.getValue("sqlType");
                config.putTypeMapping(javaType, sqlType);
        }
}