import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactManager {

    public static List<Contacts1> contactList = new ArrayList<>();

    // Start menu
    public static int printMenu() {
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit Application.\n" +
                "Please Enter an option (1, 2, 3, 4 or 5): ");
        Scanner myScanner = new Scanner(System.in);
        String userChoice = myScanner.nextLine();

        try {
            int userInputInt = Integer.parseInt(userChoice);
            return userInputInt;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " is not an option. Please pick a valid option.");
        }
        return 0;
    }
    //Add person to contact list
    public static void addPerson() throws IOException {
        Scanner Scanner = new Scanner(System.in);
        System.out.println(" 2. Add a New Person ");
        System.out.print("  First Name: ");
        String firstName = Scanner.nextLine();
        System.out.print("  Last Name : ");
        String lastName = Scanner.nextLine();
        System.out.print("  Phone Number : ");
        String phoneNumber = Scanner.nextLine();
        Files.write(
                Paths.get("ContactManagerApp/src/ContactList", "contacts.txt"),
                Arrays.asList(firstName + " " + lastName + " | " + phoneNumber),
                StandardOpenOption.APPEND
        );
        contactList.add(new Contacts1(firstName, lastName, phoneNumber));
        System.out.println(firstName + " " + lastName + " has been successfully added to the contact list ");
    }
    //Prints contact.txt file
    public static void printList() {
        System.out.println("Name | Phone number ");
        System.out.println("-----------------------------");
        Path ContactsPath = Paths.get("ContactManagerApp/src/ContactList", "contacts.txt");
        List<String> contactList = null;
        try {
            contactList = Files.readAllLines(ContactsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < Objects.requireNonNull(contactList).size(); i += 1) {
            System.out.println((i + 1) + ": " + contactList.get(i));
        }
        System.out.println("-----------------------------");
    }

    //Last name search
    public static void NameSearch() {
        System.out.println("3. Retrieve contacts by name and/or phone number. ");
        System.out.print(" Name or Number: ");
        Scanner myScanner = new Scanner(System.in);
        String userInputSearch = myScanner.nextLine();
        Path ContactsPath = Paths.get("ContactManagerApp/src/ContactList", "contacts.txt");
        List<String> contactList;
        try {
            contactList = Files.readAllLines(ContactsPath);
            for (String person : contactList) {
                if (person.toLowerCase().contains(userInputSearch.toLowerCase())) {
                    System.out.println("Contact:\n" + person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Delete contact
    public static void userDelete() {
        System.out.println("4. Delete an existing contact.");
        System.out.println("What contact would you like to delete?");
        Scanner scanner = new Scanner(System.in);
        String userInputDelete = scanner.nextLine();

        List<String> newContacts = new ArrayList<>();
        Path ContactsPath = Paths.get("ContactManagerApp/src/ContactList", "contacts.txt");
        try {
            newContacts = Files.readAllLines(ContactsPath);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Iterator<String> listIterator = newContacts.iterator();
        while (listIterator.hasNext()) {
            String contact = listIterator.next();
            if (contact.toLowerCase().contains(userInputDelete.toLowerCase())) {
                listIterator.remove();
                System.out.println("Contact " + userInputDelete + " has been deleted.");
            }
            try {
                Files.write(ContactsPath, newContacts);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    //Exit
    public static void userExit() {
        System.out.println("5. Exit Application");
        System.out.println("Thank you for using our system today!");
        System.exit(0);
    }
}
