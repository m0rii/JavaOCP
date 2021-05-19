package wbs.pattern.builder;


public class BuchExemplar {
        
        public static class Builder {
                
                private int nr;
                private String isbn;
                private String autor;
                private String titel;
                private String kategorie;
                private double preis;
                
                public Builder setNr(int nr) {
                        this.nr = nr;
                        return this;
                }
                
                public Builder setIsbn (String isbn) {
                        this.isbn =isbn;
                        return this;
                }
                
                public Builder setAutor (String autor) {
                        this.autor = autor;
                        return this;
                }
                
                public Builder setTitel (String titel) {
                        this.titel =titel;
                        return this;
                }
                
                public Builder setKategorie (String kategorie) {
                        this.kategorie = kategorie;
                        return this;
                }
                
                public Builder setPreis (double preis) {
                        this.preis = preis;
                        return this;
                }
                
                public BuchExemplar build() {
                        return new BuchExemplar(nr, isbn, autor, titel, kategorie, preis);
                }
        }
        
        private int nr;
        private String isbn;
        private String autor;
        private String titel;
        private String kategorie;
        private double preis;

        private BuchExemplar(int nr, String isbn, String autor, String titel, String kategorie,
                        double preis) {
                this.nr = nr;
                this.isbn = isbn;
                this.autor = autor;
                this.titel = titel;
                this.kategorie = kategorie;
                this.preis = preis;
        }

        public int getNr() {
                return nr;
        }

        public void setNr(int nr) {
                this.nr = nr;
        }

        public String getIsbn() {
                return isbn;
        }

        public void setIsbn(String isbn) {
                this.isbn = isbn;
        }

        public String getAutor() {
                return autor;
        }

        public void setAutor(String autor) {
                this.autor = autor;
        }

        public String getTitel() {
                return titel;
        }

        public void setTitel(String titel) {
                this.titel = titel;
        }
        
        public String getKategorie( ) {
                return kategorie;
        }
        
        public void setKategorie(String kategorie) {
                this.kategorie = kategorie;
        }

        public double getPreis() {
                return preis;
        }

        public void setPreis(double preis) {
                this.preis = preis;
        }

        @Override
        public String toString() {
                return "BuchExemplar [nr=" + nr + ", isbn=" + isbn + ", autor=" + autor
                                + ", titel=" + titel + ", kategorie=" + kategorie + ", preis="
                                + preis + "]";
        }
}