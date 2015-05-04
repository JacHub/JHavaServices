package nl.tkp.domein;

import javax.sql.DataSource;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.google.common.base.Preconditions.checkState;

/**
 * Created by Jacob on 14-1-2015.
 */

public class Evenement implements EvenementenRepository{
    private    String naam;
    private Uitnodiging uitnodiging;
    private MailService emailService;
    private String HAAL_OP_ID_QUERY = "select * from cop_evenementen where id = ?";

    @Inject private DataSource dataSource;

    public Evenement() {
    }

    Evenement(String naam,Uitnodiging uitnodiging, MailService mailService){
        this.naam = naam;
        this.uitnodiging = uitnodiging;
        this.emailService = mailService;
    }

    @Override
    public long bewaarEvenement(Evenement evenement) {
        return 0;
    }

    @Override
    public Evenement haalEvenement(long evenementId) {
        checkState(dataSource != null,"Geen datasource aanwezig!");
        Evenement evenement = null;
        try ( Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(HAAL_OP_ID_QUERY)) {
                statement.setLong(1,evenementId);
                try ( ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        evenement = mapper.map(rs);
                    }
                }
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("SQL fout opgetreden: "+sqle.getMessage(),sqle);
        }
        return evenement;
    }

    public String getNaam() {
        return naam;
    }

    public Uitnodiging getUitnodiging() {
        return uitnodiging;
    }

    public void verstuurUitnodigingen() {
        for (Genodigde genodigde : uitnodiging.getGenodigden()) {
            emailService.verstuurEmail(this.naam, uitnodiging.getBeschrijving(), genodigde.getEmailadres());
        }
    }

}
