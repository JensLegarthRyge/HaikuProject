package UserInterface;

import AnalysisEngine.*;
import Data.*;

import java.io.*;
import java.util.*;

public class Menu {
    Interaction in = new Interaction();

    public void printUserGreeting() {
        System.out.println("##########################################################################");
        System.out.println("####################### Welcome to the Haiku diary! ######################");
        System.out.println("##########################################################################");
        System.out.println("\t Please write your name below - Feel free to use your pseudonym!");
    }
    private void printUserMenuOptions() {
        System.out.println("\nTo create a new poem - Press 1");
        System.out.println("To view your existing poems - Press 2");
        System.out.println("To exit the diary - Press 3");
    }
    private void printPoemIds(ArrayList<String> poemIds) {
        for (int i = 0; i < poemIds.size(); i++) {
            System.out.println((i+1)+". "+poemIds.get(i));
        }
    }
    private void printPoemByNumber(int poemNumber, ArrayList<String> poemIds){
        File poemFile = new File("Haiku Poem.csv");
        int iterationCounter=0;
        poemNumber=poemNumber-1;
        try {
            Scanner sc = new Scanner(poemFile);
            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                if (currentLine.contains(poemIds.get(poemNumber))) {
                    System.out.println(currentLine);
                    while (iterationCounter<6){
                        System.out.println(sc.nextLine());
                        iterationCounter++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

    private String[] getHaikuPoemInput() {
        String[] haikuPoemBody = new String[3];
        for (int i = 0; i < haikuPoemBody.length; i++) {
            haikuPoemBody[i] = in.getUserInput();
        } return haikuPoemBody;
    }
    private ArrayList<String> getPoemIds() {
        File poemFile = new File("Haiku Poem.csv");
        ArrayList<String> poemIds = new ArrayList<>();
        try {
            Scanner sc = new Scanner(poemFile);
            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                if (currentLine.contains("ID")) {
                    poemIds.add(currentLine);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return poemIds;
    }

    public void userMenu(String userName){
        HaikuAnalyzer haikuAnalyzer = new HaikuAnalyzer();
        FileHandler fileHandler = new FileHandler();
        int userChoice = 0;
        while (userChoice!=3){
            printUserMenuOptions();
            userChoice=in.getUserInputForMenu();
            switch (userChoice) {
                case 1 -> {
                    System.out.println("\nWrite away young author!");
                    String[] haikuPoemBody = getHaikuPoemInput();
                    HaikuPoem currentPoem = new HaikuPoem(userName, haikuPoemBody);
                    if (haikuAnalyzer.isHaikuPoem(currentPoem)) {
                        System.out.println("\nYour poem was saved with identification number: " + currentPoem.getId());
                        fileHandler.write(currentPoem);
                    } else {
                        System.out.println("\nI am a afraid your poem doesn't quite follow the rules of a Haiku-poem");
                        System.out.println("A Haiku poem should have the follow syllable pattern: 5-7-5");
                        System.out.print("Yours had: ");
                        for (int i = 0; i < haikuPoemBody.length; i++) {
                            System.out.print(haikuAnalyzer.getSyllableCountFromSentence(haikuPoemBody[i]));
                            if (i!=haikuPoemBody.length-1){
                                System.out.print("-");
                            }
                        }
                        System.out.println();
                    }
                }
                case 2 -> {
                    ArrayList<String> poemIds = getPoemIds();
                    System.out.println("\nPlease select which poem you would like to print from the ID-list below:");
                    printPoemIds(poemIds);
                    int poemPick = in.getUserInputInt();

                    printPoemByNumber(poemPick, poemIds);
                }
            }
        }

    }






}