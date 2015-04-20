package nl.tkp.uitnodigingen;

/**
 * Created by talsma.s on 20-04-2015.
 */
public interface EvenementenRepository {

    long bewaarEvenement(Evenement evenement);

    Evenement haalEvenement(long evenmentId);

}
