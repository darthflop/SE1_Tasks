package org.hbrs.se1.ws24.exercises.uebung4.commands;

import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandExecuter {

    private final List<US_Command> commands = new ArrayList<>();
    US_Command command;


    public void setCommand(US_Command command){
        this.command = command;
    }

    public void execute() throws PersistenceException, IOException, ClassNotFoundException {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Kein gültiger Befehl!");
            System.out.println("Zeige gültige Befehle mit 'help' an.");
        }
    }


}
