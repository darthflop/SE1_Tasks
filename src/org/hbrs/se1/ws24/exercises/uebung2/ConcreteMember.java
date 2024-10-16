package org.hbrs.se1.ws24.exercises.uebung2;

import java.io.Serializable;

public class ConcreteMember implements Member, Serializable {

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
