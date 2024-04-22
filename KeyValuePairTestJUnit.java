package AlgoDat.HA1;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class KeyValuePairTestJUnit { //Testen die Fälle
    KeyValuePair key = new KeyValuePair(10);

    @org.junit.jupiter.api.Test
    void hashFunction() {
        Assertions.assertEquals(2,key.hashFunction(2));
    }

    @org.junit.jupiter.api.Test
    void put() {
        Assertions.assertNull(key.put(2,"Help"));
        Assertions.assertEquals("Help",key.put(2,"Hi"));
        assertNull(key.put(1,"Levent"));
    }

    @org.junit.jupiter.api.Test
    void get() {
        key.put(2,"Help");
        Assertions.assertEquals("Help",key.get(2));
    
    }

    @org.junit.jupiter.api.Test
    void remove() {
        key.put(2,"Help");
        Assertions.assertEquals("Help", key.remove(2));
        assertNull(key.remove(2));

    }
} // 10x getestet, um einen Durchschnittswert herauszufinden
  // 23 + 25 + 25 + 23 + 21 + 22 + 24 + 22 + 24 + 27 = 237. 237/10 = 23,7 ms.