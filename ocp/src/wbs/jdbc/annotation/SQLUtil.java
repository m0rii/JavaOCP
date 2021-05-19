package wbs.jdbc.annotation;


import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
 /*
  *  low level api : jdbc
  *  
  *  high  level api : jpa(hibernate , openjpa ,...)
  *   - mapping 
  *   - datasource
  *   - sql generierung
  *   - transactions
  *   - ui
  *   - tools
  *   - code generierung
  *   - tables -> classes
  *   - classes -> tables
  *   - dao , dao interfaces
  */
public class SQLUtil {

        private SQLUtilConfig config;

        public SQLUtil()
                        throws IOException, ParserConfigurationException, SAXException {
                this("resources/sql/myorm.xml");
        }

        // liest den descriptor über den angebenen pfad ein und initialisiert das
        // config-feld
        public SQLUtil(String path)
                        throws IOException, ParserConfigurationException, SAXException {

                // 
                SAXParserFactory factory = SAXParserFactory.newInstance();
                factory.setValidating(true);
                factory.setNamespaceAware(false);

                SAXParser parser = factory.newSAXParser();
                // ggf. wg. validierung XMLReader verwenden
                InputSource source = new InputSource(path);

                SQLUtilHandler handler = new SQLUtilHandler();

                parser.parse(source, handler);
                config = handler.getConfig();
        }

        // was man sonst noch überpüfen sollte:
        // - gibt es überhaupt felder mit der column-annotation?
        // - gibt es zu jedem java-type einen passenden sql-type?
        // - gibt es zu jedem class-name einen eintrag in tablemappings?
        public String class2TableDefinition(String className,
                        Map<String, String> tableMappings, Map<String, String> typeMappings)
                        throws ClassNotFoundException, SQLException {

                // hole class-objekt für die klasse, zu der du ein sql-create-table
                // statement erzeugen willst
                // die klasse muss passende annotations haben
                Class<?> cls = Class.forName(className);
                // ggf create table if not exists...
                StringBuilder sql = new StringBuilder("create table if not exists ");
                PrimaryKey primaryKey;
                // da der pk auch zusammengesetzt sein kann, bauen wir eine map für die
                // pks auf
                NavigableMap<Integer, String> primaryKeys = new TreeMap<>();

                sql.append(tableMappings.get(className)).append("(");

                for (Field field : cls.getDeclaredFields()) {
                        // nur die felder der klasse werden zu columns der tabelle, die
                        // passend annotiert sind
                        if (field.getAnnotation(Column.class) != null) {
                                sql.append(field.getName()).append(" ")
                                                .append(typeMappings
                                                                .get(field.getType().getSimpleName()))
                                                .append(",");
                        }
                        // hier könnte man noch überprüfen, ob das pk-feld auch ein
                        // column-annotation hat
                        if ((primaryKey = field.getAnnotation(PrimaryKey.class)) != null) {
                                primaryKeys.put(primaryKey.index(), field.getName());
                        }
                }

                if (primaryKeys.size() < 1) {
                        throw new SQLException("no primary key...");
                }

                sql.append("primary key(");

                for (int i : primaryKeys.keySet()) {
                        sql.append(primaryKeys.get(i))
                                        .append(i < primaryKeys.size() ? "," : "))");
                }
                return sql.toString();
        }

        // erzeugt alle tabellen, für die es einen eintrag im descriptor
        // (myorm.xml) gibt.
        // alle benötigten informationen (url, user, type-mappings,...) werden aus
        // dem config-objekt
        // geholt.
        // test der methode in SQLUtilDemo.
        public void createTables() throws SQLException, ClassNotFoundException {
                Map<String, String> tableMappings = config.getTableMappings();
                Map<String, String> typeMappings = config.getTypeMappings();
                String url = config.getUrl();
                String user = config.getUser();
                String password = config.getPassword();
                String sqlCreateTable;
                try (Connection conn = DriverManager.getConnection(url, user, password);
                                Statement stmt = conn.createStatement()) {
                        for (String className : tableMappings.keySet()) {
                                sqlCreateTable = class2TableDefinition(className, tableMappings,
                                                typeMappings);
                                System.out.println("executing: " + sqlCreateTable);
                                stmt.execute(sqlCreateTable);
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                }

        }
}

