import java.util.Scanner;

public class CypherTool {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] OPERATIONS = {"Encrypt", "Decrypt"};
    private static final String[] CYPHERS = {"ROT13", "Atbash", "Caesar"};

    public static void main(String[] args) {
        System.out.println("Welcome to the Cypher Tool!");
        System.out.println();

        while (true) {
            try {
                InputData data = getInput();
                String result = processData(data);
                
                String operationName = data.operation == 1 ? "Encrypted" : "Decrypted";
                String cypherName = getCypherName(data.cipher);
                System.out.println();
                System.out.println(operationName + " message (" + cypherName + "):");
                System.out.println(result);
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println();
            }
        }
    }

    public static InputData getInput() {
        int operation = getOperationChoice();
        int cipher = getCipherChoice();
        String message = getMessage();
        
        int shift = 0;
        if (cipher == 3) { // Caesar cipher
            shift = getCaesarShift();
        }
        
        return new InputData(operation, cipher, message, shift);
    }

    private static int getOperationChoice() {
        while (true) {
            System.out.println("Select operation:");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.print("$> ");
            
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 2) {
                    return choice;
                } else {
                    System.out.println("Error: Please enter 1 or 2");
                    System.out.println();
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number");
                System.out.println();
            }
        }
    }

    private static int getCipherChoice() {
        while (true) {
            System.out.println("Select cypher:");
            System.out.println("1. ROT13");
            System.out.println("2. Atbash");
            System.out.println("3. Caesar");
            System.out.print("$> ");
            
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Error: Please enter 1, 2, or 3");
                    System.out.println();
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number");
                System.out.println();
            }
        }
    }

    private static int getCaesarShift() {
        while (true) {
            System.out.println("Enter Caesar shift (1-25):");
            System.out.print("$> ");
            
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            
            try {
                int shift = Integer.parseInt(input);
                if (shift >= 1 && shift <= 25) {
                    return shift;
                } else {
                    System.out.println("Error: Shift must be between 1 and 25");
                    System.out.println();
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number");
                System.out.println();
            }
        }
    }

    private static String getMessage() {
        while (true) {
            System.out.println("Enter the message:");
            System.out.print("$> ");
            
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Error: Message cannot be empty");
                System.out.println();
            }
        }
    }

    private static String processData(InputData data) {
        if (data.operation == 1) { // Encrypt
            switch (data.cipher) {
                case 1:
                    return encryptRot13(data.message);
                case 2:
                    return encryptAtbash(data.message);
                case 3:
                    return encryptCaesar(data.message, data.shift);
                default:
                    throw new IllegalArgumentException("Unknown cipher");
            }
        } else { // Decrypt
            switch (data.cipher) {
                case 1:
                    return decryptRot13(data.message);
                case 2:
                    return decryptAtbash(data.message);
                case 3:
                    return decryptCaesar(data.message, data.shift);
                default:
                    throw new IllegalArgumentException("Unknown cipher");
            }
        }
    }

    public static String encryptRot13(String s) {
        return rot13Transform(s);
    }

    public static String decryptRot13(String s) {
        return rot13Transform(s);
    }

    private static String rot13Transform(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) ('A' + (c - 'A' + 13) % 26));
            } else if (Character.isLowerCase(c)) {
                result.append((char) ('a' + (c - 'a' + 13) % 26));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String encryptAtbash(String s) {
        return atbashTransform(s);
    }

    public static String decryptAtbash(String s) {
        return atbashTransform(s);
    }

    private static String atbashTransform(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) ('Z' - (c - 'A')));
            } else if (Character.isLowerCase(c)) {
                result.append((char) ('z' - (c - 'a')));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String encryptCaesar(String s, int shift) {
        return caesarTransform(s, shift);
    }

    public static String decryptCaesar(String s, int shift) {
        return caesarTransform(s, 26 - shift);
    }

    private static String caesarTransform(String s, int shift) {
        shift = shift % 26;
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) ('A' + (c - 'A' + shift) % 26));
            } else if (Character.isLowerCase(c)) {
                result.append((char) ('a' + (c - 'a' + shift) % 26));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private static String getCypherName(int cipher) {
        switch (cipher) {
            case 1:
                return "ROT13";
            case 2:
                return "Atbash";
            case 3:
                return "Caesar";
            default:
                return "Unknown";
        }
    }

    // Inner class to hold input data
    public static class InputData {
        public int operation; // 1 = Encrypt, 2 = Decrypt
        public int cipher;    // 1 = ROT13, 2 = Atbash, 3 = Caesar
        public String message;
        public int shift;     // Used only for Caesar cipher

        public InputData(int operation, int cipher, String message, int shift) {
            this.operation = operation;
            this.cipher = cipher;
            this.message = message;
            this.shift = shift;
        }
    }
}
