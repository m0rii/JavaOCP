package wbs.pattern.proxy.variante;

/*
 * wir definieren nun die klasse IllegalAccessTimeException
als subklasse von RuntimeException und übernehmen alle konstruktoren der basisklasse.

dann ändern wir die klasse ServiceProxy. der proxy wirft nun eine IllegalAccessTimeException, wenn der aufruf der methode m() nicht zwischen 8:00 und 12:00 erfolgt.
erfolgt der aufruf der methode zwischen 8:00 und 12:00,
macht er seine arbeit wie bisher (delegation).

cross cutting concern hier: check der aufrufzeit
 */

@SuppressWarnings("serial")
public class IllegalAccessTimeException extends RuntimeException {

	
  public IllegalAccessTimeException(String message) {
	  super(message);
  }

}
