package org.hbrs.se1.ws24.exercises.uebung4.commands;

public class US_help implements US_Command{

    private String parameter;

    public US_help(){
        this.parameter = "";
    }

    public US_help(String parameter){
        this.parameter = parameter;
    }

    @Override
    public void execute(){
        System.out.println(this.parameter);
        switch(parameter){
            case "load":
                System.out.println("'load' lädt eine gespeicherte Liste unter dem angegebenen Pfad");
                System.out.println("Syntax: load /pfad/zum/ordner/\n");
                break;
            case "store":
                System.out.println("'store' speichert die aktuelle Liste unter dem angegebenen Pfad");
                System.out.println("Syntax: load /pfad/zum/ordner/\n");
                break;
            case "dump":
                System.out.println("'dump' gibt alle User Stories unsortiert aus");
                System.out.println("\nParameter:");
                System.out.println("-s : nach Priorität sortierte Ausgabe");
                System.out.println("projekt Projektname : nach Projektnamen gefilterte Ausgabe");
                System.out.println("-s projekt Projektname : nach Projektnamen gefilterte und Priorität sortierte Ausgabe");
                System.out.println("\nBeispiel:");
                System.out.println("dump -s projekt Testprojekt");
                System.out.println("Gibt alle User Stories zum Projekt 'Testprojekt' nach Priorität sortiert aus.");
                break;
            default:
                System.out.println("enter - Eingabe einer User Story");
                System.out.println("store - Abspeichern");
                System.out.println("load - Laden einer liste ");
                System.out.println("dump - Ausgabe aller User Stories");
                System.out.println("exit - Programm beenden\n");
                System.out.println("Zeige spezifische Hilfe mit 'help command' an.\n");
        }



    }
}
