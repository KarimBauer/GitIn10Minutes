package Buchhaltung;

import Kunde.Kunde;
import Menu.Eingabe;
import Observer.AutovermietungObserver;
import autovermietung.Autovermietung;
//TODO Observer müssen noch benachrichtigt werden, wann wird welcher Observer benachrichtigt? n

public class RechnungBezahlen {
    private static Autovermietung av;

    /**Method to pay the customers invoice*/
    public static void rechnungBezahlen(){
        Rechnung r=chooseInvoiceToPay();
        if(r!=null&& !r.isBezahlt()){
            System.out.println(r.getKunde().getUnpaidInvoice());        //test
            payInvoice(r);
            System.out.println("Rechnung "+r.getRechnungsnummer()+" wurde bezahlt!");
            System.out.println(r.getKunde().getUnpaidInvoice());        //Test
        }
        else{
            System.out.println("Rechnung existiert nicht oder wurde schon bezahlt!");
            return;
        }
    }

    /**sets invoice status to payd and substracts payment from Unpaidinvoices from customer*/
    public static void payInvoice(Rechnung r){
        av.getRechnungen().get(av.getRechnungen().indexOf(r)).setBezahlt(true); //Sets invoice in array to payd
        float betrag=r.getBetrag();
        Kunde k = av.getKunden().get(r.getKunde().getKundennummer());       //takes customer to payd
        k.setUnpaidInvoice(k.getUnpaidInvoice()-betrag);
    }

    /**Chooses InvoiceID to pay, and sees if it's in the Array of invoices
     * @return choosen Invoice, if it's not in Invoices Array returns null*/
    public static Rechnung chooseInvoiceToPay(){
        av.invoiceByTotal();
        Rechnung r = null;
        int rNR= Eingabe.invoiceChoice();
        for (Rechnung re:av.getRechnungen()){
            if (rNR==re.getRechnungsnummer()) {
                r=re;
                break;
            }
        }
        return r;
    }

    public static void startZahlung(Autovermietung autovermietung){
        av=autovermietung;
        rechnungBezahlen();
    }
}
