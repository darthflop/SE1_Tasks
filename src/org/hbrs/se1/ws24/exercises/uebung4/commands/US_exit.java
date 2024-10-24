package org.hbrs.se1.ws24.exercises.uebung4.commands;

public class US_exit implements US_Command {

    @Override
    public void execute() {
        System.out.println("Programm wird beendet.");
        System.exit(0);
    }
}
