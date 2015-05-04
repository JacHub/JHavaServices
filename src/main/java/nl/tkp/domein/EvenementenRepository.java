package nl.tkp.domein;

/**
 * Created by huizenga.j on 04-05-2015.
 */
public interface EvenementenRepository {
    long bewaarEvenement(Evenement evenement);

    Evenement haalEvenement(long evenementId);
}
