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
            System.out.print("> ");
            String input = sc.nextLine();
            String[] command = input.split(" ");

            switch (command[0]){
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
                    if(command.length == 1){
                        executer.setCommand(new US_dump(c, 0));
                    } else if(command[1].equals("-s") && command.length == 2){
                        executer.setCommand(new US_dump(c, 1));
                    } else if(command[1].equals("projekt") && command.length == 3){
                        executer.setCommand(new US_dump(c, 2, command[2]));
                    } else if(command[1].equals("-s") && command[2].equals("projekt")){
                        executer.setCommand(new US_dump(c, 3, command[3]));
                    }
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
