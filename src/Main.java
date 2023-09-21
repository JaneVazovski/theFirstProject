import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException  {
        Scanner console = new Scanner(System.in);
        System.out.println("Привет! Тебе нужно выбрать режим работы данной программы: \n 1 - шифрование текста; \n 2 - расшифровка текста при известном сдвиге (ключе); \n 3 - расшифровка с помощью brute force.");

        int userChoice = console.nextInt();
        switch (userChoice) {
            case 1:
                TextEncryption.getYourFileToEncrypt();
                break;

            case 2:
                TextEncryption.getYourFileToEncrypt(); //decodingWithKey;
                break;
            case 3:
                TextEncryption.getYourFileToEncrypt(); //decodingWithBruteForce;
                break;
            default:
                System.out.println("Нужно выбрать или 1, или 2, или 3.");
        }
    }
}