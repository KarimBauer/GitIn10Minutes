package Kunde;

import dataTypes.Adresse;
import dataTypes.Anrede;

import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
/**@author Karim
 * @version Autovermietung 1.1, JDK 13.0.1, IDEA 2019.3.4 CE
 * @since 1.1
 * models a private costumer that extends Kunde*/

public class Privatkunde extends Kunde{
    private Anrede anrede; /**customer sex*/
    private String vorname; /**customer first name*/
    private String nachname; /**customer last name*/
    private GregorianCalendar geb; /**customer last name*/



    /**creates a costumer with following parameters
     * @param kundennummer customerid
     * @param anrede sex
     * @param vorname first name
     * @param nachname last name
     * @param geb Birthday
     * @param adresse adress
     * @param telefonnummer phone number
     * @param email email adress
     */
    public Privatkunde(String kundennummer, Adresse adresse, String telefonnummer, String email, Anrede anrede,
                       String vorname, String nachname, GregorianCalendar geb) {
        super(kundennummer, adresse, telefonnummer, email);
        this.anrede = anrede;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geb=geb;
    }


    @Override
    /**gets customer name*/
    public String getname() {
        return vorname+" "+nachname;
    }

    @Override
    /**returns aligned String with Privatkunde attributes*/
    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("%-25s| %-10s| %-100s" , anrede +" "+ vorname +" "+ nachname, geb.get(Calendar.DATE)+"."
                +(geb.get(Calendar.MONTH)+1)+"."+geb.get(Calendar.YEAR), super.toString());
        return formatter.toString();
    }


    @Deprecated
    /**compares the name of customers in lexographical order*/
    public int compareTo(Privatkunde o) {
            int compare = nachname.compareTo(o.nachname);
            if (compare==0){
                compare = vorname.compareTo(o.vorname);
        }
            return compare;
    }
}
