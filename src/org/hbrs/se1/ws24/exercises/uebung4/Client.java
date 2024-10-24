package org.hbrs.se1.ws24.exercises.uebung4;

import org.hbrs.se1.ws24.exercises.uebung4.commands.CommandExecuter;
import org.hbrs.se1.ws24.exercises.uebung4.commands.US_exit;
import org.hbrs.se1.ws24.exercises.uebung4.commands.US_help;
import org.hbrs.se1.ws24.exercises.uebung4.commands.US_Command;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CommandExecuter executer = new CommandExecuter(); // Invoker
        US_Command help = new US_help();
        US_Command exit = new US_exit();


        System.out.println("Enter Command:");
        while(true){

            String command = sc.next();

            switch (command){
                case "help":
                    executer.setCommand(help);
                    break;
                case "exit":
                    executer.setCommand(exit);
                    break;
                default:
                    executer.setCommand(null);
            }

            executer.execute();
        }
    }
}
