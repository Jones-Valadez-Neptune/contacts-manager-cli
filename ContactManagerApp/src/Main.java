public class Main {
    public static void main(String[] args) {
        int userChoice = ContactManager.printMenu();
        if (userChoice == 1)
            ContactManager.printList();
    }
}
