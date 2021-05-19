package wbs.threads;
/*
 * -------------------------------
- was liefert die methode currentThread()? reference aktuelle thread 
- wie sieht die string-repräsentation eines threads aus? Thread[main,pioritat,threadgroup]
- mit welchen prioritäten laufen die threads?
- kann man exakt voraussagen, welche ausgabe dieser code erzeug? nein kann man nicht voraus sagen
- wie würde sich die anzeige ändern, wenn in zeile 15 die methode run()
  anstelle der methode start() aufgerufen wird?
  - was passiert, wenn wir in die run()- methode von ExtendsThread
  eine endlos-schleife einbauen? program leuft immer


 * */
class ExtendsThread extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread());
	//	while(true);
	}
}

public class ExtendsThreadDemo {
	public static void main(String[] args) {
		ExtendsThread extendsThread = new ExtendsThread();
		extendsThread.start();
	 //extendsThread.run(); khat bala ro comment konim  va ino ejra konim hich thread jaidi ejra nashode
		System.out.println(Thread.currentThread());
	}
}
// ausgabe
// Thread[main,5,main]
// Thread[Thread-0,5,main]
