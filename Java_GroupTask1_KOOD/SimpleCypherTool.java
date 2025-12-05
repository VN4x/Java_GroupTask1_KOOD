import java.util.Scanner;

/**
 * SimpleCypherTool - A basic encryption/decryption tool for beginners
 * Supports ROT13 and Atbash ciphers
 */
public class SimpleCypherTool {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Welcome to Simple Cypher Tool ===\n");

        while (true) {
            // Get user choice
            System.out.println("What would you like to do?");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Exit");
            System.out.print("Choose (1-3): ");
            
            String choice = scanner.nextLine().trim();
            
            if (choice.equals("3")) {
                System.out.println("Goodbye!");
                break;
            }
            
            if (!choice.equals("1") && !choice.equals("2")) {
                System.out.println("Invalid choice! Please enter 1, 2, or 3.\n");
                continue;
            }
            
            boolean isEncrypt = choice.equals("1");
            
            // Get cipher choice
            System.out.println("\nChoose cipher:");
            System.out.println("1. ROT13");
            System.out.println("2. Atbash");
            System.out.print("Choose (1-2): ");
            
            String cipherChoice = scanner.nextLine().trim();
            
            if (!cipherChoice.equals("1") && !cipherChoice.equals("2")) {
                System.out.println("Invalid cipher! Please enter 1 or 2.\n");
                continue;
            }
            
            // Get message from user
            System.out.print("Enter your message: ");
            String message = scanner.nextLine().trim();
            
            if (message.isEmpty()) {
                System.out.println("Message cannot be empty!\n");
                continue;
            }
            
            // Process the message
            String result;
            String cipherName;
            
            if (cipherChoice.equals("1")) {
                result = rot13(message);
                cipherName = "ROT13";
            } else {
                result = atbash(message);
                cipherName = "Atbash";
            }
            
            // Display result
            String operation = isEncrypt ? "Encrypted" : "Decrypted";
            System.out.println("\n--- Result ---");
            System.out.println("Cipher: " + cipherName);
            System.out.println(operation + " message: " + result);
            System.out.println();
        }
    }

    /**
     * ROT13: Shifts each letter by 13 positions in the alphabet
     * A->N, B->O, ..., N->A, O->B, etc.
     * Note: ROT13 is its own inverse (encrypting twice gives original)
     */
    static String rot13(String message) {
        StringBuilder result = new StringBuilder();
        
        for (char c : message.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                // Uppercase letter
                result.append((char) ('A' + (c - 'A' + 13) % 26));
            } else if (c >= 'a' && c <= 'z') {
                // Lowercase letter
                result.append((char) ('a' + (c - 'a' + 13) % 26));
            } else {
                // Not a letter, keep it unchanged
                result.append(c);
            }
        }
        
        return result.toString();
    }

    /**
     * Atbash: Mirrors the alphabet (A<->Z, B<->Y, etc.)
     * Formula: new_char = 'Z' - (old_char - 'A')
     * Note: Atbash is also its own inverse
     */
    static String atbash(String message) {
        StringBuilder result = new StringBuilder();
        
        for (char c : message.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                // Uppercase letter
                result.append((char) ('Z' - (c - 'A')));
            } else if (c >= 'a' && c <= 'z') {
                // Lowercase letter
                result.append((char) ('z' - (c - 'a')));
            } else {
                // Not a letter, keep it unchanged
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
