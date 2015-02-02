package nl.tkp.uitnodigingen;

public class Evenement {
    private String naam;
    private Uitnodiging uitnodiging;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Uitnodiging getUitnodiging() {
        return uitnodiging;
    }

    public void setUitnodiging(Uitnodiging uitnodiging) {
        this.uitnodiging = uitnodiging;
    }
}
