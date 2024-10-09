package org.hbrs.se1.ws24.exercises.uebung2;
import java.util.ArrayList;
import java.util.Objects;

public class Container {

    private ArrayList<Member> m = new ArrayList<>();
    private int size;

    public Container(){
        this.size = 0;
    }

    public void addMember(Member member) throws ContainerException{

        for(Member x:this.m){
            if(Objects.equals(x.getID(), member.getID())){
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
            }else{
                return -1;
            }
        }
        return 0;
    }

    public void dump(){
        for(Member x:m){
            System.out.println(x);
        }
    }

    public int size(){
        return this.size;
    }

    public static void main(String[] args) {
        Container c = new Container();
        for (int i = 0; i < 100; i++) {
            c.addMember(new ConcreteMember(i));
        }
        c.dump();
        System.out.println(c.size());

    }

}
