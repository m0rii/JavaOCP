package wbs.enums;

/*
Wir implementieren nun PlatonischerKoerper2.

Die zweite Variante hat keine abstrakten Methoden,

Die Konstanten bekommen keinen eigenen Body und der Enum
definiert 3 Felder, die vom Konstruktor geeignet initialisiert werden.


*/
public enum PlatonischerKoerper2 {
	TETRAEDER(4, 4, 6), OKTAEDER(4, 6, 12), HEXAEDER(8, 6, 12), IKOSAEDER(12, 20, 30), DODEKAEDER(20, 12, 30);

	private PlatonischerKoerper2(int flaechen, int kanten, int ecken) {
		this.flaechen = flaechen;
		this.kanten = kanten;
		this.ecken = ecken;
	}

	private int flaechen;
	private int kanten;
	private int ecken;

	public int getFlaechen() {
		return flaechen;
	}

	public void setFlaechen(int flaechen) {
		this.flaechen = flaechen;
	}

	public int getKanten() {
		return kanten;
	}

	public void setKanten(int kanten) {
		this.kanten = kanten;
	}

	public int getEcken() {
		return ecken;
	}

	public void setEcken(int ecken) {
		this.ecken = ecken;
	}

	@Override
	public String toString() {
		return this.name() + " [flaechen=" + flaechen + ", ecken=" + ecken + ", kanten=" + kanten + "]";
	}

}
