package nl.tkp.uitnodigingen;

import cucumber.api.PendingException;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StepDefinitions {
    private MailService mailService = mock(MailService.class);

    private String naam;
    private String beschrijving;
    private List<String> emailadressen;

    @Gegeven("^een evenement \"([^\"]*)\"$")
    public void een_evenement(String naam) throws Throwable {
        this.naam = naam;
    }

    @En("^uitnodiging met de volgende beschrijving:$")
    public void een_uitnodiging_met_beschrijving(String beschrijving) throws Throwable {
        this.beschrijving = beschrijving;
    }

    @En("^de volgende genodigden met emailadres:$")
    public void de_volgende_genodigden_met_emailadres(List<String> emailadressen) throws Throwable {
        this.emailadressen = emailadressen;
    }

    @Als("^ik de uitnodiging verstuur$")
    public void ik_de_uitnodiging_verstuur() throws Throwable {
        Evenement evenement = EvenementFactory.createEvenement(naam, beschrijving,
                emailadressen, mailService);
        evenement.verstuurUitnodiging();
    }

    @Dan("^verwacht ik dat elke genodigde een uitnodiging ontvangt$")
    public void verwacht_ik_dat_elke_genodigde_een_uitnodiging_ontvangt() throws Throwable {
        for (String emailadres: emailadressen) {
            verify(mailService).verstuurEmail(naam, beschrijving, emailadres);
        }
    }
}
