package org.hbrs.se1.ws24.exercises.uebung3.persistence;

import org.hbrs.se1.ws24.exercises.uebung2.Member;
import java.util.List;

public class MemberView {

    public void dump(List<Member> liste) {
        for (Member x : liste) {
            System.out.println(x);
        }
    }

}
