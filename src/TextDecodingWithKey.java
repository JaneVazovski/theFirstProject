import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class TextDecodingWithKey {

    public static String decodingWithKey () throws IOException {
        /* в этом методе хотела прочитать файл пользователя и сделать из символов его текста массив(ну или строку),
        чтобы в след. методе уже работать с массивом(строкой) и шифровать(дешифровать)
         */
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
        /* изначально этот метод возвращал массив  зашифрованных символов, но у меня не получалось зашифровать именно массив пользователя,
        (хотя свой алфавит у меня получилось сделать со сдвигом), поэтому этот метод должен возвращать зашифрованную строку,
        скорее всего он не работает, у меня просто нет сил больше с этим сидеть)))
         */
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
        /* этот метод должен был записать полученную зашифрованную строку в отдельный файл, но у меня не получается именно записать так,
        чтобы был только относительный путь, а если будет абсолютный, то, если я правильно поняла, у тебя он не откроется из-за ОС

         */
        String str = "\\decoded.txt";
        Path pathToEncryptedText = Path.of(str);
        if (!pathToEncryptedText.isAbsolute()) {
            pathToEncryptedText.toAbsolutePath();
        }
        Files.writeString(pathToEncryptedText, decoding());
    }
}

