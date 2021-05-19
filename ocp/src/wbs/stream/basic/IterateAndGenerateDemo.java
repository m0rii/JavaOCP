package wbs.stream.basic;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.function.Supplier;
//import java.util.stream.Stream;
//
//import wbs.basics.Figur2D;
//import wbs.basics.Kreis;
//import wbs.basics.Rechteck;
//import wbs.util.LottoUtil;
//
//public class IterateAndGenerateDemo {
//
//	public static void main(String[] args) {
//		/*
//		 * wir geben die ersten 10 zahlen aus , die groesser sind als 1000, und genau 5 einserbits haben
//		 */
//		
//		Stream.iterate(1001, x->x+1 ) .filter(n -> Integer.bitCount(n) == 5).limit(10L)
//		.forEach(n-> System.out.printf(" %4d %10s%n" ,n,Integer.toBinaryString(n)));
//		
//		
//		/*
//		 * wir erzeugen 10 zufaellige lottotips und geben sie in geeingneter weise aus
//		 */
//		LottoUtil.createTipp();
//		 LottoUtil.randomTipp();
//		 
//		 Stream.generate(()->LottoUtil.randomTipp()).limit(10)
//		 .forEach((tipp)-> System.out.println(LottoUtil.tippAsString(tipp)));
//		 
//         /* wir erzeugen 10 zufällige lottotipps, die mit den zahlen der
//         * letzten ziehung in genau 3 zahlen übereinstimmen,  und geben sie in geeigneter
//         * weise aus (4 16 20 31 34 38)
//         */
//		 System.out.println("-------------------------");
//		 long ziehungzahlen = LottoUtil.createTipp(4,16,20,31,34,38);
//	   
//		 System.out.println("ziehungszahlen: "+ LottoUtil.tippAsString(ziehungzahlen));
//		 
//		 Stream.generate(()->LottoUtil.randomTipp()).filter(tipp -> LottoUtil.anzahlTreffer(tipp, ziehungzahlen) == 3).limit(10)
//		 .forEach((tipp)-> System.out.println(LottoUtil.tippAsString(tipp)));
//		 
//		 
//		 /*
//          * wir erzeugen einen stream aus 20 Figur2D- objekten: rechtecken und kreisen.
//          * die auswahl rechteck oder kreis erfolgt zufällig.
//          * radius / seitenlängen sollen jeweils zufallswerte zwischen 0 und 1 sein.
//          * 
//          * dann sortieren wir den stream aufsteigend nach der flaeche und geben ihn aus.
//          * 
//          */
//		 System.out.println("--------------------");
//		 
//		 Supplier<Figur2D> supplier = ()-> Math.random() > 0.5
//				 ? new Kreis(Math.random()) 
//				 : new Rechteck(Math.random(),Math.random());
//      Comparator<Figur2D> cmp = (f1,f2) -> Double.compare(f1.flaeche(),f2.flaeche());
//      
//      Stream.generate(supplier).limit(20).sorted(cmp).forEach(f->System.out.println(f));
//	
//	}
//
//}
