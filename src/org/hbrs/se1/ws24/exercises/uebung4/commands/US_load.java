package org.hbrs.se1.ws24.exercises.uebung4.commands;

import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;
import org.hbrs.se1.ws24.exercises.uebung4.Container;
import org.hbrs.se1.ws24.exercises.uebung4.UserStories;

import java.io.IOException;
import java.util.Scanner;

public class US_load implements US_Command{

    private PersistenceStrategyStream<UserStories> strategy;
    private Container c;
    private Scanner sc;

    public US_load(PersistenceStrategyStream<UserStories> strategy, Container c, Scanner sc){
        this.strategy = strategy;
        this.c = c;
        this.sc = sc;
    }

    @Override
    public void execute() throws PersistenceException, IOException, ClassNotFoundException {

        System.out.print("Geben Sie den Pfad der Datei ein: ");
        c.setPersistenceStrategy(strategy);
        strategy.setLocation(sc.next());

        c.load();
        UserStories.setIdCount(c.getMaxID());

        System.out.println("User Stories wurden geladen!");
    }

}
