package org.hbrs.se1.ws24.exercises.uebung2.test;
import static org.junit.jupiter.api.Assertions.*;

import org.hbrs.se1.ws24.exercises.uebung2.ConcreteMember;
import org.hbrs.se1.ws24.exercises.uebung2.Container;
import org.hbrs.se1.ws24.exercises.uebung2.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung2.Member;
import org.junit.jupiter.api.Test;

public class ContainerTest {

    Member one = new ConcreteMember(1);
    Member two = new ConcreteMember(2);


    @Test
    public void testSizes(){

        Container test1 = new Container();

        assertEquals(0, test1.size());
        test1.addMember(one);
        assertEquals(1, test1.size());
        test1.addMember(two);
        assertEquals(2, test1.size());
        assertEquals(0,test1.deleteMember(2));
        assertEquals(1, test1.size());
        assertEquals(0,test1.deleteMember(1));
        assertEquals(0, test1.size());
    }

    @Test
    public void testAddDelete(){

        Container test2 = new Container();

        test2.addMember(one);
        assertThrows(ContainerException.class, () -> test2.addMember(one));
        assertDoesNotThrow(() -> test2.addMember(two));
        assertThrows(ContainerException.class, () -> test2.addMember(two));

        test2.deleteMember(1);
        assertDoesNotThrow(() -> test2.addMember(one));

        // deletes
        assertEquals(-1, test2.deleteMember(3));
        assertEquals(-1, test2.deleteMember(-3));

    }

}
