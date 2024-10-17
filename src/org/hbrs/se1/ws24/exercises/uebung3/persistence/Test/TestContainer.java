package org.hbrs.se1.ws24.exercises.uebung3.persistence.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.hbrs.se1.ws24.exercises.uebung2.ConcreteMember;
import org.hbrs.se1.ws24.exercises.uebung2.Container;
import org.hbrs.se1.ws24.exercises.uebung2.Member;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class TestContainer {

    Container c;

    @BeforeEach
    void init(){
        c = Container.getContainer();
    }

    @Test
    void testNoStrategy(){

        // Test auf NoStrategyIsSet, wenn PersistenceStrategy == null
        PersistenceException exception = assertThrows(PersistenceException.class, () -> c.store());
        assertEquals(PersistenceException.ExceptionType.NoStrategyIsSet, exception.getExceptionTypeType());
    }

    @Test
    void PersistenceStrategyMongoDB(){

        // Test auf UnsupportedOperationException, wenn PersistenceStrategyMongoDB genutzt wird
        c.setPersistenceStrategy(new PersistenceStrategyMongoDB<>());
        assertThrows(UnsupportedOperationException.class, () -> c.store());
    }

    @Test
    void fileLocation(){

        // PersistenceStrategy setzen
        PersistenceStrategyStream<Member> streamStrategy = new PersistenceStrategyStream<Member>();
        streamStrategy.setLocation("/invalid/path/");
        c.setPersistenceStrategy(streamStrategy);

        // Speichern mit ungültigem Pfad
        PersistenceException exception = assertThrows(PersistenceException.class, () -> c.store());
        assertEquals(PersistenceException.ExceptionType.ConnectionNotAvailable, exception.getExceptionTypeType());
    }

    @Test
    void RoundTripTest() throws PersistenceException, IOException, ClassNotFoundException {

        // Stream-Strategie setzen
        PersistenceStrategyStream<Member> streamStrategy = new PersistenceStrategyStream<>();
        streamStrategy.setLocation("C:/Users/Filip/Downloads/");
        c.setPersistenceStrategy(streamStrategy);

        // Initial Zustand testen
        assertEquals(0, c.size());

        // Objekte hinzufuegen und Zustand pruefen
        c.addMember(new ConcreteMember(1));
        assertEquals(1, c.size());

        // Liste persistent speichern
        c.store();

        // Objekt wieder loeschen und Zustand pruefen
        c.deleteMember(1);
        assertEquals(0, c.size());

        // Liste wieder laden und Zustand pruefen
        c.load();
        assertEquals(1, c.size());
    }
}
