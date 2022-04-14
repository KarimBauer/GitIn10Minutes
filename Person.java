package Person;

import Observer.IObserver;
import dataTypes.Anrede;

/**Models a Person*/
public abstract class Person implements IObserver {

    protected Anrede anrede; /**person sex*/
    protected String vorname; /**person first name*/
    protected String nachname; /**person last name*/

    public Person(Anrede anrede, String vorname, String nachname){
     this.anrede=anrede;
     this.vorname=vorname;
     this.nachname=nachname;
    }
}
