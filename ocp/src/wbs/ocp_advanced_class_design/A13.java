package wbs.ocp_advanced_class_design;

import java.nio.file.StandardOpenOption;

//compilerfehler?
//ausgabe?
public class A13 {
	public static void main(String[] args) {
		StandardOpenOption soo = StandardOpenOption.SPARSE;
		// in enum muss nur enum name konstante sein nicht comolete
		switch (soo) {
		case SPARSE: // StandardOpenOption.SPARSE: geht nicht
			break;
		case APPEND: //  StandardOpenOption.APPEND: geht nicht
			break;
		}
		System.out.println("hm...");
	}
}