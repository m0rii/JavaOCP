package wbs.jdbc.annotation;


import java.util.HashMap;
import java.util.Map;

public class SQLUtilConfig {

        private String driver;
        private String url;
        private String user;
        private String password;

        private Map<String, String> tableMappings = new HashMap<String, String>();
        private Map<String, String> typeMappings = new HashMap<String, String>();
        
        public void putTableMapping(String className, String tableName) {
                tableMappings.put(className, tableName);
        }
        
        public void putTypeMapping(String javaType, String sqlType) {
                typeMappings.put(javaType, sqlType);
        }
        
        public String getTableMapping(String className) {
                return tableMappings.get(className);
        }
        
        public String getTypeMapping(String javaType) {
                return typeMappings.get(javaType);
        }
        
        public String getDriver() {
                return driver;
        }
        
        public void setDriver(String driver) {
                this.driver = driver;
        }
        
        public String getUrl() {
                return url;
        }
        
        public void setUrl(String url) {
                this.url = url;
        }
        
        public String getUser() {
                return user;
        }
        
        public void setUser(String user) {
                this.user = user;
        }
        
        public String getPassword() {
                return password;
        }
        
        public void setPassword(String password) {
                this.password = password;
        }
        
        public Map<String, String> getTableMappings() {
                return tableMappings;
        }
        
        public void setTableMappings(Map<String, String> tableMappings) {
                this.tableMappings = tableMappings;
        }
        public Map<String, String> getTypeMappings() {
                return typeMappings;
        }
        
        public void setTypeMappings(Map<String, String> typeMappings) {
                this.typeMappings = typeMappings;
        }
}


