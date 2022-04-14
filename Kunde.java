package Kunde;

import autovermietung.Auto;
import dataTypes.Adresse;

import java.io.Serializable;
import java.util.Formatter;
/**@author Karim
 * @version Autovermietung 1.1, JDK 13.0.1, IDEA 2019.3.4 CE
 * @since 1.1
 * models abstract class costumer */
public abstract class Kunde implements Comparable<Kunde>, Serializable {
    private String kundennummer; /**costumer number*/
    private Adresse adresse; /**costumer adress*/
    private String telefonnummer; /**costumer telefone number*/
    private String email; /**costumer email*/
    private Auto kundenAuto; /**costumer rented car*/
    private float unpaidInvoice; /**sums up the unpaid customer invoice total*/

    /**creates a costumer with following parameters
     * @param kundennummer customerid
     * @param adresse adress
     * @param telefonnummer phone number
     * @param email email adress
     * IllegalArgumentException when entering wrong parameters for Birthday
     * */
    public Kunde(String kundennummer, Adresse adresse, String telefonnummer, String email) {
        this.kundennummer = kundennummer;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.email = email;
    }

    /**gets customer name
     * @return customer name*/
    public abstract String getname();

    /**a car can be rented by the costumer, if it's not already rented out or car already is rented
     * sets vermietet to true if car is free
     * @param car car that is going to be rented*/
    public void autoMieten(Auto car){
        if(kundenAuto!=null||car.isVermietet()){
            if (kundenAuto!=null){
                System.out.println("Kunde "+kundennummer
                        +" hat schon ein Auto gemietet.");
            }
            if(car.isVermietet()){
                System.out.println("Das Auto mit dem Kennzeichen "+car.getKennzeichen()
                        +" ist schon vermietet. Bitte wähle ein anderes aus.");
            }
        }
        else {
            this.kundenAuto = car;
            kundenAuto.setVermietet(true);
        }
    }

    @Override
    /**@return aligned String with kunde attributes*/
    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("%-5s| %-40s %-15s| %-20s| %-100s" , kundennummer, adresse, telefonnummer, email, kundenAuto);
        return formatter.toString();
    }

    /**gets kundennummer and
     * @return kundennummer*/
    public String getKundennummer() {
        return kundennummer;
    }
    /**gets customer car and
     * @return customer car*/
    public Auto getKundenAuto() {
        return kundenAuto;
    }

    public void setKundenAuto(Auto kundenAuto) {
        this.kundenAuto = kundenAuto;
    }

    /**sets unpaid Invoices
     * @param unpaidInvoice sum of the unpaid invoice*/
    public void setUnpaidInvoice(float unpaidInvoice) {
        this.unpaidInvoice = unpaidInvoice;
    }

    /**gets the total of unpaid invoices
     * @return total of unpaid invoices*/
    public float getUnpaidInvoice() {
        return unpaidInvoice;
    }

    /**compares the names of customers in lexographical order*/
    public int compareTo(Kunde k){
        return this.getname().compareTo(k.getname());
    }
}
