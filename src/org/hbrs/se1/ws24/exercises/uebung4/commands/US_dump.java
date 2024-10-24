package org.hbrs.se1.ws24.exercises.uebung4.commands;

import org.hbrs.se1.ws24.exercises.uebung4.Container;
import org.hbrs.se1.ws24.exercises.uebung4.UserStories;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class US_dump implements US_Command {

    Container c;

    public US_dump(Container c){
        this.c = c;
    }

    @Override
    public void execute() {

        // Kopfzeile der Tabelle
        System.out.printf("%-15s %-20s %-25s %-10s %-10s %-10s %-10s %-20s %-10s\n",
                "ID", "Titel", "Akzeptanzkriterium", "Mehrwert", "Strafe", "Risiko", "Aufwand", "Projekt", "Priorität");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

        List<UserStories> sorted = c.getCurrentList();

        // Sortieren nach Priorität
        Collections.sort(sorted, Comparator.comparingDouble(UserStories::getPrio).reversed());

        // Inhalte der User Stories in tabellarischer Form ausgeben
        for (UserStories us : sorted) {
            System.out.printf("%-15s %-20s %-25s %-10d %-10d %-10d %-10d %-20s %-2.3f\n",
                    us.getID(), us.getTitel(), us.getAkzeptanzKriterien(), us.getMehrwert(), us.getStrafe(),
                    us.getRisiko(), us.getAufwand(), us.getProjekt(), us.getPrio());

        }
    }
}
