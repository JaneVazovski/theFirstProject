import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class TextDecodingWithKey {

    public static String decodingWithKey () throws IOException {
        System.out.println("Введи адрес файла, который нужно расшифровать: ");
        Scanner console = new Scanner(System.in);
        String fileName = console.nextLine();

        try {
            Path pathOfYourFile = Path.of(fileName);

        } catch (Exception exception) {
            System.out.println("Ты указал несуществующий файл.");
        }

        List<String> stringsOfYourFile = Files.readAllLines(Path.of(fileName));
        String[] strings = new String[stringsOfYourFile.size()];
        stringsOfYourFile.toArray(strings);
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].toUpperCase();
        }
        String s = "";
        for (String variable : strings) {
            s += variable;
        }
        char[] charsOfYourText = s.toCharArray();
        return charsOfYourText.toString();
    }
    public static String decoding() throws IOException {
        String decodedText = "";
        Scanner console = new Scanner(System.in);
        System.out.println("Введи ключ: ");
        int key = console.nextInt();
        for (int i = 0; i < decodingWithKey().length(); i++) {
            int charPosition = Alphabet.fromAlphabet.indexOf(decodingWithKey().charAt(i));
            int keyVal = 33 - (charPosition % 33);
            char replaceVal = Alphabet.fromAlphabet.charAt(keyVal);
            decodedText += replaceVal;
        }
        return decodedText;
    }
    public static void writeDecodedText() throws IOException {
        String str = "\\decoded.txt";
        Path pathToEncryptedText = Path.of(str);
        if (!pathToEncryptedText.isAbsolute()) {
            pathToEncryptedText.toAbsolutePath();
        }
        Files.writeString(pathToEncryptedText, decoding());
    }
}

