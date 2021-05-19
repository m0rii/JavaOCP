package wbs.jdbc.dao;
//wir lesen aus einer externen csv- datei (more_books.txt) einige bücher ein
//und speichern sie unter verwendung des dao (IBuchDAO) in der tabelle buch. 

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;

public class CreateBuecherDemo {

     public static void main(String[] args) throws Exception {
             
//    	 String[] tokens;
// 		List<String> lines = Files.readAllLines(Paths.get("resources/sql/more_books.txt"));
//
// 		for (String line : lines) {
//			try {
//				tokens = line.split("\t+"); 
//				Buch b = new Buch(tokens[0],tokens[1],tokens[2],Double.parseDouble(tokens[3]));
//				 DAOFactory.getBuchDAO().create(b);
//			} catch (RuntimeException e) {
//				System.out.println(e);
//			}
//		}
 		
 		
 		// --------------- kurs  richtiger besser-----------------
 		
 		Function<String,Buch> line2Buch = s -> {
 			Buch buch = new Buch();
 			String[] tokenss = s.split("\t+");
 			buch.setIsbn(tokenss[0]);
 			buch.setAutor(tokenss[1]);
 			buch.setTitel(tokenss[2]);
 			buch.setPreis(Double.parseDouble(tokenss[3]));

 			return buch;
 		};
          IBuchDAO buchDAO = DAOFactory.getBuchDAO();
          Files.lines(Paths.get("resources/sql/more_books.txt")).forEach(s->buchDAO.create(line2Buch.apply(s)));
     }

}
