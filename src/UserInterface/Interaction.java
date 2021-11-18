package UserInterface;

import java.util.Scanner;

public class Interaction {
    public String getUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int getUserInputInt() {
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    public int getUserInputForMenu() {
        Scanner sc = new Scanner(System.in);
        int returnValue = Integer.parseInt(sc.nextLine());
        while (returnValue > 4 || returnValue < 1) {
            System.out.println("Invalid choice, please try again");
            returnValue = Integer.parseInt(sc.nextLine());
        }
        return returnValue;
    }
}
