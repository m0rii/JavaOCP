package wbs.jdbc.misc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ReexutedStatementDemo {

	// was passiert, wenn auf ein resultset zugegriffen wird, nachdem für das
	// statement, durch das es erzeugt wurde, ein weiteres execute... abgesetzt
	// wurde

	// SQLException

	public static void main(String[] args) throws SQLException {
		Driver driver = new com.mysql.jdbc.Driver();

		Properties props = new Properties();

		props.setProperty("user", "root");
		props.setProperty("password", "");

		String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		// String user = "root";
		// String password = "mysql";
		String sql1 = "SELECT * FROM Buch";
		String sql2 = "SELECT isbn, preis FROM Buch";

		try (Connection connection = driver.connect(url, props);
				Statement statement = connection.createStatement();
				Statement statement2 = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql1)) {

		//	ResultSet resultSet2 = statement2.executeQuery(sql2);
			statement.execute(sql2);
			while (resultSet.next()) { // bitte ändern...
				System.out.println(resultSet.getString("isbn") + " -> " + resultSet.getDouble("preis"));
			}
//			while (resultSet2.next()) { // bitte ändern...
//				System.out.println(resultSet2.getString("isbn") + " -> " + resultSet2.getDouble("preis"));
//			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
