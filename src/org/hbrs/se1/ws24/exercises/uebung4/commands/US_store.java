package org.hbrs.se1.ws24.exercises.uebung4.commands;

import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;
import org.hbrs.se1.ws24.exercises.uebung4.Container;
import org.hbrs.se1.ws24.exercises.uebung4.UserStories;

import java.io.IOException;
import java.util.Scanner;

public class US_store implements US_Command{

    private PersistenceStrategyStream<UserStories> strategy;
    private Container c;
    private Scanner sc;

    public US_store(PersistenceStrategyStream<UserStories> strategy, Container c, Scanner sc){
        this.strategy = strategy;
        this.c = c;
        this.sc = sc;
    }

    @Override
    public void execute() throws PersistenceException, IOException {

        System.out.print("Geben Sie einen Speicher Pfad ein: ");
        strategy.setLocation(sc.next());

        c.store();

        System.out.println("User Stories erfolgreich gespeichert!");
    }

}
