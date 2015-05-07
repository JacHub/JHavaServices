package nl.tkp.uitnodigingen;

import javax.sql.DataSource;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.google.common.base.Preconditions.checkState;

public class Evenement {
    private String naam;
    private Uitnodiging uitnodiging;

    private String HAAL_OP_ID_QUERY = "select * from cop_evenementen where id = ?";
    @Inject private DataSource dataSource;

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

    public Evenement(String naam, Uitnodiging uitnodiging) {
        this.naam = naam;
        this.uitnodiging = uitnodiging;
    }

    public void verstuurUitnodiging() {
        uitnodiging.verstuur(naam);
    }
}
