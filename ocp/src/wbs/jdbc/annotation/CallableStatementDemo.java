package wbs.jdbc.annotation;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * wir listen alle spalten aller bücher auf, bei denen der preis in einem gegebenen
 * intervall liegt, und verwenden dabei die stored procedure booksByPrice
 */

public class CallableStatementDemo {
        public static void main(String[] args) {
                String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
                String user = "root";
                String password = "";
                CallableStatement callableStatement;
                ResultSet resultSet;
                String sql = "{call booksByPrice(?, ?)}";
                double fromPrice = 10.0;
                double toPrice = 40.0;
                try (Connection conn = DriverManager.getConnection(url, user,
                                password)) {
                        callableStatement = conn.prepareCall(sql);
                        callableStatement.setDouble(1, fromPrice);
                        callableStatement.setDouble(2, toPrice);
                        resultSet = callableStatement.executeQuery();
                        while (resultSet.next()) {
                                System.out.println(resultSet.getString(1) + " : "
                                                + resultSet.getString(2) + " (" + resultSet.getString(3)
                                                + ")" + " " + resultSet.getDouble(4));
                        }
                        callableStatement.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
}
