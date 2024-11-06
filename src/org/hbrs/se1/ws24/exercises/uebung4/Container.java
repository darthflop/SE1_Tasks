package org.hbrs.se1.ws24.exercises.uebung4;

import org.hbrs.se1.ws24.exercises.uebung2.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategy;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Container {

    private static Container container;
    private List<UserStories> list = new LinkedList<>();
    private int size;
    private PersistenceStrategy<UserStories> persistenceStrategy;

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

    public void addUserStory(UserStories story) throws ContainerException {
        story.setID(this.list.size());
        list.add(story);
        this.size++;
    }

    public int deleteUserStory(int id) {
        for (UserStories x : this.list) {
            if (x.getID() == id) {
                this.list.remove(x);
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
        persistenceStrategy.save(list);
    }

    public void load() throws PersistenceException, IOException, ClassNotFoundException {
        if (persistenceStrategy == null) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,
                    "Keine Persistenzstrategie gesetzt!");
        }
        this.list = persistenceStrategy.load();
        this.size = list.size();
    }

    public void setPersistenceStrategy(PersistenceStrategy<UserStories> persistenceStrategy){
        this.persistenceStrategy = persistenceStrategy;
    }

    public List<UserStories> getCurrentList(){
        return this.list;
    }

    public int getMaxID(){
        int max = 0;

        for(UserStories x : this.list){
            if(x.getID() > max){
                max = x.getID();
            }
        }
        return max;
    }


}
