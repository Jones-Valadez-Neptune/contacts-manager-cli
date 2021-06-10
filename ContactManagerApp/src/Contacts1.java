import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Contacts1 {
    String firstName;
    String lastName;
    String phoneNumber;

    public Contacts1(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // setters and getters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Start menu
    public static void printMenu(){
        System.out.println("1. View contacts.\n" +
                "2. add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5): ");
    }

    public void addContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the first name of the contact...");
        this.firstName = scanner.nextLine();
        System.out.println("Please enter the last name of the contact...");
        this.lastName = scanner.nextLine();
        System.out.println("Please enter the phone number...");
        this.phoneNumber = scanner.nextLine();

        List<String> contactsList =  Arrays.asList(firstName + lastName + phoneNumber);



    }
}
