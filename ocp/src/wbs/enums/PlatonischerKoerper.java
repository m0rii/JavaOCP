package wbs.enums;

public enum PlatonischerKoerper {
	TETRAEDER {
		public int flaechen() {
			return 4;
		}

		public int kanten() {
			return 6;
		}

		public int ecken() {
			return 4;
		}
	},
	OKTAEDER {
		public int flaechen() {
			return 8;
		}

		public int kanten() {
			return 12;
		}

		public int ecken() {
			return 6;
		}
	},
	HEXAEDER {
		public int flaechen() {
			return 6;
		}

		public int kanten() {
			return 12;
		}

		public int ecken() {
			return 8;
		}
	},
	IKOSAEDER {
		public int flaechen() {
			return 20;
		}

		public int kanten() {
			return 30;
		}

		public int ecken() {
			return 12;
		}
	},
	DODEKAEDER {
		public int flaechen() {
			return 12;
		}

		public int kanten() {
			return 30;
		}

		public int ecken() {
			return 20;
		}
	};

// class-body
	public abstract int flaechen();

	public abstract int kanten();

	public abstract int ecken();
}