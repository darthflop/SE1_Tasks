package org.hbrs.se1.ws24.exercises.uebung1.control;
import static org.junit.jupiter.api.Assertions.*;
import org.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;

public class GermanTranslatorTest {

    @Test
    public void aTest() {
        GermanTranslator translator = new GermanTranslator();

        // test der Zahl 0
        assertEquals("Übersetzung der Zahl 0 nicht möglich" , translator.translateNumber(0));

        //test negativer Zahlen
        assertEquals("Übersetzung der Zahl -1 nicht möglich" , translator.translateNumber(-1));
        assertEquals("Übersetzung der Zahl -55 nicht möglich" , translator.translateNumber(-55));
        assertEquals("Übersetzung der Zahl -235 nicht möglich" , translator.translateNumber(-235));

        // tests aller Zahlen von 1 bis 10 (da es nur zehn sind)
        assertEquals("eins" , translator.translateNumber(1));
        assertEquals("zwei" , translator.translateNumber(2));
        assertEquals("drei" , translator.translateNumber(3));
        assertEquals("vier" , translator.translateNumber(4));
        assertEquals("fuenf" , translator.translateNumber(5));
        assertEquals("sechs" , translator.translateNumber(6));
        assertEquals("sieben" , translator.translateNumber(7));
        assertEquals("acht" , translator.translateNumber(8));
        assertEquals("neun" , translator.translateNumber(9));
        assertEquals("zehn" , translator.translateNumber(10));

        //tests Zahlen >10
        assertEquals("Übersetzung der Zahl 11 nicht möglich" , translator.translateNumber(11));
        assertEquals("Übersetzung der Zahl 110 nicht möglich" , translator.translateNumber(110));
        assertEquals("Übersetzung der Zahl 4567 nicht möglich" , translator.translateNumber(4567));
    }

}
