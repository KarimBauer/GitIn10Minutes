package Person;

import Buchhaltung.Rechnung;
import Observer.IObserver;
import autovermietung.Autovermietung;
import dataTypes.Anrede;

public class Buchhalter extends Person implements IObserver {
    /**
     * person last name
     *
     * @param anrede
     * @param vorname
     * @param nachname
     */
    public Buchhalter(Anrede anrede, String vorname, String nachname) {
        super(anrede, vorname, nachname);
    }

    @Override
    public void aktualisieren(Rechnung rechnung) {
        System.out.println("Buchhalter "+ this.anrede+" "+this.vorname+" "+this.nachname+" hat die Information erhalten, dass die\n" +
                "Rechnung Nr. "+rechnung.getRechnungsnummer()+" bezahlt wurde.");
    }
}
