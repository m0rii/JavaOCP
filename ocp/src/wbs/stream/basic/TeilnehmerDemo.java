package wbs.stream.basic;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Teilnehmer {

	LocalDate geburtsjahr;
	String name;

	public Teilnehmer(LocalDate geburtsjahr, String name) {
		this.geburtsjahr = geburtsjahr;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Teilnehmer [geburtsjahr=" + geburtsjahr + ", name=" + name + "]";
	}
}

public class TeilnehmerDemo {
	// wir erzeugen einen stream von teilnehmern.
	// wir berechnen das durchschnittsalter aller teilnehmer und geben es aus.
	// dann sortieren wir den stream aufsteigend nach dem abstand
	// der teilnehmer vom durchschnittsalter (die jüngsten und die ältesten
	// teilnehmer kommen also ans ende, und am anfang stehen die teilnehmer, deren
	// alter
	// nahe beim durchschnittsalter ist).

	// hinweis: mapToLong() von Stream und summaryStatistics() von LongStream
	// könnten nützlich sein...

    public static void main(String[] args) {

        Teilnehmer anna = new Teilnehmer(LocalDate.of(2000, 1, 1), "anna");
        Teilnehmer bernd = new Teilnehmer(LocalDate.of(1990, 1, 1), "bernd");
        Teilnehmer christa = new Teilnehmer(LocalDate.of(2000, 1, 1),
                        "christa");
        Teilnehmer dieter = new Teilnehmer(LocalDate.of(1995, 1, 1), "dieter");
        Teilnehmer emilia = new Teilnehmer(LocalDate.of(1985, 1, 1), "emilia");

        Teilnehmer[] ta = { anna, bernd, christa, dieter, emilia };

        LocalDate now = LocalDate.now();  // now muss effectiv final sein...! warum?

        Function<Teilnehmer, Integer> alter = tn -> {
                return (int) ChronoUnit.YEARS.between(tn.geburtsjahr, now);
        };

        Consumer<Teilnehmer> consumer = tn -> System.out
                        .println(tn + " -> " + alter.apply(tn));  // könnte man hier auch eine method reference verwenden?

        double avg = Stream.of(ta).peek(consumer).mapToInt(t -> alter.apply(t))
                        .summaryStatistics().getAverage(); // avarage() behatre optional double chon age inja getaverage null bashe stream klhali bashe nemifahmim chi shode

        System.out.println("durchschnittalter: " + avg);

        Comparator<Teilnehmer> cmp = (t1, t2) -> {
                int alter1 = alter.apply(t1);
                int alter2 = alter.apply(t2);
                double diff1 = Math.abs(avg - alter1);
                double diff2 = Math.abs(avg - alter2);
                int diff = Double.compare(diff1, diff2);
                return diff != 0 ? diff : t1.geburtsjahr.compareTo(t2.geburtsjahr);
        };

        Stream.of(ta).sorted(cmp).forEach(consumer);
}

}
