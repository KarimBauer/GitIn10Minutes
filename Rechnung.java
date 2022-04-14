package Buchhaltung;
import Kunde.Kunde;
import autovermietung.Auto;

import java.io.Serializable;
import java.util.Formatter;
import java.util.UUID;

/**@author Karim
 * @version Autovermietung 1.2, JDK 13.0.1, IDEA 2019.3.4 CE
 * @since 1.2
 *Represents an invoice*/

public class Rechnung implements Comparable<Rechnung>, Serializable {
    private int rechnungsnummer; /**invoice ID, randomly generated*/
    private static int rNR=1; /**Class variable to give ongoing invoiceIDs*/
    private Kunde kunde; /**Customer which belongs to invoice*/
    private long gefahreneKM; /**driven KM during rental*/
    private float betrag; /**total to pay*/
    private boolean bezahlt; /**paid or not*/

    /**kunden Constructor
     * @param kunde Customer of theinvoice
     * @param gefahreneKM drive KM
     * @param bezahlt paid?
     * @param betrag total invoice*/
    public Rechnung(Kunde kunde, long gefahreneKM, float betrag, boolean bezahlt) {
        this.rechnungsnummer=++rNR;
        this.kunde = kunde;
        this.gefahreneKM = gefahreneKM;
        this.betrag=betrag;
        this.bezahlt = bezahlt;

    }

    //Methods
    /**calculates total invoice price
     * @param a Car*/
    public void berechnung(Auto a){
        this.betrag = gefahreneKM+a.getPreisKM();
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        return formatter.format("%-4o| %-6o| %-5.2f| %-5s| %-10s|",rechnungsnummer, gefahreneKM, betrag, bezahlt,
                kunde.getKundennummer()).toString();
    }

    /**gets Rechnungsnummmer
     * @return rechnungsnummer*/
    public int getRechnungsnummer() {
        return rechnungsnummer;
    }
    /**gets Betrag
     * @return Betrag/Total*/
    public float getBetrag() {
        return betrag;
    }

    @Override
    public int compareTo(Rechnung r) {
        int compare= Integer.compare((int) betrag,(int) r.getBetrag());
        return compare;
    }

    /**sets if invoice is payd
     * @param bezahlt invoice Payd*/
    public void setBezahlt(boolean bezahlt) {
        this.bezahlt = bezahlt;
    }

    /**returns if invoice is payd
     * @return if invoice is payd*/
    public boolean isBezahlt() {
        return bezahlt;
    }

    /**get's customer belonging to invoice
     * @return customer*/
    public Kunde getKunde() {
        return kunde;
    }
}
