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
        US_Command help = new US_help();
        US_Command exit = new US_exit();
        US_Command enter = new US_enter(sc, c);
        US_Command dump = new US_dump(c);
        US_Command store = new US_store(strategy, c, sc);
        US_Command load = new US_load(strategy, c, sc);


        while(true){
            System.out.print(">");
            String command = sc.next();

            switch (command){
                case "help":
                    executer.setCommand(help);
                    break;
                case "exit":
                    executer.setCommand(exit);
                    break;
                case "enter":
                    executer.setCommand(enter);
                    break;
                case "dump":
                    executer.setCommand(dump);
                    break;
                case "store":
                    executer.setCommand(store);
                    break;
                case "load":
                    executer.setCommand(load);
                    break;
                default:
                    executer.setCommand(null);
            }
            executer.execute();
        }
    }
}
