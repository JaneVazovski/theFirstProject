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
                TextEncryption.encryption();
                break;

            case 2:
                TextDecodingWithKey.decodingWithKey();
                break;
            case 3:
                System.out.println("Я не знаю как реализовать этот кейс :( ");
                break;
            default:
                System.out.println("Нужно выбрать или 1, или 2.");
        }
    }
}