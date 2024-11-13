package org.hbrs.se1.ws24.exercises.uebung4.commands;

import org.hbrs.se1.ws24.exercises.uebung4.Container;
import org.hbrs.se1.ws24.exercises.uebung4.UserStories;


import java.util.Scanner;

public class US_enter implements US_Command {

    private Scanner sc;
    private Container c;

    public US_enter(Scanner sc, Container c){
        this.sc = sc;
        this.c = c;
    }

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Geben Sie einen kurzen Titel ein: ");
        String titel = sc.next();

        System.out.print("Geben Sie das Akzeptanzkriterium ein: ");
        sc.nextLine();
        String akzeptanzKriterien = sc.nextLine();

        System.out.println("\nNun folgt die Eingabe der Priorisierungen (von 1-5):");

        System.out.print("Relativer Mehrwert: ");
        int mehrwert = sc.nextInt();
        while(mehrwert < 1 || mehrwert > 5){
            System.out.println("Bitte geben Sie einen Wert zwischen 1 und 5 ein.");
            System.out.print("Relativer Mehrwert: ");
            mehrwert = sc.nextInt();
        }

        System.out.print("Relative Strafe: ");
        int strafe = sc.nextInt();
        while(strafe < 1 || strafe > 5){
            System.out.println("Bitte geben Sie einen Wert zwischen 1 und 5 ein.");
            System.out.print("Relative Strafe: ");
            strafe = sc.nextInt();
        }

        System.out.print("Relatives Risiko: ");
        int risiko = sc.nextInt();
        while(risiko < 1 || risiko > 5){
            System.out.println("Bitte geben Sie einen Wert zwischen 1 und 5 ein.");
            System.out.print("Relatives Risiko: ");
            risiko = sc.nextInt();
        }

        System.out.print("Relativer Aufwand: ");
        int aufwand = sc.nextInt();
        while(aufwand < 1 || aufwand > 5){
            System.out.println("Bitte geben Sie einen Wert zwischen 1 und 5 ein.");
            System.out.print("Relativer Aufwand: ");
            aufwand = sc.nextInt();
        }

        sc.nextLine();

        double prio = UserStories.calcPrio(mehrwert, strafe, risiko, aufwand);
        System.out.println("Die berechnete Priorisieung lautet: " + prio);

        System.out.print("\nGeben Sie das zugehörige Projekt ein: ");
        String projekt = sc.nextLine();

        c.addUserStory(new UserStories(titel, akzeptanzKriterien, mehrwert, strafe, risiko, aufwand, projekt, prio));

        System.out.println("\nUser Story erfolgreich erstellt!");

    }
}
