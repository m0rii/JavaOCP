package wbs.pattern.builder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuchExemplarUtil {

        // liest zeilen aus einer datei ein (path).
        // zerlegt jede zeile in einzelne tokens (delimiter).
        // erzeugt für jede zeile eine instanz von BuchExemplar und verwendung von BuchExemplar.Builder
        // liefert eine list aller erzeugten buchexemplar-objekte
        
        public static List<BuchExemplar> exemplareFromFile(String path, String delimiter ) throws IOException {
        	// kurs losung badan nehmen
        	
        	
        	List<BuchExemplar> list = new ArrayList<BuchExemplar>();
        	String line;
        	try (BufferedReader br = new BufferedReader(new FileReader(path))) {
    			while ((line = br.readLine()) != null) { 
    			String[] s = line.split(delimiter);
    			 BuchExemplar ex = new BuchExemplar.Builder()
    					 .setNr(Integer.parseInt(s[0])).setIsbn(s[1]).setAutor(s[2]).setTitel(s[3]).setKategorie(s[4]).
    					 setPreis(Double.valueOf(s[5])).build();
    			 list.add(ex);
    			}
    		} catch (FileNotFoundException e) {
    			System.out.println(e.getMessage());
    		} catch (IOException e) {
    			System.out.println(e.getMessage());
    		}
                return list;
        }
}

