package Person;

import Buchhaltung.Rechnung;
import Observer.IObserver;
import autovermietung.Autovermietung;
import dataTypes.Anrede;

public class Angestellter extends Person implements IObserver {
    /**
     * person last name
     *
     * @param anrede
     * @param vorname
     * @param nachname
     */
    public Angestellter(Anrede anrede, String vorname, String nachname) {
        super(anrede, vorname, nachname);
    }

    @Override
    public void aktualisieren(Rechnung rechnung) {
        System.out.println("Angestellter "+ this.anrede+" "+this.vorname+" "+this.nachname+" hat die Information erhalten, " +
                        "dass "+rechnung.getKunde().getname()+", Rechnungs Nr. "+rechnung.getRechnungsnummer()+"  zu viele Schulden hat.");
    }
}
