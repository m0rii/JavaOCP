package wbs.jdbc;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class InsertBooksIntoTableDemo {

	/*
	 * unter verwendung eines PreparedStatement fügen wir einige records in die
	 * tabelle buch ein.
	 */

	public static void main(String[] args) throws Exception {
                                            //port/databaseName
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";

		String[] tokens;

		String sql = "INSERT INTO buch(isbn, autor, titel, preis)" + " VALUES(?, ?, ?, ?)";

		// alle zeilen einlesen

		List<String> lines = Files.readAllLines(Paths.get("resources/sql/books.txt"));

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			conn.setAutoCommit(true); // default age nabashe khat akhar comit konim
		

			for (String line : lines) {
				try {
					// regex: als field separator mindestends ein tabstop...
					tokens = line.split("\t+"); // Tab
					// achtung: spaltenzählung in jdbc beginnt bei 1!
					pstmt.setString(1, tokens[0]);
					pstmt.setString(2, tokens[1]);
					pstmt.setString(3, tokens[2]);
					pstmt.setDouble(4, Double.parseDouble(tokens[3]));
					pstmt.execute();

				} catch (RuntimeException e) {
					System.out.println(e );
				}
			}
			
			// conn.comit();
;		}
	}
}
