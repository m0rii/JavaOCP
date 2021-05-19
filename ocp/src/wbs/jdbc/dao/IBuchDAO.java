package wbs.jdbc.dao;
import java.util.List;

public interface IBuchDAO {
        
        public void create(Buch buch) throws PersistenceException; // create buch demo
        public List<Buch> findAll() throws PersistenceException;
        // void update(Buch buch);
        // public Buch find(String isbn);
        // public void remove(Buch buch);

}
