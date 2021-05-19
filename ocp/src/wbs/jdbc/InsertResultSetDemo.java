package wbs.jdbc;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class InsertResultSetDemo {

	// unter verwendung eines updatable-resultset fügen wir neue
	// neue records in die tabelle buch ein.

	// die daten lesen wir aus der externen datei resources/sql/more_books.txt ein.

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
	//	String sqlSelect = "SELECT * FROM Buch";
		String sqlSelect = "SELECT isbn,autor,titel,preis FROM Buch";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String[] tokens;
		List<String> lines = Files.readAllLines(Paths.get("resources/sql/more_books.txt"));

		try {
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery(sqlSelect);

			for (String line : lines) {
				try {
					resultSet.moveToInsertRow();
					tokens = line.split("\t+"); 
					resultSet.updateString(1, tokens[0]);
					resultSet.updateString(2, tokens[1]);
					resultSet.updateString(3, tokens[2]);
					resultSet.updateDouble(4, Double.parseDouble(tokens[3]));
					resultSet.insertRow();
				} catch (RuntimeException e) {
					System.out.println(e);
				}
			}

			connection.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			connection.rollback();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}

	}
}
