import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
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
                //Delete existing user
                //break;
            case 5:
                //Exit
                //break;
        }


        //        if (userChoice == 1)
//            ContactManager.printList();
//        else if (userChoice == 2)
//            ContactManager.addPerson();
//        else if (userChoice == 3)
//            ContactManager.lastNameSearch();
//    }

    }
}

