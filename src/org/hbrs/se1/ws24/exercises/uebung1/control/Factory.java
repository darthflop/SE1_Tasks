package org.hbrs.se1.ws24.exercises.uebung1.control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Factory {

    public static GermanTranslator createGermanTranslator(){

        GermanTranslator translator = new GermanTranslator();

        // aktuelles Datum als String speichern
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM/yyyy", Locale.GERMAN);
        String date = currentDate.format(formatter);

        // datum setzen
        translator.setDate(date);

        return translator;
    }

}
