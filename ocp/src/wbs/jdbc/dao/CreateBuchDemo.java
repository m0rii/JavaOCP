package wbs.jdbc.dao;

public class CreateBuchDemo {
/*
 * wo ist der code im package dao substantiell verbesserungsfaehig?
 * 
 * wie sieht eine abstraktion des dao-patterns in java aus?
 */
	public static void main(String[] args) {
		Buch mori = new Buch("978-345620799", "moriito", "java is easy", 7.0);
		 DAOFactory.getBuchDAO().create(mori);
		// DAOFactory.getBuchDAO().create(new Buch(.....));
		 DAOFactory.getBuchDAO().findAll().forEach(i->System.out.println(i));

	}

}
