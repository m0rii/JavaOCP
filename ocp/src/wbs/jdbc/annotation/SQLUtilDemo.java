package wbs.jdbc.annotation;

public class SQLUtilDemo {

        public static void main(String[] args) throws Exception {
                
                // default-config-path: resources/sql/myorm.xml
                SQLUtil sqlUtil = new SQLUtil();
                
                // wir erzeugen alle tabellen, für die es in myorm.xml einen eintrag gibt
                sqlUtil.createTables();
        }
}


