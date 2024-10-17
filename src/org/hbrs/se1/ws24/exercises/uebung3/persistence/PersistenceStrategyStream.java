package org.hbrs.se1.ws24.exercises.uebung3.persistence;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {

    // URL of file, in which the objects are stored
    private String location = "objects.ser";

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     * Look-up in Google for further help!
     */
    public void save(List<Member> member) throws PersistenceException {

        // Exception, falls dir nicht existiert
        File dir = new File(location);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,
                    "Das Verzeichnis existiert nicht oder ist kein Verzeichnis: " + location);
        }

        // Versuche, die Datei zu schreiben
        try (FileOutputStream fos = new FileOutputStream(location + "ContainerList");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // member Liste speichern
            oos.writeObject(member);

        } catch (IOException e) {
            // Fehler beim Speichern protokollieren und neue Ausnahme werfen
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,
                    "Fehler beim Speichern der Datei: " + e.getMessage());
        }
    }


    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<Member> load() throws PersistenceException {

        List<Member> newList = null;

        try (FileInputStream fis = new FileInputStream(location + "ContainerList");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                newList = (List<Member>) obj; // Typensicherheit herstellen
                fis.close();
                ois.close();
                return newList;
            } else {
                throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,
                        "Das gelesene Objekt ist keine Liste.");
            }

        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,
                    "Fehler beim Lesen der Datei: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable,
                    "Die Klasse konnte nicht gefunden werden: " + e.getMessage());
        }



        // Some Coding hints ;-)


        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );

        // Tipp: Use a directory (ends with "/") to implement a negative test case ;-)
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams

    }
}
