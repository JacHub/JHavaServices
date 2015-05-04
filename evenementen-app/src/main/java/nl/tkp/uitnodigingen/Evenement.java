package nl.tkp.uitnodigingen;

public class Evenement {
    private String naam;
    private Uitnodiging uitnodiging;

    public Evenement(String naam, Uitnodiging uitnodiging) {
        this.naam = naam;
        this.uitnodiging = uitnodiging;
    }

    public void verstuurUitnodiging() {
        uitnodiging.verstuur(naam);
    }
}
