import cucumber.api.PendingException;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StepDefinitions {
    String evenement;
    String beschrijving;
    List<String> mailadressen;

    private MailService mailService = mock(MailService.class);

    @Gegeven("^een evenement \"([^\"]*)\"$")
    public void een_evenement(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        this.evenement = arg1;
    }

    @En("^uitnodiging met de volgende beschrijving:$")
    public void uitnodiging_met_de_volgende_beschrijving(String beschrijving) throws Throwable {
        // Express the Regexp above with the code you wish you had
        this.beschrijving = beschrijving;
    }

    @En("^de volgende genodigden met emailadres:$")
    public void de_volgende_genodigden_met_emailadres(List<String> mailadressen ) throws Throwable {
        // Express the Regexp above with the code you wish you had
        this.mailadressen = mailadressen;
    }

    @Als("^ik de uitnodiging verstuur$")
    public void ik_de_uitnodiging_verstuur() throws Throwable {
        // Express the Regexp above with the code you wish you had
        for (String mailadres : mailadressen) {
            mailService.verstuurEmail(this.evenement, this.beschrijving, mailadres);
        }
    }

    @Dan("^verwacht ik dat elke genodigde een uitnodiging ontvangt$")
    public void verwacht_ik_dat_elke_genodigde_een_uitnodiging_ontvangt() throws Throwable {
        // Express the Regexp above with the code you wish you had
        for (String mailadres : mailadressen) {
            verify(mailService).verstuurEmail(evenement, beschrijving, mailadres);
            System.out.println("check adres "+mailadres);
        }

    }
}
