package wbs.enums;

public class PlatonischerKoerper2Demo {

	public static void main(String[] args) {
		for(PlatonischerKoerper2 p : PlatonischerKoerper2.values() ) {
			System.out.println(p.name());
			System.out.println(p.getClass().getName());
			System.out.println("flaechen " + p.getFlaechen());
			System.out.println("ecken" +p.getEcken());
			System.out.println("kanten "+  p.getKanten());
			
			System.out.println();
		}
		
       
	}

}
