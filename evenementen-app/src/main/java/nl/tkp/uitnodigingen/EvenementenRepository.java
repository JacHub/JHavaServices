package nl.tkp.uitnodigingen;

public interface EvenementenRepository {

    long bewaarEvenement(Evenement evenement);

    Evenement haalEvenement(long evenmentId);

}
