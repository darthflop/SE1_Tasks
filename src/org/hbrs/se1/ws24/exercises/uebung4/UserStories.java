package org.hbrs.se1.ws24.exercises.uebung4;

import java.io.Serializable;

public class UserStories implements Serializable {

    static int idCount = 0;
    int id;
    String titel;
    String akzeptanzKriterien;

    // Parameter nach Gloger,2013
    int mehrwert;
    int strafe;
    int risiko;
    int aufwand;
    double prio; //berechnete Priorisierung

    String projekt;

    private UserStories(){

    }

    public UserStories(String titel, String akzeptanzKriterien, int mehrwert, int strafe, int risiko, int aufwand, String projekt, double prio){

        this.id = idCount;
        idCount++;
        this.titel = titel;
        this.akzeptanzKriterien = akzeptanzKriterien;
        this.mehrwert = mehrwert;
        this.strafe = strafe;
        this.risiko = risiko;
        this.aufwand = aufwand;
        this.projekt = projekt;
        this.prio = prio;
    }

    public int getID(){
        return this.id;
    }

    public String getTitel(){
        return this.titel;
    }

    public String getAkzeptanzKriterien(){
        return this.akzeptanzKriterien;
    }

    public int getMehrwert() {
        return this.mehrwert;
    }

    public int getStrafe() {
        return this.strafe;
    }

    public int getRisiko() {
        return this.risiko;
    }

    public int getAufwand() {
        return this.aufwand;
    }

    public String getProjekt() {
        return this.projekt;
    }

    public double getPrio(){
        return this.prio;
    }

    public static double calcPrio(int mehrwert, int strafe, int risiko, int aufwand){
        return (double) (mehrwert + strafe) / (aufwand + risiko);
    }

    public void setID(int id){
        this.id=id;
    }

    public static void setIdCount(int id){
        idCount = id;
    }

}
