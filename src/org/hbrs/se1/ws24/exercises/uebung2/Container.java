package org.hbrs.se1.ws24.exercises.uebung2;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class Container {

    private static Container container;
    private List<Member> m = new LinkedList<>();
    private int size;

    private Container() {
        this.size = 0;
    }

    public static Container getContainer() {
        if (container == null) {
            container = new Container();
        }
        return container;
    }

    public void addMember(Member member) throws ContainerException {

        for (Member x : this.m) {
            if (x.getID() == member.getID()) {
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
            }
        }
        m.add(member);
        this.size++;
    }

    public int deleteMember(int id) {
        for (Member x : this.m) {
            if (x.getID() == id) {
                this.m.remove(x);
                this.size--;
                return 0;
            }
        }
        return -1;
    }

    public void dump() {
        for (Member x : m) {
            System.out.println(x);
        }
    }

    public int size() {
        return this.size;
    }

    public void store() throws PersistenceException, IOException {
        PersistenceStrategyStream<Member> store = new PersistenceStrategyStream<>();
        // Linux
        //store.setLocation("/home/flop/Dokumente/");
        // Windows
        store.setLocation("C:/Users/Filip/Downloads/");
        store.save(m);
    }

    public void load() throws PersistenceException, IOException, ClassNotFoundException {
        PersistenceStrategyStream<Member> load = new PersistenceStrategyStream<>();

        // Linux
        //load.setLocation("/home/flop/Dokumente/");
        // Windows
        load.setLocation("C:/Users/Filip/Downloads/");
        m = load.load();
    }

    // personal tests
    public static void main(String[] args) throws PersistenceException, IOException {

        Container c = new Container();

        speicherTest(c, 100);
        //ladeTest(c);

        c.dump();


    }

    // erstellt Members und speichert diese
    static void speicherTest(Container c, int anzahl) throws PersistenceException, IOException {

        for (int i = 0; i < anzahl; i++) {
            c.addMember(new ConcreteMember(i*2));
        }

        c.store();
    }

    static void ladeTest(Container c) throws PersistenceException, IOException, ClassNotFoundException {
        c.load();
    }

}
