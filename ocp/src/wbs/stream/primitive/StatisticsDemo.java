package wbs.stream.primitive;

import java.io.IOException;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;

import wbs.pattern.builder.BuchExemplar;
import wbs.pattern.builder.BuchExemplarUtil;

public class StatisticsDemo {

        public static void main(String[] args) throws IOException {

                String booksPath = "resources/io/buchexemplare.txt";
                List<BuchExemplar> exemplare = BuchExemplarUtil
                                .exemplareFromFile(booksPath, "\t+");

                // durchschnittpreis aller exemplare
                
                double durchnitt = exemplare.stream().mapToDouble(BuchExemplar::getPreis).summaryStatistics().getAverage();
                System.out.println("durchschnittpreis: " +durchnitt);
               
    

                // durchschnittspreis und anzahl aller exemplare von melville
               DoubleSummaryStatistics ds1 =exemplare.stream().filter(a->a.getAutor().equalsIgnoreCase("herman melville")).mapToDouble(e->e.getPreis()).summaryStatistics();
                System.out.println("durchschnittspreis und anzahl aller exemplare von melville : " + ds1.getAverage());
                System.out.println("anzahl /  melville : " + ds1.getCount());
                // niedrigster und höchster buchpreis
                
                DoubleSummaryStatistics ds2 = exemplare.stream().mapToDouble(BuchExemplar::getPreis).summaryStatistics();
                System.out.println("niedrigster buchpreis: " + ds2.getMin());
                System.out.println("höchster buchpreis: " + ds2.getMax());
        }
        
        
        // IntStream , DoubleStream,LongStream
        // IntSummaryStatics, DoubleSummaryStatics , LongSummaryStatics -> lifert viele sache wie durschnitt , max , min und so ..
        // methode range(startinclusive,endexclusive)
        
}


