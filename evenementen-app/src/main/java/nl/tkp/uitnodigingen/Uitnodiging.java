package nl.tkp.uitnodigingen;

import java.util.List;

public class Uitnodiging {
    private String beschrijving;
    private List<Genodigde> genodigden;

    private MailService mailService;
    private Evenement evenement;

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public MailService getMailService() {
        return mailService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public List<Genodigde> getGenodigden() {
        return genodigden;
    }

    public void setGenodigden(List<Genodigde> genodigden) {
        this.genodigden = genodigden;
    }

    public void verstuur() {
        for (Genodigde genodigde : evenement.getUitnodiging().getGenodigden()) {
            mailService.verstuurEmail(evenement.getNaam(),
                    evenement.getUitnodiging().getBeschrijving(),
                    genodigde.getEmailadres());
        }
    }
}
