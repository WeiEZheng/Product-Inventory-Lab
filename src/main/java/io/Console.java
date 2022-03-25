package io;

import models.Sneaker;
import services.SneakerService;

import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.System.console;
import static java.lang.System.out;

public class Console {
    private final Scanner input;
    private final PrintStream output;

    public Console(){
        input = new Scanner(System.in);
        output = out;
    }

    public static void printWelcome(){
        out.println("" +
                "**************************************************\n" +
                "***           Welcome and Bienvenue            ***\n" +
                "***                    to                      ***\n" +
                "***          ZipCo Inventory Manager           ***\n" +
                "**************************************************");
    }

    public String getStringInput(String prompt, Object... args) {
        println(prompt, args);
        return input.nextLine();
    }

    public void print(String val, Object... args) {
        output.format("\u001B[34m" + val, args);
    }

    public void println(String val, Object... vals) {
        print(val + "\n", vals);
    }

    public int getIntegerInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            int intInput = Integer.parseInt(stringInput);
            return intInput;
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting an integer value!");
            return getIntegerInput(prompt, args);
        }
    }

    public void printCommands() {
        out.println("Available Commands: [HELP] [ADD] [READ] [UPDATE] [DElETE] [SWITCH]");
    }

    public void help() {
        println("[ADD] command allows you to add product to list");
        println("[READ] command gives you the entire list");
        println("[UPDATE] command allows you to update a product to list");
        println("[DELETE] command allows you to delete a product from list");
        println("[SWITCH] command allows you to switch between product lists");
    }

    public Double getDoubleInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Double doubleInput = Double.parseDouble(stringInput);
            return doubleInput;
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting a numeric value!");
            return getDoubleInput(prompt, args);
        }
    }
}
