package org.hbrs.se1.ws24.exercises.uebung4.commands;

import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;

import java.io.IOException;

public interface US_Command {
    void execute() throws PersistenceException, IOException, ClassNotFoundException;
}
