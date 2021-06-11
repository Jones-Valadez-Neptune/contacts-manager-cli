import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        Path toOurDataPlace = Paths.get("ContactManagerApp/src/ContactList");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");
        //Create Directory
        try {
            if (Files.notExists(toOurDataPlace)) {
                Files.createDirectories(toOurDataPlace);
            } else {
                System.out.println("The " + toOurDataPlace + " directory already exists.");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        //Create File
        try {
            if (Files.notExists(toOurDataFile)) {
                Files.createFile(toOurDataFile);
            } else {
                System.out.println("The " + toOurDataFile + " file already exists.");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

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
                    ContactManager.NameSearch();
                    break;
                case 4:
                    ContactManager.userDelete();
                    break;
                case 5:
                    ContactManager.userExit();
                    mainBoolean = false;
                    break;
            }
        } while (mainBoolean);
    }
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



