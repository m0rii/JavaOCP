package wbs.jdbc.misc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AutocommitDemo {

        public static void main(String[] args) throws SQLException {
                /*
                 * wir holen eine connection und setzen den autocommit-modus auf false.
                 * 
                 * wir machen einige änderungen oder updates.
                 * 
                 * dann setzen wir den autocommit-modus auf true.
                 * 
                 * explizites commit() ist nicht erforderlich
                 */
                String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
                String user = "root";
                String password = "";
                String sqlSelect = "SELECT isbn, autor, titel, preis FROM buch";
                Connection connection = null;
                Statement statement = null;
                ResultSet resultSet = null;
                try {
                        connection = DriverManager.getConnection(url, user, password);
                        connection.setAutoCommit(false);
                        statement = connection.createStatement(
                                        // TYPE_SCROLL_INSENSITIVE
                                        // TYPE_FORWARD_ONLY
                                        ResultSet.TYPE_SCROLL_SENSITIVE,
                                        // CONCUR_READ_ONLY
                                        ResultSet.CONCUR_UPDATABLE);
                        resultSet = statement.executeQuery(sqlSelect);
                        resultSet.moveToInsertRow();
                        resultSet.updateString(1, "978-3257224405");
                        resultSet.updateString(2, "emerson");
                        resultSet.updateString(3, "von der schönheit des guten");
                        resultSet.updateDouble(4, 9.9);
                        resultSet.insertRow();
                        connection.setAutoCommit(true);
                } catch (SQLException sqle) {
                        sqle.printStackTrace();
                        connection.rollback();
                } finally {
                        if (connection != null) {
                                // ...
                                connection.close();
                        }
                }
        }
}


