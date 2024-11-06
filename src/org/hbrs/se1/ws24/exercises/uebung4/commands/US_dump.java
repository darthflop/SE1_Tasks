package org.hbrs.se1.ws24.exercises.uebung4.commands;

import org.hbrs.se1.ws24.exercises.uebung4.Container;
import org.hbrs.se1.ws24.exercises.uebung4.UserStories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class US_dump implements US_Command {

    Container c;
    int argument;
    String filter;

    public US_dump(Container c, int argument){
        this.c = c;
        this.argument = argument;
    }

    public US_dump(Container c, int argument, String filter){
        this.c = c;
        this.argument = argument;
        this.filter = filter;
    }

    @Override
    public void execute() {

        if(argument == 0){
            dumpNormal();
        }else if(argument == 1){
            dumpSorted();
        }else if(argument == 2){
            dumpFiltered();
        }else if(argument == 3){
            dumpFilteredSorted();
        }
    }

    private void dumpFilteredSorted(){
        List<UserStories> out = new ArrayList<>(List.copyOf(c.getCurrentList()));
        List<UserStories> filtered = out.stream()
                .filter(element -> element.getProjekt().equals(filter))
                .collect(Collectors.toList());

        filtered.sort(Comparator.comparingDouble(UserStories::getPrio).reversed());

        ausgabe(filtered);
    }

    private void dumpFiltered(){

        List<UserStories> out = new ArrayList<>(List.copyOf(c.getCurrentList()));
        List<UserStories> filtered = out.stream()
                    .filter(element -> element.getProjekt().equals(filter))
                    .collect(Collectors.toList());
        ausgabe(filtered);
    }

    private void dumpNormal(){
        ausgabe(c.getCurrentList());
    }

    private void dumpSorted(){

        // Sortieren nach Priorität
        List<UserStories> out = new ArrayList<>(List.copyOf(c.getCurrentList()));
        Collections.sort(out, Comparator.comparingDouble(UserStories::getPrio).reversed());

        ausgabe(out);
    }

    private void ausgabe(List<UserStories> out){

        // Kopfzeile der Tabelle
        System.out.printf("%-15s %-20s %-25s %-10s %-10s %-10s %-10s %-20s %-10s\n",
                "ID", "Titel", "Akzeptanzkriterium", "Mehrwert", "Strafe", "Risiko", "Aufwand", "Projekt", "Priorität");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");


        // Inhalte der User Stories in tabellarischer Form ausgeben
        for (UserStories us : out) {
            System.out.printf("%-15s %-20s %-25s %-10d %-10d %-10d %-10d %-20s %-2.3f\n",
                    us.getID(), us.getTitel(), us.getAkzeptanzKriterien(), us.getMehrwert(), us.getStrafe(),
                    us.getRisiko(), us.getAufwand(), us.getProjekt(), us.getPrio());

        }
    }
}
