package nl.tkp.uitnodigingen;

public interface MailService {
    void verstuurEmail(String onderwerp, String bericht, String emailadres);
}
