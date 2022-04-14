package Kunde;

import dataTypes.Adresse;
import java.util.Formatter;
/**@author Karim
 * @version Autovermietung 1.1, JDK 13.0.1, IDEA 2019.3.4 CE
 * @since 1.1
 * models a company costumer that extends Kunde*/
public class Geschaeftskunde extends Kunde{
    public String firmenname;    /**company name*/

    /**creates a costumer with following parameters
     * @param kundennummer company customerid
     * @param adresse company adress
     * @param telefonnummer company phone number
     * @param email company email adress
     * @param firmenname company name
     * */
    public Geschaeftskunde(String kundennummer, Adresse adresse, String telefonnummer, String email, String firmenname) {
        super(kundennummer, adresse, telefonnummer, email);
        this.firmenname = firmenname;
    }

    @Override
    /**@return aligned String with Geschäftskunde attributes*/
    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("%-25s| %-10s| %-100s","Fa. "+ firmenname,"", super.toString());
        return formatter.toString();
    }

    @Override
    /**gets customer name
     * @return */
    public String getname() {
        return firmenname;
    }

    @Deprecated
    public int compareTo(Geschaeftskunde o) {
        return firmenname.compareTo(o.firmenname);
    }
}
