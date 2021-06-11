import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean mainBoolean = true;
        do {
            int userChoice = ContactManager.printMenu();
            switch (userChoice) {
                case 1:
                    ContactManager.printList();
                    break;
                case 2:
                    ContactManager.addPerson();
                    break;
                case 3:
                    ContactManager.lastNameSearch();
                    break;
                case 4:
                    ContactManager.userDelete();
                    break;
                case 5:
                    ContactManager.userExit();
                    mainBoolean = false;
                    break;
                default:
                    System.out.println("Please enter a valid input...");
            }

//            if (userChoice == 1) {
//                ContactManager.printList();
//            } else if (userChoice == 2) {
//                ContactManager.addPerson();
//            } else if (userChoice == 3) {
//                ContactManager.lastNameSearch();
//            } else if (userChoice == 4) {
//                ContactManager.userDelete();
//            } else if (userChoice == 5) {
//                ContactManager.userExit();
//            } else {
//                System.out.println("Please enter a valid input...");
//            }

        } while (mainBoolean);

    }

  }



