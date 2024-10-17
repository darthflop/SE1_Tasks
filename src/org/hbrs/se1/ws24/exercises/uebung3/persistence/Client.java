package org.hbrs.se1.ws24.exercises.uebung3.persistence;

import org.hbrs.se1.ws24.exercises.uebung2.ConcreteMember;
import org.hbrs.se1.ws24.exercises.uebung2.Container;

public class Client {

    public static void main(String[] args) {

        Container c = initContainer();
        MemberView view = new MemberView();
        view.dump(c.getCurrentList());

    }

    public static Container initContainer(){
        Container c = Container.getContainer();
        for (int i = 0; i < 100; i++) {
            c.addMember(new ConcreteMember(i));
        }
        return c;
    }
}
