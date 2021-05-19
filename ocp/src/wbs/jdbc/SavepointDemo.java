package wbs.jdbc;
/*
 * wir setzen autocommit auf false
 * wir fügen einige records in die tabelle buch ein
 * einige diese inserts werden unter verwendung eines savepoints
 * annuliert
 * anschliessend erfolgt ein commit
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class SavepointDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		String sql = "insert into buch(isbn, autor, titel, preis)" + "values(?,?,?,?)";
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			conn.setAutoCommit(false); // notwendig! (wg rollback(), commit())
			PreparedStatement pstmt = conn.prepareStatement(sql);

			Savepoint sp1 = conn.setSavepoint();
			pstmt.setString(1, "978-1119363392");
			pstmt.setString(2, "selikoff,boyarski");
			pstmt.setString(3, "OCA / OCP Java SE 8 Programmer Practice Tests");
			pstmt.setDouble(4, 30.42);
			pstmt.execute();

			Savepoint sp2 = conn.setSavepoint();
			pstmt.setString(1, "978-3896706461");
			pstmt.setString(2, "heinz von foerster");
			pstmt.setString(3, "Wahrheit ist die Erfindung eines Lügners");
			pstmt.setDouble(4, 19.95);
			pstmt.execute();

			Savepoint sp3 = conn.setSavepoint("sp3");
			pstmt.setString(1, "978-1780380766");
			pstmt.setString(2, "barnes");
			pstmt.setString(3, "captain beefheart");
			pstmt.setDouble(4, 15.12);
			pstmt.execute();

			// barnes wird n i c h t angelegt, selikoo/boyarski und foerster werden
			// angelegt
			conn.rollback(sp3); // This method should be used only when auto-commit has been disabled.

			conn.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
