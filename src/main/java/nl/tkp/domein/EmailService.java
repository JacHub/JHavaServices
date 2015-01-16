package nl.tkp.domein;

/**
 * Created by huizenga.j on 16-01-2015.
 */
public class EmailService implements MailService {
    public void verstuurEmail(String onderwerp, String bericht, String emailAdres) {
        System.out.println("Verstuur mail");
    }

}
