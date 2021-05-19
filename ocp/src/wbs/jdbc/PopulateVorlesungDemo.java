package wbs.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PopulateVorlesungDemo {

        /*
         * wir bestücken die tabellen student, vorlesung, professor und hört mit
         * genau den daten, die im wikipedia-artikel verwendet werden.
         * 
         */
        
        // https://de.wikipedia.org/wiki/SQL
        // mapping klasse for die tabelle
        
        public static void main(String[] args) throws SQLException {

        	String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
    		String user = "root";
    		String password = "";
    		
    		String populateStudent = "insert into student(matrnr,name) values (?,?)";
    		String populateProfessor = "insert into professor(persnr,name) values (?,?)";
    		String populateVorlesung = "insert into vorlesung(vorlnr,titel,persnr) values (?,?,?)";
    		String populateHoert = "insert into hoert(matrnr,vorlnr) values (?,?)";
    		
    //		String sql = "SELECT * FROM Buch";
    		
    		try (Connection connection = DriverManager.getConnection(url, user,
                    password);
                 //   Statement statement = connection.createStatement();
                   ) {
    			
    		//	 ResultSet rs = statement.executeQuery(sql);
    			
    			connection.setAutoCommit(false); 
    			populateStudent(connection,populateStudent);
    			populateProfessor(connection,populateProfessor);
    			populateVorlesung(connection,populateVorlesung);
    			populateHoert(connection,populateHoert);
    			connection.commit();
    		

    		//	DatabaseMetaData meta = connection.getMetaData();
    		//	System.out.println(meta.supportsTransactions()); test connection -> true
    			
    		
              
      } catch (SQLException sqle) {
              sqle.printStackTrace();
      }
    		
        }
        
        
        public static void populateStudent(Connection connection ,String sql ) throws SQLException {
        	PreparedStatement pstmt = connection.prepareStatement(sql);

				// achtung: spaltenzählung in jdbc beginnt bei 1!
				pstmt.setInt(1, 26120);
				pstmt.setString(2, "Frichte");
				pstmt.execute();
				pstmt.setInt(1, 25403);
				pstmt.setString(2, "Jonas");
				pstmt.execute();
				
				pstmt.setInt(1, 27103);
				pstmt.setString(2, "Fauler");
				pstmt.execute();
		
        }
        
        public static void populateProfessor(Connection connection ,String sql ) throws SQLException {
        	PreparedStatement pstmt = connection.prepareStatement(sql);
        	pstmt.setInt(1, 12);
			pstmt.setString(2, "Wirth");
			pstmt.execute();
			pstmt.setInt(1, 15);
			pstmt.setString(2, "Tesla");
			pstmt.execute();
			
			pstmt.setInt(1, 20);
			pstmt.setString(2, "Urlauber");
			pstmt.execute();
			pstmt.close();
	
        }
        
        public static void populateVorlesung(Connection connection ,String sql ) throws SQLException {
        	PreparedStatement pstmt = connection.prepareStatement(sql);
        	pstmt.setInt(1, 5001);
			pstmt.setString(2, "Et");
			pstmt.setInt(3, 15);
			pstmt.execute();
			
			pstmt.setInt(1, 5022);
			pstmt.setString(2, "IT");
			pstmt.setInt(3, 12);
			pstmt.execute();
			
			pstmt.setInt(1, 5045);
			pstmt.setString(2, "DB");
			pstmt.setInt(3, 12);
			pstmt.execute();
			pstmt.close();
	
        }
        
        public static void populateHoert(Connection connection ,String sql ) throws SQLException {
        	PreparedStatement pstmt = connection.prepareStatement(sql);
         	pstmt.setInt(1, 25403);
         	pstmt.setInt(2, 5001);
			pstmt.execute();
			
		 	pstmt.setInt(1, 26120);
         	pstmt.setInt(2, 5001);
			pstmt.execute();
			
		 	pstmt.setInt(1, 26120);
         	pstmt.setInt(2, 5045);
			pstmt.execute();
			pstmt.close();
        }

}