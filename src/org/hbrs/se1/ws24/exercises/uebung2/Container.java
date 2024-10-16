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

    private Container(){
        this.size = 0;
    }

    public static Container getContainer(){
        if(container == null){
            container = new Container();
        }
        return container;
    }

    public void addMember(Member member) throws ContainerException {

        for(Member x:this.m){
            if(x.getID() == member.getID()){
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
            }
        }
        m.add(member);
        this.size++;
    }

    public int deleteMember(int id){
        for(Member x:this.m){
            if(x.getID() == id){
                this.m.remove(x);
                this.size--;
                return 0;
            }
        }
        return -1;
    }

    public void dump(){
        for(Member x:m){
            System.out.println(x);
        }
    }

    public int size(){
        return this.size;
    }

    public void store() throws PersistenceException, IOException {
        PersistenceStrategyStream<Member> store = new PersistenceStrategyStream<>();
        store.setLocation("/home/flop/Dokumente/");
        store.save(m);
    }

    public void load() throws PersistenceException, IOException, ClassNotFoundException {
        PersistenceStrategyStream<Member> load = new PersistenceStrategyStream<>();
        load.setLocation("/home/flop/Dokumente/");
        m = load.load();
    }


    public static void main(String[] args) throws PersistenceException, IOException, ClassNotFoundException {
        /*Container eins = getContainer();
        eins.addMember(new ConcreteMember(1));
        eins.addMember(new ConcreteMember(7));


        eins.dump();
        eins.store();
*/
        Container zwei = getContainer();

        zwei.load();
        zwei.dump();

    }
}
