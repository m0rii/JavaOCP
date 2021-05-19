package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

/*
 * wir erhoehen die preise aller buecher um 10 prozent
 * und verwenden dazu ein updatable result set
 */

public class UpdateResultSetDemo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		
		// die query m u s s den primary key enthalten
		String sqlSelect = "SELECT isbn,PREIS FROM buch";
		double neuerPreis;
// ggf try...catch...finally (OHNE try-with-resources)
		try (Connection connection = DriverManager.getConnection(url, user, password);
				Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet resultSet = statement.executeQuery(sqlSelect)) {
			while (resultSet.next()) {
				neuerPreis = resultSet.getDouble("preis")*1.1 ;
				resultSet.updateDouble(2,neuerPreis );
				resultSet.updateRow();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
