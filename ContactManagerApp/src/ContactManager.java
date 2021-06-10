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
                "2. add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5): ");
        Scanner myScanner = new Scanner(System.in);
        int userChoice = myScanner.nextInt();
        return userChoice;
    }

    public static void addPerson() throws IOException {
        Scanner myScanner = new Scanner(System.in);
        System.out.println(" 1. Add a New Person ");
        System.out.print("  First Name: ");
        String firstName = myScanner.nextLine();
        System.out.print("  Last Name : ");
        String lastName = myScanner.nextLine();
        System.out.print("  Phone Number : ");
        String phoneNumber = myScanner.nextLine();
        Files.write(
                Paths.get("ContactManagerApp/src/ContactList", "contacts.txt"),
                Arrays.asList(firstName + " " + lastName + " | " + phoneNumber),
                StandardOpenOption.APPEND
        );
        contactList.add(new Contacts1(firstName, lastName, phoneNumber));
        System.out.println(firstName + " " + lastName + " has been successfully added to the contact list ");
    }

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
    }
}
