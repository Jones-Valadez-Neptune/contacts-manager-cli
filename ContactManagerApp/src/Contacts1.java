import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Contacts1 {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contacts1(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return this.firstName + " " + this.lastName + "Phone number: " + this.phoneNumber;
    }

    }
