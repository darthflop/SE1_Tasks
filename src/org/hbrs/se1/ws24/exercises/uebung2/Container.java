package org.hbrs.se1.ws24.exercises.uebung2;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategy;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class Container {

    private static Container container;
    private List<Member> m = new LinkedList<>();
    private int size;
    private PersistenceStrategy<Member> persistenceStrategy;

    private Container() {
        this.size = 0;
    }

    public static Container getContainer() {
        if (container == null) {
            synchronized (Container.class){
                if (container == null){
                    container = new Container();
                }
            }
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

    public int size() {
        return this.size;
    }

    public void store() throws PersistenceException, IOException {
        if (persistenceStrategy == null) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,
                    "Keine Persistenzstrategie gesetzt!");
        }
        persistenceStrategy.save(m);
    }

    public void load() throws PersistenceException, IOException, ClassNotFoundException {
        if (persistenceStrategy == null) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,
                    "Keine Persistenzstrategie gesetzt!");
        }
        m = persistenceStrategy.load();
        this.size = m.size();
    }

    public void setPersistenceStrategy(PersistenceStrategy<Member> persistenceStrategy){
        this.persistenceStrategy = persistenceStrategy;
    }

    public List<Member> getCurrentList(){
        return this.m;
    }

}