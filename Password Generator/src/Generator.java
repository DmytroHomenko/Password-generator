import java.util.Objects;
import java.util.Scanner;

public class Generator {
    // generating password and making answers
    Alphabet alphabet;
    public static Scanner keyboard;

    public Generator(Scanner scanner) {
        keyboard = scanner;
    }

    public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeUpperUkr, boolean IncludeLowerUkr, boolean IncludeNum, boolean IncludeSym) {
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeUpperUkr, IncludeLowerUkr, IncludeNum, IncludeSym);
    }
    // "Menu-bar"
    public void mainLoop() {
        System.out.println("Welcome to generator of reliable passwords :)");
        printMenu();

        String userOption = "-1";

        while (!userOption.equals("4")) {

            userOption = keyboard.next();

            switch (userOption) {
                case "1" -> {
                    requestPassword();
                    printMenu();
                }
                case "2" -> {
                    checkPassword();
                    printMenu();
                }
                case "3" -> {
                    printUsefulInfo();
                    printMenu();
                }
                case "4" -> printQuitMessage();
                default -> {
                    System.out.println();
                    System.out.println("Type option that u want to choose (Num from 1 to 4)");
                    printMenu();
                }
            }
        }
    }

    // settings of creating
    private Password GeneratePassword(int length) {
        final StringBuilder pass = new StringBuilder("");

        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());
    }
    // useful info
    private void printUsefulInfo() {
        System.out.println();
        System.out.println("Use at least 8 symbols if that`s possible");
        System.out.println("include upper and lowercase, nums, and symbols");
        System.out.println("Create unique passwords!");
        System.out.println("Never use same password twice! (except cases when u use same account with another users)");
        System.out.println("use little-known information," +
                "\nNickname, pet's name, fav book's name " +
                "abd biography (example: ID num's, close people names, or little-known dates).");
        System.out.println("never use known information");
        System.out.println("never use simple passwords, repeated nums, letters, or short password, make'em (passwords) trickier!");
    }

    private void requestPassword() {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeUpperUkr = false;
        boolean IncludeLowerUkr = false;
        boolean IncludeNum = false;
        boolean IncludeSym = false;
        boolean correctParams;

    // Questions & answers
        System.out.println();
        System.out.println("Wellcome to password generator!"
                + " answer yes/no \n");

        do {
            String input;
            correctParams = false;

            do {
                System.out.println("do u want to use English \"abcd...\" lowercase letters? ");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes" ) && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeLower = true;

            do {
                System.out.println("do u want to use English \"ABCD...\" uppercase letters? ");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes" ) && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeLowerUkr = true;

            do {
                System.out.println("du u want to use Ukrainian \"абвг...\" lowercase letters? \n" +
                        "WARNING! THIS FUNCTION IS IN THE TEST MODE! \n" +
                        "NOT EVERYONE SERVICES PICKING UP UKR LETTERS!");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeUpperUkr = true;

            do {
                System.out.println("du u want to use Ukrainian \"АБВГ...\" uppercase letters? \n" +
                        "WARNING! THIS FUNCTION IS IN THE TEST MODE! \n" +
                        "NOT EVERYONE SERVICES PICKING UP UKR LETTERS!");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            if (isInclude(input)) IncludeUpper = true;

            do {
            System.out.println("do u want to use \"1234...\" nums? ");
            input = keyboard.next();
            PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeNum = true;

            do {
            System.out.println("do u want to use \"!@#$...\" special symbols? ");
            input = keyboard.next();
            PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeSym = true;

            //No Pool Selected
            if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
                System.out.println("U did't answer any questions! " +
                        "give answer 'yes' at least on 1 question\n");
                correctParams = true;
            }

        } while (correctParams);

        System.out.println("Excellent! Now chose length of u'r password ");
        int length = keyboard.nextInt();
    // completed "product"
        final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeUpperUkr,IncludeLowerUkr, IncludeNum, IncludeSym);
        final Password password = generator.GeneratePassword(length);

        System.err.println("So, u'r password is -> " + password);
    }

    private boolean isInclude(String Input) {
        if (Input.equalsIgnoreCase("yes")) {
            return true;
        } 
        else {
            return false;
        }
    }
    // if there is an incorrect answer
    private void PasswordRequestError(String i) {
        if (!i.equalsIgnoreCase("yes") && !i.equalsIgnoreCase("no")) {
            System.out.println("U have entered something incorrect... \n" +
               "Let's try again!");
        }
    }
    // checking of the password
    private void checkPassword() {
        String input;

        System.out.print("\nEnter u'r password:");
        input = keyboard.next();

        final Password p = new Password(input);

        System.out.println(p.calculateScore());
    }
    // getting back to menu

    private void printMenu() {
        System.out.println();
        System.out.println("Введіть 1 - Password generator");
        System.out.println("Введіть 2 - check own password");
        System.out.println("Введіть  3 - Useful information about creating password");
        System.out.println("Введіть 4 - Exit");
        System.out.print("Choice:");
    }
    // Shutting the program
    private void printQuitMessage() {
        System.out.println("Closing app, see u soon!");
    }
}
