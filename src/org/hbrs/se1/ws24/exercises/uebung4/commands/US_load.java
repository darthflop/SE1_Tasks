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
    private String pfad;

    public US_load(PersistenceStrategyStream<UserStories> strategy, Container c, Scanner sc, String pfad){
        this.strategy = strategy;
        this.c = c;
        this.sc = sc;
        this.pfad = pfad;
    }

    @Override
    public void execute() throws PersistenceException, IOException, ClassNotFoundException {

        c.setPersistenceStrategy(strategy);
        strategy.setLocation(pfad);
        try{
            c.load();
            UserStories.setIdCount(c.getMaxID());
            System.out.println("User Stories wurden geladen!");
        } catch(PersistenceException e){
            System.out.println(e.getMessage());
        }

    }

}
