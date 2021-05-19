package wbs.io;

import java.io.Console;

//path_to_workspace/ocp/bin> java wbs.io.ConsoleDemo  
//hinweise:
//eine console steht nicht immer zur verfügung
//(z.b. aufruf aus entwicklungsumgebung, start als hintergrundprozess, ein-
//ausgabe-umlenkung)
//eine referenz auf eine console bekommt man nur über System.console()
//(liefert null, aber keine exception, falls keine console geliefert werden
//kann)
//Console ist isoliert, direkter Subtyp von Object
//methoden von Console liefern im fehlerfall einen Error aber keine
//Exception
//es schadet nichts, die methoden von Console namentlich zu kennen... 

class ConsoleDemo {
	public static void main(String[] args) {

		Console console = System.console();

		if (console == null) {
			System.err.println("no console ... ");
			System.exit(-1);
		}

		String user;
		char[] password;

		console.printf("your name: ");
		user = console.readLine();
		console.printf("your password: ");
		password = console.readPassword();
		console.printf("your name is %s%n", user);
		console.format("your password is %s%n", new String(password));
		console.printf("good bye ").format(user);
	}
	
	// in terminal C:\Users\Administrator\eclipse-workspace\ocp\bin>java wbs.io.ConsoleDemo
}