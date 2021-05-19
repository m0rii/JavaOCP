package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BidirektionalScrollableResultSetDemo {

	/*
	 * wir geben für jeden record aus der tabelle buch jede spalte aus, ggf
	 * ordentlich formatiert
	 */

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		String sql = "SELECT * FROM Buch ORDER BY preis";

		String isbn;
		String autor;
		String titel;
		double preis;

		try (Connection connection = DriverManager.getConnection(url, user, password);
				Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, // alternative : TYPE_FORWARD_ONLY , TYPE_SCROLL_INSENSITIVE
						ResultSet.CONCUR_READ_ONLY);       // alternative :   CONCUR_UPDATABLE       
				ResultSet rs = statement.executeQuery(sql)) {
			rs.afterLast();
			// von hinten nach vorne
			while (rs.previous()) {
				isbn = rs.getString("isbn");
				autor = rs.getString("autor");
				titel = rs.getString("titel");
				preis = rs.getDouble("preis");
				System.out.printf("%-20s%-30s%-40s%8.2f%n", isbn, autor, titel, preis);
			}
			System.out.println("--------------");
			// von vorne nach hinten
			rs.beforeFirst();
			
			while (rs.next()) {
				isbn = rs.getString("isbn");
				autor = rs.getString("autor");
				titel = rs.getString("titel");
				preis = rs.getDouble("preis");
				System.out.printf("%-20s%-30s%-40s%8.2f%n", isbn, autor, titel, preis);
			}
			System.out.println("--------------");
			// absolut positionieren (zählung beginnt auch hier bei 1)
			rs.absolute(3);
			isbn = rs.getString("isbn");
			autor = rs.getString("autor");
			titel = rs.getString("titel");
			preis = rs.getDouble("preis");
			System.out.printf("%-20s%-30s%-40s%8.2f%n", isbn, autor, titel, preis);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

}
