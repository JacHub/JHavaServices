package nl.tkp.uitnodigingen;

import java.util.List;

public class Uitnodiging {
    private String beschrijving;
    private List<Genodigde> genodigden;
    private final MailService mailService;

    public Uitnodiging(String beschrijving, List<Genodigde> genodigden, MailService mailService) {
        this.beschrijving = beschrijving;
        this.genodigden = genodigden;
        this.mailService = mailService;
    }
//
    public void verstuur(String evenementnaam) {
        if (mailService == null) {
            throw new IllegalStateException("mailservice mag niet null zijn");
        }
        for (Genodigde genodigde : genodigden) {
            mailService.verstuurEmail(evenementnaam, beschrijving, genodigde.getEmailadres());
        }
    }
}
