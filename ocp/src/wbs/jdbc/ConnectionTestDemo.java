package wbs.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import javax.activation.DataSource;

// wir diskutieren vor- und nachteile der verschiedenen arten
// eine connection zu beziehen
// java database conectivity = jdbc
public class ConnectionTestDemo {

	public static void main(String[] args)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// kar ba database bayad checked ezception ro throws konim : SQLException
		
		
 // protocol :  "jdbc:mysql://  inja local host yaip mitone bashe bad : port ? parameter fur den treiber;
		String url = "jdbc:mysql://127.0.0.1:3306?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = ""; // ggf ändern
		

		Properties props = new Properties(); // class ke toosh mitoonim key value bedim behesh String
		props.put("user", user);
		props.put("password", password); // ggf ändern

		// variante 1 ohne DriverManager
          // in variant mali ni va atteractiv nist chon couplung
		Driver driver = new com.mysql.jdbc.Driver();
		
              // Connection implement autocloseable
		try (Connection conn = driver.connect(url, props)) {
			System.out.println(conn.getClass()); // class com.mysql.jdbc.JDBC4Connection
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println(meta.supportsTransactions());
			System.out.println(meta.getDriverName()); // MySQL Connector Java
			System.out.println(meta.getClass()); // class com.mysql.jdbc.JDBC4DatabaseMetaData
		}
		
		
	
		// variante 2 ohne DriverManager

		// ... oder args[0]...
		// ... oder jvm-argument -Ddriver=com.mysql.jdbc.Driver
		// ... oder auslagerung in eine properties-datei
		String driverClass = "com.mysql.jdbc.Driver";

		//hamash too  java.lang class forName(String classname)
		driver = (Driver) Class.forName(driverClass).getConstructor().newInstance();

		try (Connection conn = driver.connect(url, props)) {
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println(meta.supportsTransactions());
		}

		// variante 3 mit DriverManager
		
		// DriverManager is a class , use delegation
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println(meta.supportsTransactions());
		}

		// variante 4

		// DataSource
		
		
		
		/*
		 * - welche vorteile ergeben sich, wenn connections von einer DataSource bezogen werden? viele vortile
- mus in diesem fall ein client noch den url, username, password kennen?
- falls nein: muss er überhaupt noch etwas wissen? source
- w e r ist der client? hier ist java Class software component
- w a s ist JNDI? 
- DataSource ist ein interface. wer liefert eine implementierung dieses   
  interfaces? 
- wo ist uns das pooling von objekten schon mal begegnet...? 
		 */
		
	}
}
