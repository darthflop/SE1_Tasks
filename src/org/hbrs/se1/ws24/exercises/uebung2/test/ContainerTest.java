package org.hbrs.se1.ws24.exercises.uebung2.test;
import static org.junit.jupiter.api.Assertions.*;

import org.hbrs.se1.ws24.exercises.uebung2.ConcreteMember;
import org.hbrs.se1.ws24.exercises.uebung2.Container;
import org.hbrs.se1.ws24.exercises.uebung2.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContainerTest {

    Member one = new ConcreteMember(1);
    Member two = new ConcreteMember(2);
    Container test = new Container();

    @Test
    public void testSizes(){

        assertEquals(0, test.size());
        test.addMember(one);
        assertEquals(1, test.size());
        test.addMember(two);
        assertEquals(2, test.size());
        assertEquals(0,test.deleteMember(2));
        assertEquals(1, test.size());
    }

    @Test
    public void testIDs(){

    }

}
