package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {

        // wir geben alle records der tabelle buch jeweils mit allen spalten aus
        // unter verwendung eines ResultSet
        public static void main(String[] args) {

                String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
                String user = "root";
                String password = "";
                String sql = "SELECT * FROM Buch";

                String isbn;
                String autor;
                String titel;
                double preis;

                try (Connection connection = DriverManager.getConnection(url, user,
                                password);
                                Statement statement = connection.createStatement();
                                ResultSet rs = statement.executeQuery(sql)) {
                	
                	// connection.setAutoCommit(false);  not working wir konten nicht auto kommit false gesetz werden
                	
                        while (rs.next()) {
                        
                                // getXXX()- methoden haben auch eine überladung, der die
                                // spaltennummer übergeben werden kann...
                                // auch hier beginnt die zählung bei 1...
                                isbn = rs.getString("ISBN"); 
                                autor = rs.getString("AUTOR");
                                titel = rs.getString("Titel");// spalten jdbc is NOT case sensetive 
                                preis = rs.getDouble("preis");
                                System.out.printf("%-20s%-30s%-40s%8.2f%n", isbn, autor, titel,
                                                preis);

                        }
                        
                } catch (SQLException sqle) {
                        sqle.printStackTrace();
                }
                
                /*
                 * in welcher reihenfolge werden die
ressourcen geschlossen? barax

sind a l l e hier verwendeten ressourcen autocloseable? ja

könnte h i e r der autocommit-modus der connection
auf false gesetzt werden? kein unterschied

was ist sicherer: eine methode wie rs.getString()
mit dem spaltennamen oder mit einem index aufzurufen? beide sind unsicher aber name ist besser

sind spaltennamen in jdbc  case sensitiv? bitte ausprobieren! nein

wie müsste das programm auf der kommandozeile
aufgerufen werden? bitte ausprobieren! 
                 */
                
               
        }
}
