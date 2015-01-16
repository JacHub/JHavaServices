package nl.tkp.domein;

import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import nl.tkp.domein.Evenement;
import nl.tkp.domein.Genodigde;
import nl.tkp.domein.Uitnodiging;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StepDefinitions {
    Evenement evenement;
    Uitnodiging uitnodiging;
    String beschrijving;
    List<String> mailadressen;

    private MailService mailService;
//    private MailService mailService = mock(MailService.class);

    @Gegeven("^een evenement \"([^\"]*)\"$")
    public void een_evenement(String arg1) throws Throwable {
        evenement = new Evenement(arg1);
    }

    @En("^uitnodiging met de volgende beschrijving:$")
    public void uitnodiging_met_de_volgende_beschrijving(String beschrijving) throws Throwable {
        uitnodiging = new Uitnodiging(this.evenement,beschrijving);
    }

    @En("^de volgende genodigden met emailadres:$")
    public void de_volgende_genodigden_met_emailadres(List<String> mailadressen ) throws Throwable {
        List<Genodigde> genodigden = new ArrayList<Genodigde>();

        for (String adres : mailadressen) {
            Genodigde genodigde = new Genodigde(adres);
            genodigden.add(genodigde);
        }
        this.uitnodiging.genodigden = genodigden;
    }

    @Als("^ik de uitnodiging verstuur$")
    public void ik_de_uitnodiging_verstuur() throws Throwable {
        mailService = mock(MailService.class);

//        uitnodiging.verstuurUitnodigingen();
        for (Genodigde genodigde : this.uitnodiging.genodigden) {
            mailService.verstuurEmail(this.evenement.naam , this.uitnodiging.beschrijving,genodigde.emailadres);
        }
    }

    @Dan("^verwacht ik dat elke genodigde een uitnodiging ontvangt$")
    public void verwacht_ik_dat_elke_genodigde_een_uitnodiging_ontvangt() throws Throwable {
        for (Genodigde genodigde : this.uitnodiging.genodigden) {
            verify(mailService).verstuurEmail(evenement.naam, uitnodiging.beschrijving, genodigde.emailadres);
            System.out.println("check adres "+genodigde.emailadres);
        }

    }
}
