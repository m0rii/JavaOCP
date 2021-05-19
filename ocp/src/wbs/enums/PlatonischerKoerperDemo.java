package wbs.enums;

public class PlatonischerKoerperDemo {

	public static void main(String[] args) {
		
			for(PlatonischerKoerper p : PlatonischerKoerper.values() ) {
			System.out.println(p.name());
			System.out.println(p.getClass());
			System.out.println(p.ecken());
			System.out.println(p.kanten());
			System.out.println(p.flaechen());
			System.out.println();
		}


	}

}
