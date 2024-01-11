import java.io.*;
import java.util.Scanner;

public class CaesarCipher {

    //encrypt the file data 
    private static void encryptFile(String inputFile, String outputFile, int key) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) 
        {
            int currentChar;
            while ((currentChar = reader.read()) != -1) 
            {
                if (Character.isLetter(currentChar)) 
                {
                    char base = Character.isUpperCase(currentChar) ? 'A' : 'a';
                    char encryptedChar = (char) ((currentChar - base + key) % 26 + base);
                    writer.write(encryptedChar);
                } 
                else 
                {
                    writer.write(currentChar);
                }
            }
        }
    }
    //decrypt the file data
    private static void decryptFile(String inputFile, String outputFile, int key) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                if (Character.isLetter(currentChar)) {
                    char base = Character.isUpperCase(currentChar) ? 'A' : 'a';
                    char decryptedChar = (char) ((currentChar - base - key + 26) % 26 + base);
                    writer.write(decryptedChar);
                } else {
                    writer.write(currentChar);
                }
            }
        }
    }

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the key for encryption and decryption (a positive integer): ");
        int key = scanner.nextInt();
        // Ensure key is positive
        if (key <= 0) {
            System.out.println("Invalid key. Please enter a positive integer.");
            scanner.close();
            return;
        }
        // Prompt user for input and output file names
        System.out.print("Enter the input file name: ");
        String inputFile = scanner.next();
        System.out.print("Enter the output file name for encryption: ");
        String encryptedOutputFile = scanner.next();
        System.out.print("Enter the output file name for decryption: ");
        String decryptedOutputFile = scanner.next();
        try {

            // Encrypt the file
            encryptFile(inputFile, encryptedOutputFile, key);
            System.out.println("Encryption completed");
            // Decrypt the file
            decryptFile(encryptedOutputFile, decryptedOutputFile, key);
            System.out.println("Decryption completed");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
