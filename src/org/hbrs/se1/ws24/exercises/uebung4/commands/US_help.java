package org.hbrs.se1.ws24.exercises.uebung4.commands;

public class US_help implements US_Command{

    @Override
    public void execute(){
        System.out.println("enter - Eingabe einer User Story");
        System.out.println("store - Abspeichern");
        System.out.println("load - Laden");
        System.out.println("dump - nach Priorisierung soriterte Ausgabe aller User Stories");
        System.out.println("exit - Programm beenden");
    }
}
