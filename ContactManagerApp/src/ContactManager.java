import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactManager extends Contacts1 {
    public ContactManager(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Path path = Paths.get("src", "Contacts1.java");
        System.out.println(path.toAbsolutePath());
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

        //Write data to a file
//        List<String> codeupContactList = Arrays.asList("David", "Jay", "Javier", "Jason");
//
//        try {
//            2 arguments for Files.write
//            The path to our file, the data we want to write
//            Files.write(toOurDataFile, codeupContactList);
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }

        //Method from Contacts1
        System.out.println("Welcome to the contacts manager. What would you like to do?/n");
        printMenu();
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                // view contacts
                //Create a place to put information we read from the file
                List<String> currentContactsList = new ArrayList<>();

                //Read the information from the file
                try {
                    currentContactsList = Files.readAllLines(toOurDataFile);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

                for (String line : currentContactsList) {
                    System.out.println(line);
                }
            case 2:
                // add new contact

                //Append a single item to our list
                try {
                    Files.writeString(toOurDataFile, "Karen\n", StandardOpenOption.APPEND);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            case 3:
                // search contact by name
            case 4:
                // delete an existing contact
            case 5:
                // exit
        }
    }

}
