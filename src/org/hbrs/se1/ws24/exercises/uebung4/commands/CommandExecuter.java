package org.hbrs.se1.ws24.exercises.uebung4.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandExecuter {

    private final List<US_Command> commands = new ArrayList<>();
    US_Command command;


    public void setCommand(US_Command command){
        this.command = command;
    }

    public void execute() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Kein gültiger Befehl!");
            System.out.println("Zeige gültige Befehle mit 'help' an.");
        }
    }


}
