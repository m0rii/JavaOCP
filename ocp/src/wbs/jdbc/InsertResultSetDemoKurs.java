package wbs.jdbc;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

// unter verwendung eines updatable-resultset fügen wir neue
// neue records in die tabelle buch ein.
        
// die daten lesen wir aus der externen datei resources/sql/more_books.txt ein.

public class InsertResultSetDemoKurs {

        public static void main(String[] args) throws Exception {
                String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
                String user = "root";
                String password = "mysql";
                String[] tokens;
                String sql = "select isbn, autor, titel, preis from buch";
                List<String> lines = Files.readAllLines(Paths.get("resources/sql/more_books.txt"));
                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                        conn.setAutoCommit(false);
                        Statement statement = conn.createStatement(
                                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet resultSet = statement.executeQuery(sql);
                        for (String line : lines) {
                                tokens = line.split("\t+");
                                if (!tokens[0].matches("\\d{3}-\\d{10}")) {  // optional: prüfung der isbn...
                                        System.out.println("invalid isbn...: " + tokens[0]);
                                } else {
                                        try {
                                                resultSet.moveToInsertRow();
                                                resultSet.updateString(1, tokens[0]);
                                                resultSet.updateString(2, tokens[1]);
                                                resultSet.updateString(3, tokens[2]);
                                                resultSet.updateDouble(4, Double.parseDouble(tokens[3]));
                                                resultSet.insertRow();
                                        } catch (NumberFormatException e) {
                                                System.out.println(e);
                                        }
                                }
                        }
                        conn.commit();
                }
        }
}


