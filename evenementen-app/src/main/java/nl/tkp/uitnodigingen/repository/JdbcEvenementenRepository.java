package nl.tkp.uitnodigingen.repository;

import nl.tkp.uitnodigingen.Evenement;
import nl.tkp.uitnodigingen.EvenementenRepository;

/**
 * Created by talsma.s on 20-04-2015.
 */
public class JdbcEvenementenRepository implements EvenementenRepository {

    @Override
    public long bewaarEvenement(Evenement evenement) {
        throw new UnsupportedOperationException("bewaarEvenement is nog niet gerealiseerd.");
    }

    @Override
    public Evenement haalEvenement(long evenmentId) {
        throw new UnsupportedOperationException("haalEvenement is nog niet gerealiseerd.");
    }

}
