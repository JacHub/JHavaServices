package nl.tkp.uitnodigingen;

import java.util.ArrayList;
import java.util.List;

public class EvenementFactory {
    public static Evenement createEvenement(String naam, String beschrijving,
                                            List<String> emailadressen, MailService mailService) {
        List<Genodigde> genodigden = new ArrayList<>();
        for (String emailadres: emailadressen) {
            Genodigde genodigde = new Genodigde(emailadres);
            genodigden.add(genodigde);
        }
        Uitnodiging uitnodiging = new Uitnodiging(beschrijving, genodigden, mailService);
        return new Evenement(naam, uitnodiging);
    }
}
