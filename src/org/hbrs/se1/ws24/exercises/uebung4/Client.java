package org.hbrs.se1.ws24.exercises.uebung4;

import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;
import org.hbrs.se1.ws24.exercises.uebung4.commands.*;

import java.io.IOException;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) throws PersistenceException, IOException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);

        // Speicher Stragegie setzen
        PersistenceStrategyStream<UserStories> strategy = new PersistenceStrategyStream<>();
        Container c = Container.getContainer();
        c.setPersistenceStrategy(strategy);

        CommandExecuter executer = new CommandExecuter(); // Invoker

        while(true){
            System.out.print(">");
            String command = sc.nextLine();

            switch (command){
                case "help":
                    executer.setCommand(new US_help());
                    break;
                case "exit":
                    executer.setCommand(new US_exit());
                    break;
                case "enter":
                    executer.setCommand(new US_enter(sc, c));
                    break;
                case "dump":
                    executer.setCommand(new US_dump(c, false));
                    break;
                case "dump -s":
                    executer.setCommand(new US_dump(c, true));
                    break;
                case "store":
                    executer.setCommand(new US_store(strategy, c, sc));
                    break;
                case "load":
                    executer.setCommand(new US_load(strategy, c, sc));
                    break;
                default:
                    executer.setCommand(null);
            }
            executer.execute();
        }
    }
}
