package wbs.jekyll_and_hyde;

public class AntiTransitivist {   
    private String s;

    public AntiTransitivist(String s) {
            this.s = s;
    }

    @Override
    public int hashCode() {
            return s.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
            boolean result = false;
            if (obj != null && obj instanceof AntiTransitivist) {
                    AntiTransitivist other = (AntiTransitivist) obj;
                    int i;
                    for (i = 0; i < s.length()
                                    && other.s.indexOf(s.charAt(i)) < 0; i++) {
                    }
                    result = (i < s.length());
            }
            return result;
    }

    public static void main(String[] args) {
            AntiTransitivist anton = new AntiTransitivist("anton");
            AntiTransitivist berta = new AntiTransitivist("berta");
            AntiTransitivist chris = new AntiTransitivist("chris");
            System.out.println(anton.equals(anton));
            System.out.println(anton.equals(berta));
            System.out.println(berta.equals(anton));
            System.out.println(berta.equals(chris)); // wegen r
            System.out.println(chris.equals(berta));
            System.out.println(anton.equals(chris)); // nicht transitiv und false so implementierung von eqwuals ist nicht korrekt
            
            // reflexiv , symmertisch aber nicht transiv
    }
}