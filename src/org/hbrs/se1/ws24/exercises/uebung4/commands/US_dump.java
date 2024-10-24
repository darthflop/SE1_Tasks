package org.hbrs.se1.ws24.exercises.uebung4.commands;

import org.hbrs.se1.ws24.exercises.uebung4.Container;
import org.hbrs.se1.ws24.exercises.uebung4.UserStories;

public class US_dump implements US_Command {

    Container c;

    public US_dump(Container c){
        this.c = c;
    }

    @Override
    public void execute() {

        // Kopfzeile der Tabelle
        System.out.printf("%-15s %-20s %-25s %-10s %-10s %-10s %-10s %-20s\n",
                "ID", "Titel", "Akzeptanzkriterium", "Mehrwert", "Strafe", "Risiko", "Aufwand", "Projekt");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");

        // Inhalte der User Stories in tabellarischer Form ausgeben
        for (UserStories us : c.getCurrentList()) {
            System.out.printf("%-15s %-20s %-25s %-10d %-10d %-10d %-10d %-20s\n",
                    us.getID(), us.getTitel(), us.getAkzeptanzKriterien(), us.getMehrwert(), us.getStrafe(),
                    us.getRisiko(), us.getAufwand(), us.getProjekt());

        }
    }
}
