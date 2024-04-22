package AlgoDat.HA1;

import java.util.LinkedList;

/* Levent Avgören, 941761
   Eray Kaan Zor, 941157
*/


public class KeyValuePair implements IntStringMap{
    /* LinkedList = Verkettete Liste
       [] = Array
     */

    LinkedList<Pair>[] hashtable;

    public KeyValuePair(int n) {

        hashtable = (LinkedList<Pair>[]) new LinkedList[n]; //Größe der Hashtable initialisieren

    }

    int hashFunction(Integer key){ //berechnet die Hashfunktion

        return Math.abs(key.hashCode() % hashtable.length);

    }

    @Override
    public String put(Integer key, String value) {
        Pair pairest = new Pair(key,value); // erstellen ein Pair-Objekt

        if(hashtable[hashFunction(key)] == null) { // Schaut nach, ob die Stelle frei ist. Wenn ja, wird das Pair in die Liste hinzugefügt.

            hashtable[hashFunction(key)] = new LinkedList<>();
            hashtable[hashFunction(key)].add(pairest);
            return null;

        }else { //Schaut nach, ob die Stelle besetzt ist, wenn ja, wird dieser ausgedruckt und dann ersetzt

            Pair tester = hashtable[hashFunction(key)].getFirst(); //unseren Wert in den Tester packen


            String ValueBefore = tester.getB(); //speichern den alten Wert


            hashtable[hashFunction(key)].set(0, pairest);//Wird mit dem neuen Pair ersetzt


            return ValueBefore;

        }

    }

    @Override
    public String get(Integer key) {
       if(hashtable[hashFunction(key)].getFirst() == null){ //Schaut nach, ob der Wert leer ist. Wenn nicht, wird der Wert zurückgegeben.

            return null;

        } else{

           Pair tester = hashtable[hashFunction(key)].getFirst(); //unseren Wert in den Tester packen

           return tester.getB();

        }

    }

    @Override
    public String remove(Integer key) {

        if(hashtable[hashFunction(key)] == null){ //schaut nach, ob vorher zu dem Wert etwas hinzugefügt wurde
            return null;
        }

        if(hashtable[hashFunction(key)].getFirst() != null ) { // Vorhanden um zu überprüfen, ob die jetzige Stelle besetzt ist, wenn ja, dann wird es ausgedruckt

            Pair tester = hashtable[hashFunction(key)].getFirst();

            String ValueBefore = tester.getB();

            hashtable[hashFunction(key)].set(0, new Pair(0,null)); //Unsicher, ob das die richtige Methode ist //Setzten das Pair Objekt auf null

            return ValueBefore;

        }else { //Wenn nicht, wird null returned

            return null;

        }
    }
}