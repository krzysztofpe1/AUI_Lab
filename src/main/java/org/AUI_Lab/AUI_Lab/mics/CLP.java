package org.AUI_Lab.AUI_Lab.mics;

//Command Line Printer
public class CLP {
    public static void error(String message){System.out.println("Error: "+message+" Enter \"help\" to get list of available commands.");}
    public static void errorTooFewParameters(){System.out.println("Error: To few parameters. Enter \"help\" to get list of available commands.");}
    public static void errorCommandDoesntExist(String command){System.out.println("Error: Command \""+command+"\" doesn't exist. Enter \"help\" to get list of available commands.");}
    public static void warningTooManyParameters(String command){System.out.println("Warning: \""+command+"\" doesn't accept any additional parameters."); System.out.println();}
    public static void warning(String message){System.out.println("Warning: "+message);System.out.println();}
}
