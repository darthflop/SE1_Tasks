package org.hbrs.se1.ws24.exercises.uebung2;

public class ConcreteMember implements Member{

    private int id;

    public ConcreteMember(int id){
        this.id = id;
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    @Override
    public String toString(){
        return "Member (ID = " + this.id + ")";
    }
}
