package wbs.jdbc.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcBuchDAO implements IBuchDAO {

        private final String SQLINSERT = "insert into buch (isbn, autor, titel, preis) " + " values(?,?,?,?)";
        private final String SQLSELECTALL = "select isbn, autor, titel, preis " + "from buch";

        @Override
        public void create(Buch buch) throws PersistenceException {
                try (Connection conn = DAOHelper.getConnection();
                                PreparedStatement pstmt = conn.prepareStatement(SQLINSERT)) {
                        pstmt.setString(1, buch.getIsbn());
                        pstmt.setString(2, buch.getAutor());
                        pstmt.setString(3, buch.getTitel());
                        pstmt.setDouble(4, buch.getPreis());
                        pstmt.execute();
                } catch (SQLException e) {
                        throw new PersistenceException(e);
                }
        }

        @Override
        public List<Buch> findAll() throws PersistenceException {

                String isbn;
                String titel;
                String autor;
                double preis;

                List<Buch> buecher = new ArrayList<>();

                try (Connection connection = DAOHelper.getConnection();
                                Statement statement = connection.createStatement();
                                ResultSet resultSet = statement.executeQuery(SQLSELECTALL)) {
                        while (resultSet.next()) {
                                isbn = resultSet.getString("isbn");
                                titel = resultSet.getString("titel");
                                autor = resultSet.getString("autor");
                                preis = resultSet.getDouble("preis");
                                Buch buch = new Buch(isbn, autor, titel, preis);
                                buecher.add(buch);
                        }
                } catch (SQLException e) {
                        throw new PersistenceException(e);
                }
                return buecher;
        }

}
