import UserInterface.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Interaction in = new Interaction();

        menu.printUserGreeting();
        String usersName = in.getUserInput();
        menu.userMenu(usersName);
    }
}
