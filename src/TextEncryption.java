import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.*;

public class TextEncryption {
    public static char[] getYourFileToEncrypt() throws IOException {
        System.out.println("Введи адрес файла, который нужно зашифровать: ");
        Scanner console = new Scanner(System.in);
        String fileName = console.nextLine();
        //Path pathOfFileToEncrypt = Path.of("originalText.txt");
        //System.out.println(Files.exists(pathOfFileToEncrypt));
        try {
            Path pathOfYourFile = Path.of(fileName);
            //System.out.println(Files.exists(pathOfYourFile));
        } catch (Exception exception) {
            System.out.println("Ты указал несуществующий файл.");
        }

        //System.out.println(readAllLines(Path.of(fileName)));
        List<String> stringsOfYourFile = Files.readAllLines(Path.of(fileName));
        String[] strings = new String[stringsOfYourFile.size()];
        stringsOfYourFile.toArray(strings);
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].toUpperCase();
        }
        //System.out.println(Arrays.toString(strings));
        String s = "";
        for (String variable : strings) {
            s += variable;
        }
        char[] charsOfYourText = s.toCharArray();
        return charsOfYourText;
    }

    public static String encryption() throws IOException {
        String yourText = getYourFileToEncrypt().toString();
        String cipherText = "";
        Scanner console = new Scanner(System.in);
        System.out.println("Введи ключ: ");
        int key = console.nextInt();
        for (int i = 0; i < yourText.length(); i++) {
            int charPosition = Alphabet.fromAlphabet.indexOf(yourText.charAt(i));
            int keyVal = (key + charPosition) % 33;
            char replaceVal = Alphabet.fromAlphabet.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
        //writeEncryptedText();
    }
    public static void writeEncryptedText() throws IOException {
        String str = "\\encryptedText.txt";
      Path pathToEncryptedText = Path.of(str);
      if (!pathToEncryptedText.isAbsolute()) {
          pathToEncryptedText.toAbsolutePath();
      }
      Files.writeString(pathToEncryptedText, encryption());
    }
}

































