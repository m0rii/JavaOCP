package wbs.jdbc.dao;


public class SelectAllBooksDemo {
	// doa loose kopplung 
	// keine checked exception werfen

        public static void main(String[] args) {

                IBuchDAO buchDAO = DAOFactory.getBuchDAO();
                buchDAO.findAll().forEach(System.out::println);
        
        }
}
